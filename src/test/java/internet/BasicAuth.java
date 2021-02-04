package internet;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicAuth extends BaseClass {
    @Test
    public void testBasicAuth(){
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        String actualMessage=driver.findElement(By.xpath("//*[contains(text(),'Congratulations!')]")).getText();
        String expected="Congratulations! You must have the proper credentials.";
        Assert.assertEquals(actualMessage,expected);


    }
    @Test
    public void testBuffSci() throws InterruptedException {
        driver.get("https://admin@staging-buffsci.org:admin123test@hr-testing.buffsci.org/login");
Thread.sleep(3000);
    }

}
