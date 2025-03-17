// @ts-check
import { test } from '@playwright/test';
import ItemPage from '../pages/ItemPage';
import CartPage from '../pages/CartPage';

test('test', async ({ page, context }) => {
    const itemPage = new ItemPage(page, context)
    await itemPage.goto()
    await itemPage.addToCart()

    const cartPage = new CartPage(page, itemPage.productTitles)
    await cartPage.goto()
    await cartPage.verifyItems()
});
