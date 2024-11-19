import { getTop10FileExtensionTypesWithDot } from "./filelib";

test('returns non empty array', () => {
    expect(getTop10FileExtensionTypesWithDot().length).toBeGreaterThan(0);
});

test('returns array of strings', () => {
    expect(getTop10FileExtensionTypesWithDot().every((item) => typeof item === 'string')).toBe(true);
});

test('returns array of strings with length 10', () => {
    expect(getTop10FileExtensionTypesWithDot().length).toBe(10);
});

test('returns array of strings compliant with regex', () => {
    expect(getTop10FileExtensionTypesWithDot().every((item) => /^\.\w+$/i.test(item))).toBe(true);
});

test('returns array of unique strings', () => { 
    expect(getTop10FileExtensionTypesWithDot().every((item, index, array) => array.indexOf(item) === index)).toBe(true); 
});