import org.openqa.selenium.By;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    @Test
    public void checkLogin() {
        driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String expectedResult = "https://www.saucedemo.com/inventory.html";
        String actualResult = driver.getCurrentUrl();
        String titleName = driver.findElement(By.xpath("//*[@class='title']")).getText();

        assertEquals(actualResult, expectedResult);
        assertEquals(titleName, "Products", "Заголовок страницы не соответствует");
    }

    @Test
    public void checkIncorrectLogin() {
        driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        boolean isTitleVisible = driver.findElement(By.xpath("//h3[@data-test='error']")).isDisplayed();
        String errorText = driver.findElement(By.xpath("//h3[data-test='error']")).getText();

        assertTrue(isTitleVisible, "Заголовок страницы невидим");
        assertEquals(errorText, "Epic sadface: Username is requared");
    }
 }
