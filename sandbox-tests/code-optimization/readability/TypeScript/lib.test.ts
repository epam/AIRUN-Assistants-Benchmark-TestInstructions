import { calculateDiscount } from "./lib";

describe('calculateDiscount', () => {
    it('should calculate discount for STUDENT on a non-holiday', () => {
        const discount = calculateDiscount(100, 'STUDENT', false);
        expect(discount.rate).toEqual(10);
        expect(discount.userType).toEqual('STUDENT');
        expect(discount.isHoliday).toEqual(false);
    });

    it('should calculate discount for STUDENT on a holiday', () => {
        const discount = calculateDiscount(100, 'STUDENT', true);
        expect(discount.rate).toEqual(15);
        expect(discount.userType).toEqual('STUDENT');
        expect(discount.isHoliday).toEqual(true);
    });

   it('should calculate discount for SENIOR on a non-holiday', () => {
        const discount = calculateDiscount(100, 'SENIOR', false);
        expect(discount.rate).toEqual(15);
        expect(discount.userType).toEqual('SENIOR');
        expect(discount.isHoliday).toEqual(false);
    });

    it('should calculate discount for SENIOR on a holiday', () => {
        const discount = calculateDiscount(100, 'SENIOR', true);
        expect(discount.rate).toEqual(20);
        expect(discount.userType).toEqual('SENIOR');
        expect(discount.isHoliday).toEqual(true);
    });

    it('should calculate discount for EMPLOYEE on a non-holiday', () => {
        const discount = calculateDiscount(100, 'EMPLOYEE', false);
        expect(discount.rate).toEqual(20);
        expect(discount.userType).toEqual('EMPLOYEE');
        expect(discount.isHoliday).toEqual(false);
    });

    it('should calculate discount for EMPLOYEE on a holiday', () => {
        const discount = calculateDiscount(100, 'EMPLOYEE', true);
        expect(discount.rate).toEqual(25);
        expect(discount.userType).toEqual('EMPLOYEE');
        expect(discount.isHoliday).toEqual(true);
    });
});