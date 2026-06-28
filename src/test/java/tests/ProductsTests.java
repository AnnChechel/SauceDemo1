package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductsTests extends BaseTest {
    @Test
    public void checkGoodsAdded() {
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(), "Products", "Заголовок страницы не соответствует");

        productsPage.addGoodsToCart("Sauce Labs Bolt T-Shirt");
        productsPage.addGoodsToCart(0);

        assertTrue(productsPage.checkIsDisplayedCountGoodsInShoppingCart());
        assertEquals(productsPage.checkCounterValue(), "rgba(226, 35, 26, 1)");
        assertEquals(productsPage.checkCountGoodsInShoppingCart(), "2");
    }
}
