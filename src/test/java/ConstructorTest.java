import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobjects.MainPage;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest{
    @Test
    @DisplayName("Переход к разделу Булки")
    public void goToBunsSections() {
        String displayedActiveBuns = new MainPage(driver)
                .clickButtonSauces()
                .clickButtonBuns()
                .getTextActiveSection();
        assertTrue("Ошибка", displayedActiveBuns.contains("Булки"));
    }

    @Test
    @DisplayName("Переход к разделу Соусы")
    public void goToSaucesSections() {
        String displayedActiveBuns = new MainPage(driver)
                .clickButtonSauces()
                .getTextActiveSection();
        assertTrue("Ошибка", displayedActiveBuns.contains("Соусы"));
    }

    @Test
    @DisplayName("Переход к разделу Начинки")
    public void goToFillingSections() {
        String displayedActiveBuns = new MainPage(driver)
                .clickButtonFilling()
                .getTextActiveSection();
        assertTrue("Ошибка", displayedActiveBuns.contains("Начинки"));
    }
}
