package internet;

import base.BaseClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ABTesting extends BaseClass {
    @Test
    public void testABTesting(){
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[text()='A/B Testing']")).click();
        Assert.assertEquals(driver.getTitle(),"The Internet");
    }
}
