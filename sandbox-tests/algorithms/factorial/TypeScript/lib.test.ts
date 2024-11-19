import { factorial } from "./lib";

test("return factorial of 0", () => {
    expect(factorial(0)).toBe(1);
});

test("return factorial of 1", () => {
    expect(factorial(1)).toBe(1);
});

test("return factorial of 5", () => {
    expect(factorial(5)).toBe(120);
});

test("return factorial of 7", () => {
    expect(factorial(7)).toBe(5040);
});
