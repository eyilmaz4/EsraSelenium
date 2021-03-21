package internet;

import base.BaseClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;



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

        Random a=new Random();
        ArrayList<String>list1=new ArrayList<>();


        Object[][] data={{"Chen U", "chen@gmail.com","Active", "Male"},{"Tamara","t@gmail.com", "Acvite", "Female"},{"Sena","s@gmail.com","Active", "Female"}};
        return data;
    }
    @Test
    public void tableHandling(){
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        int colNum=driver.findElements(By.xpath("//*[@id='product']//tbody//th")).size();
        //System.out.println(colNum);
        int rowCol=driver.findElements(By.xpath("(//*[@id='product'])[1]//tbody//tr")).size();
        //(//*[@id='product'])[1]//tbody//tr[4]//td[3]
        String beforeXpath="(//*[@id='product'])[1]//tbody//tr[";
        String xpath= "]//td[";
        String completedXpath = "]";

        for (int i = 2; i <=rowCol ; i++) {
            for (int j = 1; j <=colNum ; j++) {
                if(i==4 && j==3){
                    String text = driver.findElement(By.xpath(beforeXpath+i+xpath+j+completedXpath)).getText();
                    System.out.print(text+" ");
                }



            }
            System.out.println(" ");

        }

        }
@Test
    public void generalTest(){
        generalTableHandling("https://www.seleniumeasy.com/test/table-data-download-demo.html",By.xpath("//table[@id='example']//thead//th"),By.xpath("//table[@id='example']//tbody//tr"),
                "//table[@id='example']//tbody//tr[","]//td[","]",3,3);
}

    }

