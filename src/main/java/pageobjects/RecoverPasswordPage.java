package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoverPasswordPage extends BasePage{
    private final By linkLogin = By.xpath(".//a[text()='Войти']");
    public RecoverPasswordPage(WebDriver driver) {
        super(driver);
    }

    @Step("Клик по ссылке входа")
    public LoginPage clickLinkLogin() {
        driver.findElement(linkLogin).click();
        return new LoginPage(driver);
    }
}
