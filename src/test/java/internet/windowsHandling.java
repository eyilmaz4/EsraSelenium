package internet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class windowsHandling {
    WebDriver driver;
JavascriptExecutor js;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //js=(JavascriptExecutor)driver;
    }

    @AfterMethod
    public void tearDown() {
       // driver.quit();
    }

    @Test
    public void windowHandling() {
        driver.get("https://the-internet.herokuapp.com/");

        driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click();
        String parent = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
        //String child=driver.getWindowHandle();
        //driver.switchTo().window(child);

        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles
        ) {
            if (!handle.equals(parent)) {
                System.out.println("handle is child" + handle);
            } else {
//                driver.switchTo().window(handle);
//                String child1=driver.getWindowHandle();
                System.out.println("parent handle" + handle);
            }
        }
        driver.switchTo().window(parent);
        System.out.println(driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).getText());
    }

    @Test
    public void naWindow() throws InterruptedException {
        js=(JavascriptExecutor)driver;
        js.executeScript("window.location=arguments[0]", "https://www.na.edu/");

        Thread.sleep(1000);
        String parent=driver.getWindowHandle();
        driver.findElement(By.xpath("(//*[text()='Donation'])[1]")).click();
        driver.findElement(By.xpath("(//*[text()='Donation'])[1]")).click();

//        String child=driver.getWindowHandle();
//        driver.switchTo().window(child);
//        Thread.sleep(2000);

//

       // driver.findElement(By.xpath("//span[contains(text(),'Make your gift')]")).click();
        Thread.sleep(2000);
        //String grandChild=driver.getWindowHandle();
        Set<String> handles=driver.getWindowHandles();
        Iterator<String>iterator=handles.iterator();
        String parentWID=iterator.next();
        System.out.println(parentWID);
        String childWID=iterator.next();
        System.out.println(childWID);
        String childWID2=iterator.next();
        System.out.println(childWID2);
        //js.executeScript("window.scrollBy(0,-1000)");
        //WebElement giving=(WebElement) js.executeScript("return document.getElement(By.xpath("//*[text()=' GIVING ']")))



    }
}
