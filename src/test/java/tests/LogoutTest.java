package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogoutPage;

public class LogoutTest extends Base {
    @Test
    public void testLogout() {
        LogoutPage logoutPage = new LogoutPage(getDriver());
        var isLogout = logoutPage.logout();

        Assert.assertTrue(isLogout);
    }
}
