package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class CartPage {
    AndroidDriver driver;

    public CartPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public boolean addToCart() {
        var cartBtn = driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@text='Sauce Labs Backpack']/following-sibling::android.view.ViewGroup)[3]"));
        cartBtn.click();

        String cartBtnName = driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@text='Sauce Labs Backpack']/following-sibling::android.view.ViewGroup)[2]/android.widget.TextView")).getDomAttribute("text");
        return cartBtnName.equals("REMOVE");
    }
}
