import { serializeToCsv } from "./csvService";

test('returns empty string when no data is provided', () => {
    expect(serializeToCsv([{}])).toMatch(/^$|\n$/);
});

test('returns rows including header when data is provided', () => {
    const data = [{ id: 1, name: 'John' }];
    expect(serializeToCsv(data)).toMatch(/^id,name\n1,John\n?$/);
});

test('returns rows with custom delimiter', () => {
    const data = [{ id: 1, name: 'John' }];
    expect(serializeToCsv(data, true, ';')).toMatch(/^id;name\n1;John\n?$/);
});

test('returns a row with no header', () => {
    const data = [{ id: 1, name: 'John' }];
    expect(serializeToCsv(data, false)).toMatch(/^1,John\n?$/);
});