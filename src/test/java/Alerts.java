import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Alerts extends BrowserManager {

    public static void main(String[] args) throws IOException {
//        showPromtBoxButton();
//        showPromtBoxButtonError();
    }

    @Test
    public static void showPromtBoxButton() {
        RemoteWebDriver driver = null;
        try {
            driver = BrowserManager.getRemoteWebdriver();
            driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");
            WebElement promptExample = driver.findElement(By.id("promptexample"));
            promptExample.click();
            Alert alert = driver.switchTo().alert();
            alert.sendKeys("hello");
            alert.accept();
            WebElement promptExplanation = driver.findElement(By.id("promptexplanation"));
            Actions actions = new Actions(driver);
            actions.moveToElement(promptExplanation).build().perform();
        } catch (Exception | Error e) {
            System.out.println("A aparut o eroare");
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    @Test
    public static void showPromtBoxButtonError() throws IOException {
        RemoteWebDriver driver = null;
        try {
            driver = BrowserManager.getRemoteWebdriver();
            driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");
            WebElement promptExample = driver.findElement(By.id("promptexample"));
            promptExample.click();
            Alert alert = driver.switchTo().alert();
            alert.sendKeys("hello");
            alert.accept();
            WebElement promptExplanation = driver.findElement(By.id("promptexplanationn"));
            Actions actions = new Actions(driver);
            actions.moveToElement(promptExplanation).build().perform();
        } catch (Exception | Error e) {
            System.out.println("A aparut o eroare");
        } finally {
            File file = driver.getScreenshotAs(OutputType.FILE);
            File destFile = new File("C:\\ProiectJava\\poza.png");
            FileUtils.copyFile(file, destFile);
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
