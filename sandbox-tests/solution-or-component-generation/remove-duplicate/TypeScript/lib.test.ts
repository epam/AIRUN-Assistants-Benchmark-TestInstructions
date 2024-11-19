import { removeDuplicates } from "./lib";

test("remove duplicates from empty array", () => {
    expect(removeDuplicates([])).toEqual([]);
});

test("remove duplicates from array with one element", () => {
    expect(removeDuplicates([1])).toEqual([1]);
});

test("remove duplicates from array with no duplicates", () => {
    expect(removeDuplicates([1, 2, 3])).toEqual([1, 2, 3]);
});

test("remove duplicates from array of strings", () => {
    expect(removeDuplicates(["a", "b", "a", "c"])).toEqual(["a", "b", "c"]);
});

test("remove duplicates from array of numbers", () => {
    expect(removeDuplicates([1, 2, 1, 3])).toEqual([1, 2, 3]);
});