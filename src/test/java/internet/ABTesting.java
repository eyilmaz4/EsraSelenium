package internet;

import base.BaseClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class ABTesting extends BaseClass {
    Private_Variables obj=new Private_Variables();
    @Test(enabled = false)
    public void testABTesting(){
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[text()='A/B Testing']")).click();
        Assert.assertEquals(driver.getTitle(),"The Internet");
    }
    @Test(dataProvider = "dataGiven")
    public void callVariable(String name, String email, String status, String gender){
        obj.setName(name);
        obj.setEmail(email);
        obj.setStatus(status);
        obj.setGender(gender);

        //Question: how can we write all data in one data table?
//        List<String>arr=new LinkedList<>();
//        arr.add(obj.toString());
//        System.out.println(arr);
        //System.out.println(obj);

    }
    @DataProvider
    public Object[][] dataGiven(){
        Object[][] data={{"Chen U", "chen@gmail.com","Active", "Male"},{"Tamara","t@gmail.com", "Acvite", "Female"},{"Sena","s@gmail.com","Active", "Female"}};
        return data;
    }
}
