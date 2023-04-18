package Vtiger.Practise;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcel {
public static void main(String[] args) throws Exception {
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook book=WorkbookFactory.create(fis);
	Sheet sh=book.getSheet("Organizatio");
	Row r=sh.getRow(1);
	Cell c=r.createCell(5);
	c.setCellValue("charu");
	FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
	book.write(fos);
	System.out.println("data added");
	book.close();
}
}
