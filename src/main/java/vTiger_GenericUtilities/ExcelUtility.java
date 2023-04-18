package vTiger_GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic methods related to excel file
 * @author Admin
 *
 */
public class ExcelUtility {
  /**
   * This method will read the data from Excel file
 * @throws Exception 
   */
	public String getDataFromExcel(String sheetName,int rowNo,int cellNo) throws Exception
	{
		FileInputStream fise=new FileInputStream(IConstantsUtility.excelSheetPath);
		Workbook book=WorkbookFactory.create(fise);
		String value=book.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
	}
	
	/**
	 * This method will write the data into excel
	 * @throws Exception 
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @param value
	 */
	public void writeIntoExcel(String sheetName,int rowNo,int cellNo,String value) throws Exception
	{
		FileInputStream fis=new FileInputStream(IConstantsUtility.excelSheetPath);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheetName);
		Row r=sh.createRow(rowNo);
		Cell c=r.createCell(cellNo);
				c.setCellValue(value);
				
	   FileOutputStream fos=new FileOutputStream(IConstantsUtility.excelSheetPath);
	   book.write(fos);
	   book.close();		
	}
	
	/**
	 * This method will read the data from Excel sheet and return it to DataProvider
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public Object[][] readDataFromExcelToDataProvider(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IConstantsUtility.excelSheetPath);
		Workbook wb=WorkbookFactory.create(fis);
	    Sheet sh=wb.getSheet(sheetName);
	    int lastRow=sh.getLastRowNum();
	    int lastCell=sh.getRow(0).getLastCellNum();
	    
	    Object[][] data=new Object[lastRow][lastCell];
	     
	    for(int i=0;i<lastRow;i++)
	    {
	    	for(int j=0;j<lastCell;j++)
	    	{
	    		data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
	    	}
	    }
	    return data;
	}
	}
