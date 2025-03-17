// @ts-check
import { test } from '@playwright/test';
import ItemPage from '../pages/ItemPage';

test('test', async ({ page, context }) => {
    const itemPage = new ItemPage(page, context)
    await itemPage.goto()
    await itemPage.addToCart()
});
