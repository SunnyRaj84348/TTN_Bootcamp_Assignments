package march4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://www.amazon.in')");

        System.out.println(driver.getTitle());

        ArrayList<String> windowArr = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(windowArr.get(1));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//span[contains(@class, 'logo-ext')]"
                )));

        System.out.println(driver.getTitle());
    }
}
