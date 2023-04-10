package toss;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.junit.Cucumber;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(Cucumber.class)
public class CalculatorTest {
	AppiumDriver driver;
	WebDriver webdriver;

	@Then("driver opens")
	public void driver_opens() throws MalformedURLException {

		try {
			WebDriverManager.chromedriver().setup();
			webdriver = new ChromeDriver();
			webdriver.get("https://vesteuwebapptest.azurewebsites.net");
			webdriver.manage().window().maximize();
			
		} catch (Exception e) {
			throw new io.cucumber.java.PendingException(e.toString());
		}
	}

	@Given("mdriver opens")
	public void mdriver_opens() throws MalformedURLException {

		try {
			// Write code here that turns the phrase above into concrete actions
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("appium:deviceName", "SM-A015F/DS");
			cap.setCapability("appium:udid", "R9PN30CWHFJ");
			cap.setCapability("appium:platformName", "Android");
			cap.setCapability("appium:platformVersion", "11");

			// cap.setCapability("appium:appActivity",
			// "com.sec.android.app.popupcalculator.Calculator");

			cap.setCapability("appium:appPackage", "com.scaleup.chatai");
			cap.setCapability("appium:appActivity", "com.scaleup.chatai.SplashActivity");

			driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), cap);
		} catch (MalformedURLException e) {
			throw new io.cucumber.java.PendingException(e.toString());

		}
	}

	@Then("write credentials")
	public void write_credentials() throws MalformedURLException {
		try {
			// Write code here that turns the phrase above into concrete actions
			webdriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			webdriver.findElement(By.id("logonIdentifier")).click();
			webdriver.findElement(By.id("logonIdentifier")).sendKeys("necdet.atamturk@vestel.com.tr");

			webdriver.findElement(By.id("password")).click();
			webdriver.findElement(By.id("password")).sendKeys("asd.1234");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new io.cucumber.java.PendingException(e.toString());
		}
	}

	@Then("click sign button")
	public void click_sign_button() throws MalformedURLException {
		// Write code here that turns the phrase above into concrete actions
		try {
			webdriver.findElement(By.id("next")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new io.cucumber.java.PendingException(e.toString());
		}
	}
}
