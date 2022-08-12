import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class FakeAlerts {

    public static void main(String[] args) throws IOException {
//        showModalDialog();
        showModalDialogError();
    }

    public static void showModalDialog() {
        ChromeDriver driver = null;

        try {

            driver = BrowserManager.getChromeDriver();
            driver.get("https://testpages.herokuapp.com/styled/alerts/fake-alert-test.html");
            WebElement modalDialog = driver.findElement(By.id("modaldialog"));
            modalDialog.click();
            WebElement text = driver.findElement(By.id("dialog-text"));
            System.out.println(text.getText());
            driver.findElement(By.id("dialog-ok")).click();
        } catch (Exception | Error e) {
            System.out.println("A aparut o eroare");
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
    public static void showModalDialogError() throws IOException {
        ChromeDriver driver = null;

        try {

            driver = BrowserManager.getChromeDriver();
            driver.get("https://testpages.herokuapp.com/styled/alerts/fake-alert-test.html");
            WebElement modalDialog = driver.findElement(By.id("modaldialog"));
            modalDialog.click();
            WebElement text = driver.findElement(By.id("dialog-text"));
            System.out.println(text.getText());
            WebElement background = driver.findElement(By.xpath("//div[@class='faded-background active']"));
            background.click();
        } catch (Exception | Error e) {
            System.out.println("A aparut o eroare");
        } finally {
            File file = driver.getScreenshotAs(OutputType.FILE);
            File fleDest = new File("C:\\ProiectJava\\poza2.png");
            FileUtils.copyFile(file, fleDest);
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
