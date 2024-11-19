import { fibonacci } from "./lib";

test("return fibonacci number", () => {
    expect(fibonacci(0)).toBe(0);
});

test("return fibonacci number", () => {
    expect(fibonacci(1)).toBe(1);
});

test("return fibonacci number", () => {
    expect(fibonacci(6)).toBe(8);
});
