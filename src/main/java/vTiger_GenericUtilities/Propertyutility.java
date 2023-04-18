package vTiger_GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of generic methods related to property file
 * @author Sharanya
 *   
 */
public class Propertyutility {
  
	/**
	 * This method will read the data from property file
	 * param data
	 * @throws IOException 
	 * return
	 */
	public String getDataFromPoperties(String data) throws IOException 
	{
		
		FileInputStream fisp=new FileInputStream(IConstantsUtility.propertyFilePath);
		Properties pobj=new Properties();
		pobj.load(fisp);
		String value=pobj.getProperty(data);
		return value;
	}
}
