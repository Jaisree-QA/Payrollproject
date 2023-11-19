package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelworkbook {
	static FileInputStream f;
	static XSSFWorkbook wb;
	static XSSFSheet s;
	static ConfigFileReader cf;

	public static String stringDataReader(int row, int col) throws IOException {
		cf = new ConfigFileReader();
		cf.testBasicHandling();

		f = new FileInputStream(
				System.getProperty("user.dir") + (ConfigFileReader.pro.getProperty("Excel").replace("//", "\\")));

		wb = new XSSFWorkbook(f);
		s = wb.getSheet("Sheet1");
		Row r = s.getRow(row);
		Cell c = r.getCell(col);
		return c.getStringCellValue();
	}

	public static String dataReaderforAssert(int row, int col) {
		cf = new ConfigFileReader();
		cf.testBasicHandling();

		try {
			f = new FileInputStream(
					System.getProperty("user.dir") + (ConfigFileReader.pro.getProperty("Excel").replace("//", "\\")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s = wb.getSheet("Sheet2");
		Row r = s.getRow(row);
		Cell c = r.getCell(col);
		 return c.getStringCellValue();
	}
}