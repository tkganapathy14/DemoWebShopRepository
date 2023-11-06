package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * 
 * @author tkgan
 *
 */

public class propertyUtility implements Iautoconstants {
	/**
	 * this method is developed to read the data from property file.
	 * this method accept key of which parameter you want to fetch
	 * @param key
	 * @return value of the key
	 */
	public String getdatafromPropertyfile(String key)
	{
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(Property_file_path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties property=new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  String value = property.getProperty(key);
		  return value;
	}

}
