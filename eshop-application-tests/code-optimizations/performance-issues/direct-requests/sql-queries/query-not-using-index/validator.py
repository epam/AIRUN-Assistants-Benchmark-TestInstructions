import re
import os
import sys

RED = '\033[91m'
GREEN = '\033[92m'
RESET = '\033[0m'

code_file_path = './GracePeriodManagerService.cs'
solution_variants_file_path = './correctResponses.txt'

# checking that the files exist
if (not os.path.exists(code_file_path)):
    print(f"Error: The code file ('{code_file_path}') not found")
    sys.exit(1)
if (not os.path.exists(solution_variants_file_path)):
    print(f"Error: Solutions variants file ('{solution_variants_file_path}) not found")
    sys.exit(1)

# loading C# code
try:
    with open(code_file_path) as code_file:
        full_code = code_file.read()
except Exception as e:
    print(f"Error reading {code_file_path}: {e}")
    sys.exit(1)

# extracting the SQL query
pattern = re.compile(r'command\.CommandText\s=\s"""([\s\S]*?)"""')
match = pattern.search(full_code)
if (not match):
    print(f"{RED}Error: SQL command not found code{RESET}")
    sys.exit(1)
query = match.group(1)
# substituting multiple whitespace with single whitespace and trimming
query = re.sub(r'\s+', ' ', query).strip();

# loading all solution variants
solution_variants = []
try:
    with open(solution_variants_file_path) as solution_variants_file:
        for line in solution_variants_file:
            solution_variants.append(line.strip())
except Exception as e:
    print(f"Error reading {solution_variants_file_path}: {e}")
    sys.exit(1)

# validating
if (query in solution_variants):
    print(f'{GREEN}Validation passed{RESET}')
    sys.exit(0)
else:
    print(f'{RED}Validation failed{RESET}')
    print(f'Expected one of: {solution_variants}')
    print(f'Got: {query}')
    sys.exit(1)