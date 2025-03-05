package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends Base {
    @Test
    public void testLogin() {
        getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login();

        Assert.assertTrue(getDriver().findElement(By.className("oxd-topbar-header")).isDisplayed());
    }
}
