// Write a Selenium Script and perform below operations.
// 1. Open a Chrome Browser, and hit https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
// 2. Fetch and Print the text "Forgot your password?" visible on the page.
// 3. By adding username and password
// 4. Wait for the clickability of Login button
// 5. Click on Login Button
// 6. Fetch and Print title of the page.
// 7. Print <h6> of the page that is text "Dashboard"
// 8. Close the browser

package march3;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement pwF = driver.findElement(By.xpath("//div[@class='orangehrm-login-forgot']/p[contains(@class, 'oxd-text')]"));
        WebElement userField = driver.findElement(By.xpath("//form//input[@name='username']"));
        WebElement passField = driver.findElement(By.xpath("//form//input[@name='password']"));

        System.out.println(pwF.getText());

        userField.sendKeys("Admin");
        passField.sendKeys("admin123");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'orangehrm-login-button')]")));

        loginBtn.click();

        System.out.println(driver.getTitle());

        WebElement dashElem = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
        System.out.println(dashElem.getText());

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(screenshotFile.toPath(), Path.of("screenshot.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}
