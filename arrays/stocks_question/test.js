import { expect, test } from '@jest/globals';
import sellStock from './stock_seller';

test('is able to identify minimum profit', () => {
    const salesPrices = [1, 3];
    expect(sellStock(salesPrices)).toEqual(2);
});

test('returns 0 when no possible profit', () => {
    const salesPrices = [3, 1];
    expect(sellStock(salesPrices)).toEqual(0);
});

test('handles tricky case where price fluctuates', () => {
    const salesPrice = [1, 3, 2, 5];
    expect(sellStock(salesPrice)).toEqual(4);
});
