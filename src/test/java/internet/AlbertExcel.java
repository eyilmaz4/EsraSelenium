package internet;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AlbertExcel {



    public AlbertExcel() throws IOException {
        String FilePath="C:\\Users\\12812\\Desktop\\Kitap1.xlsx";
        FileInputStream fis=new FileInputStream(FilePath);
        Workbook wb= WorkbookFactory.create(fis);

        Sheet sh=wb.getSheet("Sayfa1");
        //int totalNoOfRows = sh.();
        Row row= sh.getRow(0);
        Cell cell=row.getCell(0);
        System.out.println(cell.toString());
        cell.setCellValue("coffee");



    }
}
