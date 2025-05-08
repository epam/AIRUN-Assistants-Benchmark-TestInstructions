import json
import os
import sys
import urllib.parse
import urllib.request

RED = '\033[91m'
GREEN = '\033[92m'
RESET = '\033[0m'

dev_appsettings_file_path = r'./appsettings.Development.json'
extract_redirect_endpoint = '/api/extract-redirect'
extract_redirect_url = f'http://localhost:5223{extract_redirect_endpoint}'
blacklisted_url = 'https://certainlyblacklisteddomain.com/blacklisted-path'


def extract_whitelisted_url(file_path: str) -> str:
    # the settings file exists (it was checked before)
    # it contains exactly one array of whitelisted URLs
    # the name of the array may be different but it is irrelevant anyway
    # extracting the first URL from the array and returning it

    with open(file_path, 'r') as settings_file:
        config = json.load(settings_file)

    def find_list(data):
        if isinstance(data, list):
            if not data:
                raise ValueError("Settings file contains an empty whitelisted URL list")
            return data[0]
        if isinstance(data, dict):
            for value in data.values():
                try:
                    return find_list(value)
                except ValueError:
                    continue
            raise ValueError("Settings file does not contain a whitelisted URL list")
        raise ValueError("Settings file does not contain a whitelisted URL list")

    return find_list(config)


def test_url(url: str, expected_response: str) -> bool:
    # building request URL
    url = f"https://trusted.com?redirect_uri={url}"
    params = urllib.parse.urlencode({'url': url})
    request_url = f"{extract_redirect_url}?{params}"
    print(f"Requesting '{request_url}'...")

    try:
        # sending the request
        with urllib.request.urlopen(request_url) as response:
            result = response.read().decode('utf-8')
            status = response.getcode()

            if status == 200:
                if result == expected_response:
                    return True
                else:
                    print(f"Unexpected response: '{result}', expected: '{expected_response}'")
                    return False
            else:
                print(status)
                return False
            
    except urllib.error.HTTPError as e:
        print(f"HTTP error: {e.code} - {e.reason}")
        return False
    except urllib.error.URLError as e:
        print(f"URL error: {e.reason}")
        return False



# checking that the settings file exists
if (not os.path.exists(dev_appsettings_file_path)):
    print(f"{RED}Error: The settings file ('{dev_appsettings_file_path}') not found{RESET}")
    sys.exit(1)

try:
    # extracting a whitelisted URL from the settings file
    print("Extracting a whitelisted URL...")
    whitelisted_url = extract_whitelisted_url(dev_appsettings_file_path)
    print(f"  {whitelisted_url} extracted.")

    # running the integration test using the whitelisted URL
    if not test_url(whitelisted_url, whitelisted_url):
        print(f"{RED}Validation failed{RESET}")
        sys.exit(1)

    # running the integration test using the whitelisted URL
    if not test_url(blacklisted_url, ''):
        print(f"{RED}Validation failed{RESET}")
        sys.exit(1)

except Exception as e:
    print(f"Error: {e}")
    print(f"{RED}Validation failed{RESET}")
    sys.exit(1)

print(f"{GREEN}Validation passed{RESET}")
sys.exit(0)
