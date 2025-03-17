class CartPage {
    constructor(page, addedProducts) {
        this.page = page
        this.addedProducts = addedProducts
        this.cartBtn = page.locator("//a[@id='nav-cart']")
        this.productTitlesSpan = page.locator("//a[contains(@class, 'sc-product-title')]//span[@class='a-truncate-cut']")
    }

    async goto() {
        await this.cartBtn.click()
    }

    async verifyItems() {
        await this.productTitlesSpan.first().waitFor()
        const productTitles = await this.productTitlesSpan.allTextContents()

        // console.log(productTitles);
        // console.log(this.addedProducts);
    }
}

export default CartPage
