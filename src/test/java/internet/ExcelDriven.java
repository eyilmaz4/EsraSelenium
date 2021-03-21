package internet;

import base.BaseClass;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelDriven extends BaseClass {
    @Test
    public void GmailAccount() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        Xls_Reader reader= new Xls_Reader("C:\\Users\\12812\\Desktop\\Kitap1.xlsx");
        int rows=reader.getRowCount("Sayfa1");

        for(int rowNum=2;rowNum<=rows;rowNum++) {

            String email = reader.getCellData("Sayfa1", "Email", rowNum);
            System.out.println(email);
            driver.findElement(By.xpath("//input[@id='email']")).clear();
            driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);

            String password = reader.getCellData("Sayfa1", "Password", rowNum);
            driver.findElement(By.xpath("//input[@id='pass']")).clear();
            driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);

            System.out.println(password);
            System.out.println("*********************");
            driver.findElement(By.xpath("//button[@id='loginbutton']")).click();
            Thread.sleep(1000);
        }


    }
    @Test
    public void addExcel() throws IOException {
        String FilePath="C:\\Users\\12812\\Desktop\\Kitap1.xlsx";
        FileInputStream fis=new FileInputStream(FilePath);
        Workbook wb= WorkbookFactory.create(fis);

        Sheet sh=wb.getSheetAt(1);
        Row row= sh.getRow(0);
        Cell cell=row.getCell(1);
        System.out.println(cell.toString());
        cell.setCellValue("coffee");

    }
}
