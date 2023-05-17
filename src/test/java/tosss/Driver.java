package tosss;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public abstract class Driver  { 
	public JSONObject driverConfiguration;
	public Object driver;
	
 void readConfig() throws IOException, ParseException {
	 JSONParser parser = new JSONParser();
		FileReader reader =new FileReader("C:\\Users\\ozge_\\eclipse-workspace\\tosss\\src\\test\\resources\\config.json");
		this.driverConfiguration = (JSONObject) parser.parse(reader);
}	
 
 abstract void setupDriver();
}
