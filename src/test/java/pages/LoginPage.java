package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class LoginPage {
    AndroidDriver driver;

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public boolean login() {
        var userElem = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]"));
        var passElem = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]"));

        var loginBtn = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]"));

        userElem.sendKeys("standard_user");
        passElem.sendKeys("secret_sauce");

        loginBtn.click();

        return driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]")).isDisplayed();
    }
}
