package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.BaseTest;

public class LoginPage extends BaseTest {
    private final By loginInput = By.xpath("//*[@placeholder='Username']");
    private final By passwordInput = By.id("password");
    private final By submitButton = By.id("login-button");
    private final By error = By.xpath("//h3[@data-test='error']");
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openUrl() {
        driver.get("https://www.saucedemo.com/");
    }

    public void login(String name, String pass) {
        driver.findElement(loginInput).sendKeys(name);
        driver.findElement(passwordInput).sendKeys(pass);
        driver.findElement(submitButton).click();
    }

    public boolean isErrorDisplayed() {
        return driver.findElement(error).isDisplayed();
    }

    public String getErrorText() {
        return driver.findElement(error).getText();
    }
}
