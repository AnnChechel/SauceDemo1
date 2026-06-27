package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void checkLogin() {
        loginPage.openUrl();
        loginPage.login("standard_user", "secret_sauce");

        assertEquals(productsPage.getUrlPage(), productsPage.urlProducts);
        assertEquals(productsPage.getTitle(), "Products", "Заголовок страницы не соответствует");
    }

    @Test
    public void checkEmptyLogin() {
        loginPage.openUrl();
        loginPage.login("", "secret_sauce");

        assertTrue(loginPage.isErrorDisplayed(), "Текст ошибки невидим");
        assertEquals(loginPage.getErrorText(), "Epic sadface: Username is required");
    }

    @Test
    public void checkEmptyPassword() {
        loginPage.openUrl();
        loginPage.login("standard_user", "");

        assertTrue(loginPage.isErrorDisplayed(), "Текст ошибки невидим");
        assertEquals(loginPage.getErrorText(), "Epic sadface: Password is required");
    }

    @Test
    public void checkLockedLogin() {
        loginPage.openUrl();
        loginPage.login("locked_out_user", "secret_sauce");

        assertTrue(loginPage.isErrorDisplayed(), "Текст ошибки невидим");
        assertEquals(loginPage.getErrorText(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void checkIncorrectedLogin() {
        loginPage.openUrl();
        loginPage.login("Standard_user", "secret_sauce");

        assertTrue(loginPage.isErrorDisplayed(), "Текст ошибки невидим");
        assertEquals(loginPage.getErrorText(), "Epic sadface: Username and password do not match any user in this service");
    }
 }
