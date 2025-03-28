import { passwordValidator } from './passwordValidator';

describe('passwordValidator', () => {
    test('valid passwords', () => {
        expect(passwordValidator.isValidPassword('Password1#')).toBe(true);
        expect(passwordValidator.isValidPassword('StrongPass123$')).toBe(true);
        expect(passwordValidator.isValidPassword('Good#Pass1')).toBe(true);
        expect(passwordValidator.isValidPassword('Valid1@Pass')).toBe(true);
    });

    test('invalid passwords', () => {
        expect(passwordValidator.isValidPassword('Pass1!')).toBe(false);
        expect(passwordValidator.isValidPassword('password1!')).toBe(false);
        expect(passwordValidator.isValidPassword('PASSWORD1!')).toBe(false);
        expect(passwordValidator.isValidPassword('Password!')).toBe(false);
        expect(passwordValidator.isValidPassword('Password1')).toBe(false);
        expect(passwordValidator.isValidPassword('Password 1!')).toBe(false);
        expect(passwordValidator.isValidPassword(null)).toBe(false);
    });
});