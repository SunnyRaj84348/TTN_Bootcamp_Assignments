import apptest.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;

public class TestApp extends Base {
    @Test(priority = 1)
    public void loginTest() {
        LoginPage loginPage = new LoginPage(getDriver());

        boolean isLogin = loginPage.login();
        Assert.assertTrue(isLogin);
    }

    @Test(priority = 2)
    public void cartTest() {
        CartPage cartPage = new CartPage(getDriver());
        boolean isAdded = cartPage.addToCart();
        Assert.assertTrue(isAdded);
    }

    @Test(priority = 3)
    public void checkout() {
        CheckoutPage checkoutPage = new CheckoutPage(getDriver());
        checkoutPage.navigateToCart();
        boolean isCompleted = checkoutPage.checkout();

        Assert.assertTrue(isCompleted);
    }
}
