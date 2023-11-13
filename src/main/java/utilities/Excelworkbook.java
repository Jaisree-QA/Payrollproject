package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelworkbook {
	static FileInputStream f;
	static XSSFWorkbook wb;
	static XSSFSheet s;

	public static String stringDataReader(int row, int col) throws IOException {
		f = new FileInputStream	(System.getProperty("user.dir") + 
				"\\src\\main\\resources\\Excel\\addexcel.xlsx");	
		
		wb = new XSSFWorkbook(f);
		s = wb.getSheet("Sheet1");
		Row r = s.getRow(row);
		Cell c = r.getCell(col);
		return c.getStringCellValue();
	}
}
	/*
	public static String integerDataReader(int row, int col)throws IOException

	{
		f=new FileInputStream("C:\\Users\\user\\Desktop\\addexcel.xlsx");
		wb=new XSSFWorkbook(f);
		s=wb.getSheet("Sheet1");
		Row r=s.getRow(row);
		Cell c=r.getCell(col);
		int a=(int)c.getNumericCellValue();
		return String.valueOf(a);
		
	}
	*/
	