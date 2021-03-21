package internet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Deluxe {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
        driver.get("https://www.deluxe.com/");

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void dropDown() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement drop=driver.findElement(By.xpath("//*[text()='Customers and Industries']"));
        action.moveToElement(drop).build().perform();
        Thread.sleep(1000);
        //driver.findElement(By.xpath("(//*[text()='eChecks'])[1]")).click();

    }
}
