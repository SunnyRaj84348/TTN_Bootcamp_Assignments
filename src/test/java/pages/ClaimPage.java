package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClaimPage {
    private WebDriver driver;
    private String refID = "";
    private String status = "";

    private WebDriverWait wait;
    private JavascriptExecutor js;

    public ClaimPage(WebDriver driver) {
        this.driver = driver;

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        js = (JavascriptExecutor) driver;
    }

    public void navigateToClaim() {
        driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[10]")).click();
        driver.findElement(By.xpath("(//a[@class='oxd-topbar-body-nav-tab-item'])[1]")).click();
        driver.findElement(By.xpath("(//div[contains(@class, 'oxd-select-text')])[1]")).click();
    }

    public boolean createClaim() {
        var eventOpt = driver.findElement(By.xpath("//div[@class='oxd-select-option']/span[contains(text(),'Accommodation')]"));
        eventOpt.click();

        driver.findElement(By.xpath("(//div[contains(@class, 'oxd-select-text')])[4]")).click();
        var currencyOpt = driver.findElement(By.xpath("//div[@class='oxd-select-option']/span[contains(text(),'Indian')]"));
        currencyOpt.click();

        var remarkInput = driver.findElement(By.xpath("//textarea[contains(@class,'oxd-textarea')]"));
        remarkInput.sendKeys("Some remarks...");

        driver.findElement(By.xpath("//button[contains(@class,'oxd-button') and @type='submit']")).click();

        var refELem = driver.findElement(By.xpath("(//input[contains(@class, 'oxd-input')])[2]"));

        wait.until(d -> {
            refID = (String) js.executeScript("return arguments[0].value", refELem);
            return !refID.isEmpty();
        });

        return !refID.isEmpty();
    }

    public boolean submitClaim() {
        driver.findElement(By.xpath("//button[contains(@class,'orangehrm-sm-button')][3]")).click();

        var statusInp = driver.findElement(By.xpath("(//input[contains(@class,'oxd-input')])[4]"));

        wait.until(d -> {
            status = (String) js.executeScript("return arguments[0].value", statusInp);
            return !refID.isEmpty();
        });

        return !status.isEmpty();
    }

    public boolean verifyClaim() {
        driver.findElement(By.xpath("(//a[contains(@class, 'oxd-topbar-body-nav-tab-item')])[2]")).click();
        var refELem = driver.findElement(By.xpath("//div[contains(text(),'" + refID + "')]"));

        return refELem.getText().equals(refID);
    }
}
