package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClaimPage {
    private WebDriver driver;

    public ClaimPage(WebDriver driver) {
        this.driver = driver;
    }

    public void submit() {
        driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[10]")).click();
        driver.findElement(By.xpath("(//a[@class='oxd-topbar-body-nav-tab-item'])[1]")).click();
        driver.findElement(By.xpath("(//div[contains(@class, 'oxd-select-text')])[1]")).click();

        var eventOpt = driver.findElement(By.xpath("//div[@class='oxd-select-option']/span[contains(text(),'Accommodation')]"));
        eventOpt.click();

        driver.findElement(By.xpath("(//div[contains(@class, 'oxd-select-text')])[4]")).click();
        var currencyOpt = driver.findElement(By.xpath("//div[@class='oxd-select-option']/span[contains(text(),'Indian')]"));
        currencyOpt.click();
    }
}
