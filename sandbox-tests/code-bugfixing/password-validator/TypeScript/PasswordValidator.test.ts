import { PasswordValidator } from './PasswordValidator';

describe('PasswordValidator', () => {
    test('valid passwords', () => {
        expect(PasswordValidator.isValidPassword('Password1!')).toBe(true);
        expect(PasswordValidator.isValidPassword('StrongPass123$')).toBe(true);
        expect(PasswordValidator.isValidPassword('Good#Pass1')).toBe(true);
        expect(PasswordValidator.isValidPassword('Valid1@Pass')).toBe(true);
    });

    test('invalid passwords', () => {
        expect(PasswordValidator.isValidPassword('Pass1!')).toBe(false); // Less than 8 characters
        expect(PasswordValidator.isValidPassword('password1!')).toBe(false); // No uppercase letter
        expect(PasswordValidator.isValidPassword('PASSWORD1!')).toBe(false); // No lowercase letter
        expect(PasswordValidator.isValidPassword('Password!')).toBe(false); // No number
        expect(PasswordValidator.isValidPassword('Password1')).toBe(false); // No special character
        expect(PasswordValidator.isValidPassword('Password 1!')).toBe(false); // Contains whitespace
        expect(PasswordValidator.isValidPassword(null)).toBe(false); // Null password
    });
});