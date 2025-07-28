package utility;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    public static List<String[]> getLoginData(String path, String sheetName) throws FileNotFoundException {
        List<String[]> data = new ArrayList<>();

        try(FileInputStream fis = new FileInputStream(path);
            Workbook workbook = new XSSFWorkbook(fis))
        {
            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getPhysicalNumberOfRows();

            for(int i = 1;i < rowCount;i++)
            {
                Row row = sheet.getRow(i);
                String username = row.getCell(0).getStringCellValue();
                String password = row.getCell(1).getStringCellValue();
                data.add(new String[]{username,password});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
