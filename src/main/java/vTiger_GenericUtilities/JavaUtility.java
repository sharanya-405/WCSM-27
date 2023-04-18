package vTiger_GenericUtilities;

import java.util.Date;
import java.util.Random;

/**
 * This class consists of all java related methods
 * @author Admin
 *
 */
public class JavaUtility {
    /**
     * This method will return random number everytime 
     */
	public int getrandomNumber()
	{
		Random r=new Random();
		int add=r.nextInt(10000);
		return add;
	}
	
	/**
	 * This method will return the current system date
	 */
	public String getSystemDate()
	{
		Date d=new Date();
		return d.toString();
	}
	
	/**
	 * This method will return the date in specified format
	 */
	public String getSystemDateInFormat()
	{
		Date d=new Date();                        //Fri Mar 10 11:14:58 IST 2023
		String[] dArr=d.toString().split(" ");    //0   1    2    3      4    5   --->Array indexNo
		String date=dArr[2];
		String month=dArr[1];
		String year=dArr[5];
		String time=dArr[3].replace(":","-");
		String dateValue=date+"-"+month+"-"+year+"_"+time;
		return dateValue;		
	}
}
