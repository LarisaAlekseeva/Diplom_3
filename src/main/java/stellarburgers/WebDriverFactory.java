package stellarburgers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;


public class WebDriverFactory {
    public static WebDriver getDriver(String browserName) {
        WebDriver driver;
        switch (browserName) {

            case "firefox":
                driver = WebDriverManager.firefoxdriver().create();
                break;
            case "chrome":
                driver = WebDriverManager.chromedriver().create();
                break;

            default:
                throw new RuntimeException("invalid browser name");
        }
        return driver;
    }
}
