package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    public static final String ADD_TO_CART = "//*[text()='%s']//ancestor::div[@class='inventory_item']" +
            "//child::button[text()='Add to cart']";
    private final By titleName = By.xpath("//*[@class='title']");
    private final By counter = By.xpath(DATA_TEST_PATTERN.formatted("shopping-cart-badge"));
    private final By addToCart = By.xpath("//*[text()='Add to cart']");
    public final String urlProducts = "https://www.saucedemo.com/inventory.html";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(titleName).getText();
    }

    public String getUrlPage() {
        return driver.getCurrentUrl();
    }

    public void addGoodsToCart(String goodsName) {
        By addToCart = By.xpath(ADD_TO_CART.formatted(goodsName));
        driver.findElement(addToCart).click();
    }

    public void addGoodsToCart(int goodsIndex) {
        driver.findElements(addToCart).get(goodsIndex).click();
    }

    public boolean checkIsDisplayedCountGoodsInShoppingCart() {
        return driver.findElement(counter).isDisplayed();
    }

    public String checkCounterValue() {
        return driver.findElement(counter).getCssValue("background-color");
    }

    public String checkCountGoodsInShoppingCart() {
        return driver.findElement(counter).getText();
    }
}
