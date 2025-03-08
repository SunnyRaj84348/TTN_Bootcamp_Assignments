package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class CheckoutPage {
    AndroidDriver driver;

    public CheckoutPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void navigateToCart() {
        driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='test-Cart']")).click();
    }

    public boolean checkout() {
        driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='test-CHECKOUT']")).click();

        var fNameInp = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc='test-First Name']"));
        var lNameInp = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc='test-Last Name']"));
        var zipInp = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc='test-Zip/Postal Code']"));

        fNameInp.sendKeys("Sunny");
        lNameInp.sendKeys("Raj");
        zipInp.sendKeys("201304");

        driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='test-CONTINUE']")).click();

        driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='test-FINISH']")).click();

        return driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='CHECKOUT: COMPLETE!']")).isDisplayed();
    }
}