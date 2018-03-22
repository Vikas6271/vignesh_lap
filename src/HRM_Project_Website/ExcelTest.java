package HRM_Project_Website;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTest {

	public static void main(String[] args) throws Throwable {
		
		File f1 = new File("C:\\Users\\Vignesh\\Desktop\\excelone.xlsx");
		FileInputStream fis = new FileInputStream(f1);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheet("Sheet1");
		
			int rowcount = ws.getLastRowNum();
			int cellcount = ws.getRow(0).getLastCellNum();
			for(int i=0;i<rowcount;i++)
			{
				String str = ws.getRow(i+1).getCell(0).getStringCellValue();
				System.out.println(str);
			}
	}
}
