package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void checkLogin() {
        loginPage.openUrl();
        loginPage.login("standard_user", "secret_sauce");

        assertEquals(productsPage.getUrlPage(), productsPage.urlProducts);
        assertEquals(productsPage.getTitle(), "Products", "Заголовок страницы не соответствует");
    }

    @DataProvider(name = "incorrectLoginAndPasswordData")
    public Object[][] loginData() {
        return new Object[][]{
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"Standard_user", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(dataProvider = "incorrectLoginAndPasswordData")
    public void checkIncorrectLoginAndPassword(String login, String password, String message) {
        loginPage.openUrl();
        loginPage.login(login, password);

        assertTrue(loginPage.isErrorDisplayed(), "Текст ошибки невидим");
        assertEquals(loginPage.getErrorText(), message);
    }
 }
