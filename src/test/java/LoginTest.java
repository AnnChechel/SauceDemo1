import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    @Test
    public void checkLogin() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String expectedResult = "https://www.saucedemo.com/inventory.html";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();

    }
 }
