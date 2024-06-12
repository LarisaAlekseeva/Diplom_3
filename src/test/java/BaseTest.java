import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import stellarburgers.WebDriverFactory;
import steps.UserSteps;

import static constants.URI.BASE_URL;

public class BaseTest {
 protected String accessToken;
 protected WebDriver driver;

 @Before
 public void setUp() {
  driver = WebDriverFactory.getDriver("chrome"); // для смены браузера надо изменить название браузера на "firefox"
  driver.get(BASE_URL);
  RestAssured.baseURI = BASE_URL;
 }

 @After
 public void clearData() {
  if (accessToken != null) {
   UserSteps.userDelete(accessToken);
  }
  driver.quit();
 }
 }
