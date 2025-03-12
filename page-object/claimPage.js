class claimPage {
    constructor(page) {
        this.page = page

        this.claimTab = page.getByRole('link', { name: 'Claim' })
        this.submitTab = page.getByRole('link', { name: 'Submit Claim' })

        this.eventDropdown = page.locator('form i').first()
        this.accomOption = page.getByRole('option', { name: 'Accommodation' })

        this.currencyDropdown = page.locator('form i').nth(1)
        this.currencyOption = page.getByRole('option', { name: 'Albanian Lek' })

        this.createClaimBtn = page.getByRole('button', { name: 'Create' })
        this.submitClaimBtn = page.getByRole('button', { name: 'Submit' })
    }

    async goTo() {
        await this.claimTab.click()
        await this.submitTab.click()
    }

    async createClaim() {
        await this.eventDropdown.click()
        await this.accomOption.click()

        await this.currencyDropdown.click()
        await this.currencyOption.click()

        await this.createClaimBtn.click()
    }

    async submitClaim() {
        await this.submitClaimBtn.click()
    }
}

export default claimPage
