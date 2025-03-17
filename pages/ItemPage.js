import { log } from "console"

class ItemPage {
    constructor(page, context) {
        this.page = page
        this.context = context

        this.acSection = page.locator("//a[@aria-label='ACs']")
        this.productSections = page.locator("//div[@role='listitem'][position() <= 2]")

        this.productTitles = []
    }

    async goto() {
        await this.page.goto("https://www.amazon.in")
        await this.acSection.click()
    }

    async addToCart() {
        await this.productSections.first().waitFor()

        for (const productSection of await this.productSections.all()) {
            const productLink = productSection.locator("//a")

            const [newPage] = await Promise.all([
                this.context.waitForEvent('page'),
                productLink.first().click()
            ])

            await newPage.bringToFront()

            const productTitle = newPage.locator("//span[@id='productTitle']")
            this.productTitles.push(await productTitle.textContent())

            const addCart = newPage.locator("//input[@id='add-to-cart-button']").nth(1)
            await addCart.click()

            await newPage.close()
            await this.page.bringToFront()
        }
    }
}

export default ItemPage
