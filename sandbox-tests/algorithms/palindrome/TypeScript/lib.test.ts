import { checkIfNumberIsPalindrome } from "./lib";

test("return true if number is Palindrome", () => {
    expect(checkIfNumberIsPalindrome(121)).toBe(true);
});

test("return false if number is not Palindrome", () => {
    expect(checkIfNumberIsPalindrome(123)).toBe(false);
});