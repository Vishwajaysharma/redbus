package redbus.seleniumprop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;

public class ReadPropertiesFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Properties prop = new Properties();
		String filepath = System.getProperty("user.dir") + "/redbus/test/resourse/data.properties";
		FileInputStream data = new FileInputStream(filepath);
		prop.load(data);
		data.close();
	
		String gh= prop.getProperty("134");
		 System.out.println(gh);
		 data.close();
	}

}
