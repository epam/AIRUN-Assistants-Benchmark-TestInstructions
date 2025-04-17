import re

def extract_csharp_method(csharp_class: str, method_name: str) -> str:
    # Escape special characters in the method name for regex
    escaped_method_name = re.escape(method_name)
    
    # Regex pattern to find the method declaration and opening brace
    pattern = re.compile(
        rf'''
        (?:^\s*\[.*?\]\s*)*                    # Optional attributes
        (?:                                     # Modifiers (e.g., public, static)
            (?:public|private|protected|internal|static|async|override|virtual|abstract|sealed|unsafe|partial|new)\s+
        )*
        ([\w<>]+\??)\s+                        # Return type (e.g., "void", "Task<int>")
        (\b{escaped_method_name}\b)            # Method name (exact match)
        \s*\([^)]*\)\s*                        # Parameters
        (?::\s*base\s*\([^)]*\))?              # Optional constructor initializer
        \s*{{                                   # Opening brace
        ''',
        re.DOTALL | re.VERBOSE | re.MULTILINE
    )
    
    match = pattern.search(csharp_class)
    if not match:
        return None
    
    # Find the opening brace position
    start_pos = match.start()
    brace_pos = csharp_class.find('{', start_pos)
    if brace_pos == -1:
        return None
    
    # Track brace balance to find the method's end
    balance = 1
    current_pos = brace_pos + 1
    end_pos = None
    
    while current_pos < len(csharp_class) and balance > 0:
        if csharp_class[current_pos] == '{':
            balance += 1
        elif csharp_class[current_pos] == '}':
            balance -= 1
        if balance == 0:
            end_pos = current_pos + 1  # Include the closing brace
            break
        current_pos += 1
    
    return csharp_class[start_pos:end_pos] if end_pos is not None else None

def clean_extra_whitespace(text: str) -> str:
    return re.sub(r'\s+', ' ', text).strip()