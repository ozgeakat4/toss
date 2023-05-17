package tosss;

import java.io.IOException;

import org.json.simple.parser.ParseException;

public class AppiumTest extends AbstractTest {
	public AppDriver driver; 

	public AppiumTest() throws IOException, ParseException {
		super(new AppDriver());
		this.driver = (AppDriver) super.driverObj;
		// TODO Auto-generated constructor stub
	}

	@Override
	void runTest() {
		// TODO Auto-generated method stub
		
	}

}
