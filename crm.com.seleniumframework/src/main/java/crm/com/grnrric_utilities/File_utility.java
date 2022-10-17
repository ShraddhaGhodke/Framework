package crm.com.grnrric_utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class File_utility {
	
	public String getPropertyKeyValue(String Key) throws IOException
	{
		FileInputStream fis=new FileInputStream("./common_data.property.txt");
		Properties pro=new Properties();
		pro.load(fis);
		
		 String value = pro.getProperty(Key);
		return value;
		
		
	}

}
