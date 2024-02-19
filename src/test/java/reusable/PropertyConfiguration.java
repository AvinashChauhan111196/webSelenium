package reusable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyConfiguration {

	public Properties p = null;
	String filepath = "./src/test/java/reusable/config.properties";
	
	public void property() throws IOException {
		
		p = new Properties();
		InputStream str = new FileInputStream(filepath);
		p.load(str);
	}
	
}
