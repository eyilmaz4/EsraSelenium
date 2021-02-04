package internet;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBox extends BaseClass {
    @Test
    public void testCheckBox() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[@href='/checkboxes']")).click();
        WebElement check=driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
        check.click();
        boolean isChecked=check.isSelected();
        Thread.sleep(1000);
        Assert.assertTrue(isChecked);

    }
}
