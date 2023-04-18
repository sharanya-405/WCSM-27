package login;

import java.io.FileInputStream;
import java.util.Properties;

public class Fetching_Details_From_Properties {
public String getDataFromProperty(String data) throws Exception
{
	FileInputStream fis=new FileInputStream("src/test/resources/VtigerFolder/LoginCredentials.Properties");
	Properties pobj=new Properties();
	pobj.load(fis);
	return pobj.getProperty(data);
	
}
}
