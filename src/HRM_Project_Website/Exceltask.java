package HRM_Project_Website;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceltask {
	
	public static void main(String[] args) throws Throwable {
		
		File f1 = new File("C:\\Users\\Vignesh\\Desktop\\practiseanddeletefile.xlsx");
		FileInputStream fis = new FileInputStream(f1);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheet("Sheet1");
		
			int rowcount = ws.getLastRowNum();
			int cellcount = ws.getRow(0).getLastCellNum();
			
			
		
			
		
	}

}
