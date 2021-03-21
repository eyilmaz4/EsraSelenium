package base;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
    protected WebDriver driver;

    @BeforeClass
    public void beforeClass() {


        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public void generalTableHandling(String url, By colNumXpath, By rowColXpath, String beforeXpath, String xpath, String completedXpath, int row, int column) {
        driver.get(url);
        int colNum = driver.findElements(colNumXpath).size();
        //System.out.println(colNum);
        int rowCol = driver.findElements(rowColXpath).size();
        //(//*[@id='product'])[1]//tbody//tr[4]//td[3]

        for (int i = 1; i <= rowCol; i++) {
            for (int j = 1; j <= colNum; j++) {
                if (i == row && j == column) {
                    String text = driver.findElement(By.xpath(beforeXpath + i + xpath + j + completedXpath)).getText();
                    System.out.print(text);
                }


            }

        }

    }
}
