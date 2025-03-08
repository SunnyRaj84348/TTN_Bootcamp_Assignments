import apptest.Base;
import org.testng.annotations.Test;
import pages.LoginPage;

public class TestApp extends Base {
    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(getDriver());
    }
}
