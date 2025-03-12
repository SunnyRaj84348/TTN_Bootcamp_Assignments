import loginPage from "./loginPage"
import claimPage from "./claimPage"

class POManager {
    constructor(page) {
        this.page = page

        this.loginPage = new loginPage(this.page)
        this.claimPage = new claimPage(this.page)
    }

    getLoginPage() {
        return this.loginPage
    }

    getClaimPage() {
        return this.claimPage
    }
}

export default POManager
