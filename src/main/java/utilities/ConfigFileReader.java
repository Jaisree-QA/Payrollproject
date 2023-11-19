package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	public static Properties pro;
	
	public static void testBasic() throws IOException {

		pro = new Properties(); // for url pulling
		FileInputStream fp = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\Properties\\config.properties");
		pro.load(fp);
	}
	public void testBasicHandling() {
	try {
		testBasic(); // for loading method
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}