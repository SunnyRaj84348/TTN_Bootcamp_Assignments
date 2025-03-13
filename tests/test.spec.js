// @ts-check
import { test } from '@playwright/test';
import ItemPage from '../pages/ItemPage';

test('test', async ({ page }) => {
    const itemPage = new ItemPage(page)
    await itemPage.goto()
    await itemPage.addToCart()
});
