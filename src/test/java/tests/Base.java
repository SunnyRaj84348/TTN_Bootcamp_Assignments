package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class Base {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeTest
    public void setup() {
        if (driver == null) {
            driver = new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterTest
    public void cleanUp() {
        driver.quit();
    }
}
