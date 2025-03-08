import apptest.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class TestApp extends Base {
    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(getDriver());

        boolean isLogin = loginPage.login();
        Assert.assertTrue(isLogin);
    }
}
