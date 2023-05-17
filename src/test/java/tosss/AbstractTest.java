package tosss;

import java.io.IOException;

import org.json.simple.parser.ParseException;

abstract class AbstractTest {
	public Driver driverObj;
	
	public AbstractTest(Driver driver) throws IOException, ParseException {
		driver.readConfig();
		driver.setupDriver();
		this.driverObj = driver;
	}
	
	abstract void runTest();
}
