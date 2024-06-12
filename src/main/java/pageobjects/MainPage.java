package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BasePage{
    private final By buttonPersonalAccount = By.xpath(".//p[text()='Личный Кабинет']");
    private final By buttonLogAccount = By.xpath(".//section[2]/div/button");
    private final By logoBurger = By.xpath(".//div/a[@href='/']");
    private final By buttonBunsSection = By.xpath(".//span[@class='text text_type_main-default' and text()='Булки']");
    private final By buttonSaucesSection = By.xpath(".//span[@class='text text_type_main-default' and text()='Соусы']");
    private final By buttonFillingsSection = By.xpath(".//span[@class='text text_type_main-default' and text()='Начинки']");
    private final By activeSection = By.xpath("//div[contains(@class,'tab_tab__1SPyG tab_tab_type_current__2BEPc')]");
    private final By buttonCreateOrder = By.xpath(".//button[text()='Оформить заказ']");
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Клик по кнопке Личный кабнет до авторизации пользователя")
    public LoginPage clickButtonPersonalAccountWithoutAuth () {
        driver.findElement(buttonPersonalAccount).click();
        return new LoginPage(driver);
    }

    @Step ("Клик по кнопке Личный кабинет после авторизации пользователя")
    public PersonalAccountPage clickButtonPersonalAccountWithAuth () {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonPersonalAccount));
        driver.findElement(buttonPersonalAccount).click();
        return new PersonalAccountPage(driver);
    }

    @Step ("Клик по кнопке Войти в аккаунт")
    public LoginPage clickButtonLogAccount () {
        driver.findElement(buttonLogAccount).click();
        return new LoginPage(driver);
    }

    @Step ("Нажать на вкладку Булки в конструкторе")
    public MainPage clickButtonBuns () {
        driver.findElement(buttonBunsSection).click();
        return new MainPage(driver);
    }

    @Step ("Нажать на вкладку Соусы в конструкторе")
    public MainPage clickButtonSauces () {
        driver.findElement(buttonSaucesSection).click();
        return new MainPage(driver);
    }

    @Step ("Нажать на вкладку Начинки в конструкторе")
    public MainPage clickButtonFilling () {
        driver.findElement(buttonFillingsSection).click();
        return new MainPage(driver);
    }

    @Step("Получение текста из активного раздела в конструкторе")
    public String getTextActiveSection() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(activeSection));
        return driver.findElement(activeSection).getText();
    }

    @Step("Получение текста из кнопки Оформить заказ")
    public String getTextCreateOrder() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonCreateOrder));
        return driver.findElement(buttonCreateOrder).getText();
    }
}
