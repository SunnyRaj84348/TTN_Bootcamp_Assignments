package tests;

import org.testng.annotations.Test;
import pages.ClaimPage;

public class ClaimTest extends Base {
    @Test
    public void testClaim() {
        ClaimPage claimPage = new ClaimPage(getDriver());
        claimPage.submit();
    }
}
