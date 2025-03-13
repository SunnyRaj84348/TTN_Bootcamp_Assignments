import { test } from '@playwright/test';
import POManager from "../page-object/POManager"

import * as data from "../resources/data/userLogin.json"
import genRandom from '../utils/utilities';

test('test', async ({ page }) => {
  const poManager = new POManager(page)

  const loginPage = poManager.getLoginPage()
  const claimPage = poManager.getClaimPage()

  await loginPage.goTo("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
  await loginPage.login(data.valid.user, data.valid.pass)

  await claimPage.goTo()
  await claimPage.createClaim()
  await claimPage.submitClaim()
});

test('invalid login', async ({ page }) => {
  const poManager = new POManager(page)

  const loginPage = poManager.getLoginPage()
  await loginPage.goTo("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
  await loginPage.invalidLogin(data.invalid.user, data.invalid.pass)
});

test('invalid login using random username and password', async ({ page }) => {
  const poManager = new POManager(page)

  const loginPage = poManager.getLoginPage()
  await loginPage.goTo("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
  await loginPage.invalidLogin(genRandom(), genRandom())
})
