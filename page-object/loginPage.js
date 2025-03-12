import { expect } from "@playwright/test"

class loginPage {
    constructor(page) {
        this.page = page
        this.userField = page.getByRole('textbox', { name: 'Username' })
        this.passField = page.getByRole('textbox', { name: 'Password' })
        this.loginBtn = page.getByRole('button', { name: 'Login' })

        this.errorElem = page.locator("//p[text()='Invalid credentials']")
        this.dashboardElem = page.locator("//h6[contains(@class,'oxd-topbar-header-breadcrumb-module')]")
    }

    async goTo(url) {
        await this.page.goto(url)
    }

    async fillLogin(user, pass) {
        await this.userField.type(user)
        await this.passField.type(pass)
        await this.loginBtn.click()
    }

    async login(user, pass) {
        await this.fillLogin(user, pass)
        await expect(this.dashboardElem).toBeVisible()
    }

    async invalidLogin(user, pass) {
        await this.fillLogin(user, pass)
        await expect(this.errorElem).toBeVisible()
    }
}

export default loginPage
