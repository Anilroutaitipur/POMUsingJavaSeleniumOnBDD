package utility;

import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    private static final Logger log = LoggerHelper.getLogger(ExcelReader.class);
    public static List<String[]> getLoginData(String path, String sheetName) throws FileNotFoundException {
        List<String[]> data = new ArrayList<>();
        log.info("Reading Excel file from path: " + path + ", sheet: " + sheetName);

        try(FileInputStream fis = new FileInputStream(path);
            Workbook workbook = new XSSFWorkbook(fis))
        {
            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getPhysicalNumberOfRows();
            log.info("Total rows found (including header): " + rowCount);

            for(int i = 1;i < rowCount;i++)
            {
                Row row = sheet.getRow(i);
                String username = row.getCell(0).getStringCellValue();
                String password = row.getCell(1).getStringCellValue();
                data.add(new String[]{username,password});
                log.debug("Row " + i + " => Username: " + username + ", Password: [PROTECTED]");
            }
        }
        catch (Exception e)
        {
            log.error("Error reading Excel file: " + e.getMessage(), e);
        }
        return data;
    }
}
