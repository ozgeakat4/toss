package tosss;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

public class AppDriver extends Driver {
	public AppiumDriver<?> driver = null;

	public void setupDriver()  {
	
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("appium:deviceName",this.driverConfiguration.get("deviceName"));
		cap.setCapability("appium:udid",this.driverConfiguration.get("udid"));
		cap.setCapability("appium:platformName",this.driverConfiguration.get("platformName"));
		cap.setCapability("appium:platformVersion",this.driverConfiguration.get("platformVersion"));
		cap.setCapability("appium:appPackage",this.driverConfiguration.get("appPackage"));
		cap.setCapability("appium:appActivity",this.driverConfiguration.get("appActivity"));
		try {
			this.driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
