import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobjects.MainPage;
import stellarburgers.User;
import steps.UserSteps;

import static org.junit.Assert.assertTrue;

public class RegisterTest extends BaseTest{
    Faker faker = new Faker();
    private String name;
    private String email;
    private String password;


    @Test
    @DisplayName("Регистрация пользователя с корректным паролем")
    @Description("Корректный пароль - 6 или больше символов")
    public void checkRegisterUserTestWithCorrectPassword() {

        name = faker.name().firstName();
        password = faker.internet().password(6, 10);
        email = faker.internet().emailAddress();

        String displayedWindowText = new MainPage(driver)
                .clickButtonPersonalAccountWithoutAuth()
                .clickLinkRegister()
                .setInputPersonalData(email, password, name)
                .clickButtonRegisterWithCorrectPassword()
                .getLoginWindowText();
        assertTrue("Ошибка", displayedWindowText.contains("Вход"));

        User user = new User().setEmail(email).setPassword(password);
        accessToken = UserSteps.userAuth(user).extract().path("accessToken");
    }

    @Test
    @DisplayName("Регистрация пользователя с некорректным паролем")
    @Description("Некорректный пароль - меньше 6 символов")
    public void checkRegisterUserTestWithIncorrectPassword() {
        name = faker.name().firstName();
        password = faker.internet().password(1, 5);
        email = faker.internet().emailAddress();
        String displayedErrorText = new MainPage(driver)
                .clickButtonPersonalAccountWithoutAuth()
                .clickLinkRegister()
                .setInputPersonalData(email, password, name)
                .clickButtonRegisterWithIncorrectPassword();
        assertTrue("Ошибка", displayedErrorText.contains("Некорректный пароль"));
    }
}
