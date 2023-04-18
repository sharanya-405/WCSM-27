package Vtiger.Practise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractise {
  @Test(dataProvider="getData")
  public void addToCart(String name,int price,int qty,String colour,boolean isAvailable)
  {
	  System.out.println(name+" "+price+" "+qty+" "+colour+" "+isAvailable); 
  }
  
  @Test(dataProvider="getNextData")
  public void addToNextCart(String name,int price,boolean isAvailable)
  {
	  System.out.println(name+" "+price+" "+isAvailable);
  }
  @DataProvider()
  public Object[][] getData()
  {
	  Object[][] data=new Object[2][5];
	  
	  data[0][0]="Samsung";
	  data[0][1]=1000;
	  data[0][2]=12;
	  data[0][3]="Black";
	  data[0][4]=true;
	  
	  data[1][0]="Iphone";
	  data[1][1]=12000;
	  data[1][2]=5;
	  data[1][3]="White";
	  data[1][4]=false;
	  
	  return data;
  }
  @DataProvider()
  public Object[][] getNextData()
  {
	  Object[][] data=new Object[2][3];
	  
	  data[0][0]="Onida";
	  data[0][1]=30000;
	  data[0][2]=true;
	  
	  data[1][0]="LG";
	  data[1][1]=45000;
	  data[1][2]=false;
	  
	  return data;
  }
}

















