import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserManager {

//    public static ChromeDriver getChromeDriver() {
//        WebDriverManager.chromedriver().setup();
//        return new ChromeDriver();


    public static RemoteWebDriver getRemoteWebdriver() throws MalformedURLException {
        return new RemoteWebDriver(new URL("http://localhost:4444/"), new ChromeOptions());
    }
    }

