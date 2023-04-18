package Vtiger.Practise;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CommonDataFromExcel {
	public static void main(String[] args) throws Exception{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet("Organizatio");
		Row r=sh.getRow(1);
		Cell c=r.getCell(1);
		String value=c.getStringCellValue();
		System.out.println(value);
	}
}
