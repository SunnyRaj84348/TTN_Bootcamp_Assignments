package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ClaimPage;

public class ClaimTest extends Base {
    ClaimPage claimPage;

    @Test
    public void testClaimCreation() {
        claimPage = new ClaimPage(getDriver());
        claimPage.navigateToClaim();
        boolean isCreated = claimPage.createClaim();

        Assert.assertTrue(isCreated);
    }

    @Test
    public void testClaimSubmit() {
        boolean isSubmitted = claimPage.submitClaim();
        Assert.assertTrue(isSubmitted);
    }

    @Test
    public void testMyClaim() {
        boolean refExists = claimPage.verifyClaim();
        Assert.assertTrue(refExists);
    }
}
