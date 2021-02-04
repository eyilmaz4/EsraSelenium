package internet;

import base.BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AddRemove extends BaseClass {
    @Test
    public void testAddElement(){
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
    }
    @Test
    public void testRemoveElement(){
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement add=driver.findElement(By.xpath("//button[text()='Add Element']"));
                add.click();
                add.click();
        driver.findElement(By.xpath("//button[text()='Delete']")).click();
    }

}
