package apptest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Base {
    private static AndroidDriver driver;

    protected AndroidDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void appiumDriver() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setPlatformVersion("12");
        options.setDeviceName("realme X7 5G");
        options.setAutomationName("uiAutomator2");

        options.setCapability("noReset", true);
        options.setApp(System.getProperty("user.dir") + "\\src\\main\\resources\\test.apk");

        options.setAppPackage("com.swaglabsmobileapp");
        options.setAppActivity("com.swaglabsmobileapp.MainActivity");

        options.setAppWaitDuration(Duration.ofSeconds(20));
        options.setNewCommandTimeout(Duration.ofMinutes(30));

        options.setCapability("autoGrantPermissions", true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
