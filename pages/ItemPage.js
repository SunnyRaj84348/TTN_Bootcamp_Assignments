class ItemPage {
    constructor(page) {
        this.page = page

        this.acSection = page.locator("//a[@aria-label='ACs']")
        this.productSections = page.locator("//div[@role='listitem'][position() <= 2]")
    }

    async goto() {
        await this.page.goto("https://www.amazon.in")
        await this.acSection.click()
    }

    async addToCart() {
        await this.productSections.first().waitFor()

        for (const productSection of await this.productSections.all()) {
            const productLink = productSection.locator("//a")
            await productLink.first().click()
        }
    }
}

export default ItemPage
