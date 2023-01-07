package comcast.vtiger.genericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class File_Utility
{
   public String getPropertyKeysAndValue(String key) throws Throwable
   {
	   FileInputStream fis=new FileInputStream("./data/crm.properties");
			   Properties p=new Properties();
			   p.load(fis);
			   String value=p.getProperty(key);
	           return value;
   }

}
