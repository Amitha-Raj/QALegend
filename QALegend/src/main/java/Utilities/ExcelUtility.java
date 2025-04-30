package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public static XSSFWorkbook w;//handles excel file
	public static XSSFSheet s; //handles sheets
	public static FileInputStream f;

	public static String readStringData(int i,int j,String sheetname,String path) throws IOException {

	f= new FileInputStream(System.getProperty("user.dir")+path);
	w= new XSSFWorkbook(f);
    s= w.getSheet(sheetname);
	Row r=s.getRow(i);
    Cell c=r.getCell(j);
    return c.getStringCellValue();

	}

	public static String readIntegerData(int i,int j,String sheetname,String path) throws IOException {
		

			f= new FileInputStream(System.getProperty("user.dir")+path);
            w= new XSSFWorkbook(f);
            s= w.getSheet(sheetname);
            Row r=s.getRow(i);
            Cell c=r.getCell(j);
            int value=(int) c.getNumericCellValue();
            return String.valueOf(value);

			}
}
