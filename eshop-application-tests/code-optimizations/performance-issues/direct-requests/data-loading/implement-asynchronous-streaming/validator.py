import os
import sys
import validator_utils

RED = '\033[91m'
GREEN = '\033[92m'
RESET = '\033[0m'

code_file_path = './GracePeriodManagerService.cs'


def validate(code: str) -> bool:
    validation_failed = False

    # validating that method GetConfirmedGracePeriodOrders was removed
    getConfirmedGracePeriodOrders_method = validator_utils.extract_csharp_method(code, 'GetConfirmedGracePeriodOrders')
    if getConfirmedGracePeriodOrders_method is not None:
        print(f'{RED}Method GetConfirmedGracePeriodOrders was not removed.{RESET}')
        validation_failed = validation_failed or True
    
    # validating that method CheckConfirmedGracePeriodOrders has a correct await foreach loop enclosed in a try-catch block
    checkConfirmedGracePeriodOrders_method = validator_utils.extract_csharp_method(code, 'CheckConfirmedGracePeriodOrders')
    if checkConfirmedGracePeriodOrders_method is None:
        print(f'{RED}Method CheckConfirmedGracePeriodOrders was removed.{RESET}')
        validation_failed = validation_failed or True
    else:
        checkConfirmedGracePeriodOrders_method_single_spacing = validator_utils.clean_extra_whitespace(checkConfirmedGracePeriodOrders_method)
        if 'try { await foreach (var orderId in StreamConfirmedGracePeriodOrders())' not in checkConfirmedGracePeriodOrders_method_single_spacing:
            print(f'{RED}Method CheckConfirmedGracePeriodOrders does not include a correct call to StreamConfirmedGracePeriodOrders inside an enclosing try block.{RESET}')
            validation_failed = validation_failed or True
        if 'await eventBus.PublishAsync(confirmGracePeriodEvent); } } catch' not in checkConfirmedGracePeriodOrders_method_single_spacing:
            print(f'{RED}Method CheckConfirmedGracePeriodOrders does not catch exceptions from StreamConfirmedGracePeriodOrders.{RESET}')
            validation_failed = validation_failed or True
    
    # validating that method StreamConfirmedGracePeriodOrders was added, has correct signature, implements async streaming, does not include a try block
    # note: not validating whether `await using` is used instead of `using`, as the original methods also used simply `using` in an async method
    # note: not validating whether `yield return` is inside a `try` block with a related `catch` block, as it will be caught by the compiler
    streamConfirmedGracePeriodOrders = validator_utils.extract_csharp_method(code, 'StreamConfirmedGracePeriodOrders')
    if streamConfirmedGracePeriodOrders is None:
        print(f'{RED}Method StreamConfirmedGracePeriodOrders was not added.{RESET}')
        validation_failed = validation_failed or True
    else:
        streamConfirmedGracePeriodOrders_single_spacing = validator_utils.clean_extra_whitespace(streamConfirmedGracePeriodOrders)
        if 'private async IAsyncEnumerable<int> StreamConfirmedGracePeriodOrders()' not in streamConfirmedGracePeriodOrders_single_spacing:
            print(f'{RED}Method StreamConfirmedGracePeriodOrders does not have a correct signature.{RESET}')
            validation_failed = validation_failed or True
        if 'yield return reader.GetInt32(0);' not in streamConfirmedGracePeriodOrders_single_spacing:
            print(f'{RED}Method StreamConfirmedGracePeriodOrders does not implement asynchronous streaming correctly.{RESET}')
            validation_failed = validation_failed or True
    
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
