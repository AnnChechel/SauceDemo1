package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By loginInput = By.xpath("//*[@placeholder='Username']");
    private final By passwordInput = By.id("password");
    private final By submitButton = By.id("login-button");
    private final By error = By.xpath("//h3[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openUrl() {
        driver.get(BASE_URL);
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
