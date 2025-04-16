import os
import re
import sys
import validator_utils

RED = '\033[91m'
GREEN = '\033[92m'
RESET = '\033[0m'

code_file_path = './GracePeriodManagerService.cs'


def phrase_present(line: str, word: str) -> bool:
    pattern = r'\b{}\b'.format(re.escape(word))
    return bool(re.search(pattern, line))


def validate(code: str) -> bool:
    validation_failed = False

    # extracting method GetConfirmedGracePeriodOrders (it's the only applicable for this test)
    getConfirmedGracePeriodOrders_method = validator_utils.extract_csharp_method(code, 'GetConfirmedGracePeriodOrders')
    if getConfirmedGracePeriodOrders_method is None:
        print(f'{RED}Cannot find method GetConfirmedGracePeriodOrders.{RESET}')
        validation_failed = validation_failed or True
    else:
        validator_utils.clean_extra_whitespace(getConfirmedGracePeriodOrders_method)
        lines = getConfirmedGracePeriodOrders_method.splitlines()
        for line in lines:
            if phrase_present(line, 'using') and not phrase_present(line, 'await using'):
                print(f'{RED}using not changed to await using on the following line:{RESET}')
                print(f'{RED}  {line}{RESET}')
                validation_failed = True
    
    return not validation_failed


# checking that the files exist
if (not os.path.exists(code_file_path)):
    print(f"Error: The code file ('{code_file_path}') not found")
    sys.exit(1)

# loading C# code
try:
    with open(code_file_path) as code_file:
        full_code = code_file.read()
except Exception as e:
    print(f"Error reading {code_file_path}: {e}")
    sys.exit(1)

# validating
validation_passed = validate(full_code)

# outputting validation results
if validation_passed:
    print(f'{GREEN}Validation passed{RESET}')
    sys.exit(0)
else:
    print(f'{RED}Validation failed{RESET}')
    sys.exit(1)
