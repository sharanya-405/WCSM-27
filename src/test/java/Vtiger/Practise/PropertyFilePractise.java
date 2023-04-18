package Vtiger.Practise;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFilePractise {
	public static void main(String[] args) throws Exception {
		        //Step1:Load the file in java readable format using file input stream
		//*Where as fileOutput stream is used to write format
        FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonDataFrom.Properties");
        
        //Step2:Create object of Properties file from java.util
        Properties pobj=new Properties();
        
        //Step3:Load file input stream into properties
        pobj.load(fis);
        
        //Step4:Using the keys read the value
        String BROWSER=pobj.getProperty("browser");
        System.out.println(BROWSER);
        
	}  
}
