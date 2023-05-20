package tosss;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition {
	private AppiumTest AppTest;
	private SeleniumTest WebTest;
	
	public StepDefinition()throws IOException, ParseException  {
		AppTest = new AppiumTest();
		WebTest = new SeleniumTest();
		String status; 
	}
	@Given("open webpage {string}")
	public void open_webpage(String string) {
		this.WebTest.driver.driver.get(string);
		this.WebTest.driver.driver.manage().window().maximize();
	}
	@When("login {word} with username {string} and password {string}")
	public void login_with_username_and_password(String system, String username, String password) {
	
		if(system.equals("web")) {
			
		this.WebTest.driver.driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		this.WebTest.driver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		this.WebTest.driver.driver.findElement(By.id("logonIdentifier")).click();
		this.WebTest.driver.driver.findElement(By.id("logonIdentifier")).sendKeys(username);
		this.WebTest.driver.driver.findElement(By.id("password")).sendKeys(password);
		this.WebTest.driver.driver.findElement(By.id("next")).click();
		}
		else if (system.equals("app")){
		
			this.AppTest.driver.driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
			this.AppTest.driver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			this.AppTest.driver.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[4]/android.widget.EditText").click();
			this.AppTest.driver.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[4]/android.widget.EditText").sendKeys("username");
			this.AppTest.driver.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.EditText").click();
			this.AppTest.driver.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.EditText").sendKeys("password");
			this.AppTest.driver.driver.hideKeyboard(); // close keyboard and click login button
			//oturum aç butonu
			this.AppTest.driver.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.widget.Button").click();
		}
	
	}
	
	@Then("search charger on {word}")
	public void search_charger_on(String system ) throws MalformedURLException {
		try {
			if(system.equals("web")) {
				this.WebTest.driver.driver.get("https://vesteuwebapptest.azurewebsites.net/ChargePoint");
				this.WebTest.driver.driver.findElement(By.id("FieldFilter")).click();
				this.WebTest.driver.driver.findElement(By.id("FieldFilter")).sendKeys("DV-BURAK6");
				this.WebTest.driver.driver.findElement(By.id("dropdownMenuButton")).click();
			}
			else if(system.equals("app")){
				//allow camera
				this.AppTest.driver.driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
				this.AppTest.driver.driver.findElementByXPath(("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]")).click();
				// cihaz arat appde path yanlış
				this.AppTest.driver.driver.findElementByXPath(("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.EditText")).sendKeys("DV-BURAK6");

			}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		throw new io.cucumber.java.PendingException(e.toString());
	}
	}
	@Then("add charger")
	public void add_charger() throws MalformedURLException {
		try {
			
			this.WebTest.driver.driver.get("https://vesteuwebapptest.azurewebsites.net/ChargePoint/Insert");
				//Şarj istasyonu adı *
			this.WebTest.driver.driver.findElement(By.id("CPCodeNo")).click();
			this.WebTest.driver.driver.findElement(By.id("CPCodeNo")).sendKeys("Charger1");
				//Şarj istasyonu cihaz kimliği *
			this.WebTest.driver.driver.findElement(By.id("CPUniqueID")).click();
			this.WebTest.driver.driver.findElement(By.id("CPUniqueID")).sendKeys("Charger1");
				// Şarj istasyonu modeli * 
			this.WebTest.driver.driver.findElement(By.id("CPModel")).click();
				Select se = new Select(this.WebTest.driver.driver.findElement(By.xpath("//*[@id='CPModel']")));
				// Select the option by index
				se.selectByVisibleText("EVC02-AC11G");
				this.WebTest.driver.driver.findElement(By.id("CPGroup")).click();
				this.WebTest.driver.driver.findElement(By.id("CPGroup")).sendKeys("Group1");
				
				this.WebTest.driver.driver.findElement(By.id("CPLocation")).click();
				this.WebTest.driver.driver.findElement(By.id("CPLocation")).sendKeys("Location1");
				
				this.WebTest.driver.driver.findElement(By.id("Save")).click();

				
	} catch (Exception e) {
		// TODO Auto-generated catch block
		throw new io.cucumber.java.PendingException(e.toString());
	}
	}
	@Then("search user on web")
	public void search_user_on_web() throws MalformedURLException{
		//allow camera
		this.AppTest.driver.driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
		//click profil button
		this.AppTest.driver.driver.findElementByXPath("(//android.view.ViewGroup[@content-desc=\"TabViewHeaderItem\"])[4]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView").click();
//click hesap bilgilerim
		this.AppTest.driver.driver.findElementByXPath("(/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button)").click();
		// ismi bul
		this.AppTest.driver.driver.findElementByXPath("");
		this.WebTest.driver.driver.findElement(By.id("userManagement")).click();
		this.WebTest.driver.driver.findElement(By.id("search")).sendKeys("User");
	}
	
	@Then("charger is {word}")
	public void charger_is (String status ) throws MalformedURLException { 
		this.WebTest.driver.driver.findElement(By.id("")).click();
		this.WebTest.driver.driver.findElement(By.id("search")).sendKeys("User");
		this.WebTest.driver.driver.findElement(By.id("status")).click();
		status = this.WebTest.driver.driver.findElement(By.id("status")).getText();
		if(status.equals("avaliable")){
			System.out.println(true);
		}
		else{
			System.out.println(false);
		}
	}
	
	@Then("reserve charger on {word}")
	public void reserve_charger_on (String platform ) throws MalformedURLException { 
		try {
			if(system.equals("web")) {
				this.WebTest.driver.driver.findElement(By.id("FieldFilter")).click();
				this.WebTest.driver.driver.findElement(By.id("FieldFilter")).sendKeys("DV-BURAK6");
				this.WebTest.driver.driver.findElement(By.id("dropdownMenuButton")).click();
				this.WebTest.driver.driver.findElement(By.id("reserve")).click();
			}
			else if(system.equals("app")){
				
				this.AppTest.driver.driver.findElement(By.id("button")).click();
				this.AppTest.driver.driver.findElementByXPath(("")).click();
				this.AppTest.driver.driver.findElementByXPath(("")).sendKeys("DV-BURAK6");
				this.AppTest.driver.driver.findElement(By.id("button")).click();
			}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		throw new io.cucumber.java.PendingException(e.toString());
	}
	}
	
	@Then("start charge on {word}")
	public void start_charge_on (String platform ) throws MalformedURLException { 
		try {
			if(system.equals("web")) {
				this.WebTest.driver.driver.findElement(By.id("FieldFilter")).click();
				this.WebTest.driver.driver.findElement(By.id("FieldFilter")).sendKeys("DV-BURAK6");
				this.WebTest.driver.driver.findElement(By.id("dropdownMenuButton")).click();
				this.WebTest.driver.driver.findElement(By.id("start")).click();
			}
			else if(system.equals("app")){
				
				this.AppTest.driver.driver.findElement(By.id("button")).click();
				this.AppTest.driver.driver.findElementByXPath(("")).click();
				this.AppTest.driver.driver.findElementByXPath(("")).sendKeys("DV-BURAK6");
				this.AppTest.driver.driver.findElement(By.id("button")).click();
			}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		throw new io.cucumber.java.PendingException(e.toString());
	}
	}
	

	@Then("check user status")
	public void check_user_status() throws MalformedURLException { 
		this.WebTest.driver.driver.findElement(By.id("")).click();
		this.WebTest.driver.driver.findElement(By.id("search")).sendKeys("User");
		this.WebTest.driver.driver.findElement(By.id("status")).click();
		status = this.WebTest.driver.driver.findElement(By.id("status")).getText();
		if(status.equals("active")){
			System.out.println(true);
		}
		else{
			System.out.println(false);
		}
	}
	
	@Then("signup app")
	public void signup_app() throws MalformedURLException { 
		this.AppTest.driver.driver.findElement(By.id("name")).click();
		this.AppTest.driver.driver.findElement(By.id("name")).sendKeys("name1");
		this.AppTest.driver.driver.findElement(By.id("surname")).click();
		this.AppTest.driver.driver.findElement(By.id("surname")).sendKeys("surname1");
		this.AppTest.driver.driver.findElement(By.id("phoneno")).click();
		this.AppTest.driver.driver.findElement(By.id("surname")).sendKeys("5550552010");
		this.AppTest.driver.driver.findElement(By.id("save")).click();
	}
	@Then("activate user")
	public void activate_user() throws MalformedURLException { 
		this.WebTest.driver.driver.findElement(By.id("")).click();
		this.WebTest.driver.driver.findElement(By.id("search")).sendKeys("User");
		this.WebTest.driver.driver.findElement(By.id("activate")).click();

	}
	
    @When("delete device on web")
	public void delete_device_on_web() throws MalformedURLException { 
		this.WebTest.driver.driver.findElement(By.id("")).click();
		this.WebTest.driver.driver.findElement(By.id("search")).sendKeys("device");
		this.WebTest.driver.driver.findElement(By.id("deleteButton")).click();

	}
    @Then("delete user on web")
	public void delete_user_on_web() throws MalformedURLException { 
		this.WebTest.driver.driver.findElement(By.id("")).click();
		this.WebTest.driver.driver.findElement(By.id("search")).sendKeys("user");
		this.WebTest.driver.driver.findElement(By.id("deleteButton")).click();
	}
    @Then("change device status on web")
	public void change_device_status_on_web() throws MalformedURLException { 
		this.WebTest.driver.driver.findElement(By.id("")).click();
		this.WebTest.driver.driver.findElement(By.id("search")).sendKeys("User");
		this.WebTest.driver.driver.findElement(By.id("busy")).click();
	}
    @Then("change user status on web")
 	public void change_user_status_on_web() throws MalformedURLException { 
		this.WebTest.driver.driver.findElement(By.id("")).click();
		this.WebTest.driver.driver.findElement(By.id("search")).sendKeys("user");
		this.WebTest.driver.driver.findElement(By.id("deactivated")).click();
 	}
    @Then("add rfid card")
 	public void add_rfid_card() throws MalformedURLException { 
		this.WebTest.driver.driver.findElement(By.id("")).click();
		this.WebTest.driver.driver.findElement(By.id("search")).sendKeys("user");
		this.WebTest.driver.driver.findElement(By.id("addrfid")).click();
		this.WebTest.driver.driver.findElement(By.id("rfidno")).sendKeys("123456");
		this.WebTest.driver.driver.findElement(By.id("save")).click();
 	}
}
