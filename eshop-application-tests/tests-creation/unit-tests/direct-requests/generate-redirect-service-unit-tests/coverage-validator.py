import os
import sys
import xml.etree.ElementTree as ET

RED = '\033[91m'
GREEN = '\033[92m'
RESET = '\033[0m'

coverage_file_path = './coverage.cobertura.xml'
method_name = 'ExtractRedirectUriFromReturnUrl'


# checking that the files exist
if (not os.path.exists(coverage_file_path)):
    print(f"{RED}Error: The coverage file ('{coverage_file_path}') not found{RESET}")
    sys.exit(1)


try:
    tree = ET.parse('coverage.cobertura.xml')
    root = tree.getroot()
    method = root.find(f'.//method[@name="{method_name}"]')

    if method is None:
        print(f"{RED}Error: The coverage file does not contain coverage for method '{method_name}'.{RESET}")
        sys.exit(1)

    line_rate = float(method.get('line-rate', 0)) * 100
    branch_rate = float(method.get('branch-rate', 0)) * 100

    if line_rate < 100.0 or branch_rate < 100.0:
        print(f"{RED}Error: The coverage for method '{method_name}' is not 100% (line-rate: {line_rate}%, branch-rate: {branch_rate}%).{RESET}")
        sys.exit(1)

    print(f"{GREEN}Validation passed: Coverage is 100% (line-rate: {line_rate}%, branch-rate: {branch_rate}%).{RESET}")

except ET.ParseError:
    print(f"{RED}Error: The coverage file ('{coverage_file_path}') is not a valid XML file.{RESET}")
    sys.exit(1)
except Exception as e:
    print(f"{RED}Error reading the coverage file ('{coverage_file_path}'): {e}{RESET}")
    sys.exit(1)