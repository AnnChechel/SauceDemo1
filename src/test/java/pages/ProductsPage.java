package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.BaseTest;

public class ProductsPage extends BaseTest {
    private final By titleName = By.xpath("//*[@class='title']");
    public final String urlProducts = "https://www.saucedemo.com/inventory.html";
    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(titleName).getText();
    }

    public String getUrlPage() {
        return driver.getCurrentUrl();
    }
}
