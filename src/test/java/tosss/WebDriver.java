package tosss;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriver extends Driver {
	public ChromeDriver driver = null;

	public void setupDriver() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
	}
}
