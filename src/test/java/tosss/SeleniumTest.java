package tosss;

import java.io.IOException;

import org.json.simple.parser.ParseException;

public class SeleniumTest extends AbstractTest{
	public WebDriver driver; 
	public SeleniumTest() throws IOException, ParseException  {
		super(new WebDriver());
		this.driver = (WebDriver) super.driverObj;
		// TODO Auto-generated constructor stub
	}

	@Override
	void runTest() {
		// TODO Auto-generated method stub
		
	}

}
