import com.sun.jna.WString;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class Windows {

    public static void main(String[] args) throws IOException {

//        basicAjaxInNewPage();
//        basicAjaxInNewPageError();
    }
@Test
    public static void basicAjaxInNewPage() {
        RemoteWebDriver driver = null;
        try {
            driver = null;
            driver = BrowserManager.getRemoteWebdriver();
            driver.get("https://testpages.herokuapp.com/styled/windows-test.html");
            driver.findElement(By.id("gobasicajax")).click();
            String parentWindow = driver.getWindowHandle();
            Set<String> windowHandles = driver.getWindowHandles();
            for (String window : windowHandles) {
                if (!window.equals(parentWindow)) {
                    driver.switchTo().window(window);
                    break;
                }
            }
            Select category = new Select(driver.findElement(By.id("combo1")));
            category.selectByIndex(1);

            Select language = new Select(driver.findElement(By.id("combo2")));
            language.selectByIndex(2);

            driver.findElement(By.name("submitbutton")).click();
        } catch (Exception | Error e) {
            System.out.println("Exista o eroare");
        } finally {
            if (driver != null){
                driver.quit();
            }
        }
    }
@Test
    public static void basicAjaxInNewPageError() throws IOException {
        RemoteWebDriver driver = null;
        try {
            driver = null;
            driver = BrowserManager.getRemoteWebdriver();
            driver.get("https://testpages.herokuapp.com/styled/windows-test.html");
            driver.findElement(By.id("gobasicajax")).click();
            String parentWindow = driver.getWindowHandle();
            Set<String> windowHandles = driver.getWindowHandles();
            for (String window : windowHandles) {
                if (!window.equals(parentWindow)) {
                    driver.switchTo().window(window);
                    break;
                }
            }
            Select category = new Select(driver.findElement(By.id("combo1")));
            category.selectByIndex(1);

            Select language = new Select(driver.findElement(By.id("combo2")));
            language.selectByIndex(2);

            driver.findElement(By.name("submitbuttonn")).click();
        } catch (Exception | Error e) {
            System.out.println("Exista o eroare");
        } finally {
            File file = driver.getScreenshotAs(OutputType.FILE);
            File destFile = new File("C:\\ProiectJava\\poza1.png");
            FileUtils.copyFile(file, destFile);
            if (driver != null){
                driver.quit();
            }
        }
    }
}
