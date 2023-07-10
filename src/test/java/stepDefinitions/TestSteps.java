package stepDefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;import pageObjects.*;import org.apache.logging.log4j.LogManager;import java.util.List;
import java.time.Duration;
import java.util.HashMap;import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.ResourceBundle;
public class TestSteps {
	WebDriver driver;
	TestHomePage hp;TestAccountRegistrationPage arp;TestShoppingCartPage scp;
	TestLogInPage lp;TestSearchPage sp;
	Logger logger;ResourceBundle rb;String br;List<HashMap<String,String>> datamap;
	
	
	@Before
	public void setUp() {
		logger= LogManager.getLogger(this.getClass());
		rb=ResourceBundle.getBundle("config");
		br=rb.getString("browser");
	}
	@After
	public void tearDown(Scenario scenario) {
		
		System.out.println("Scenariro status:"+scenario.getStatus());
	if(scenario.isFailed()) {byte[] Screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES); 
	scenario.attach(Screenshot,"image/png",scenario.getName());}driver.quit();}
	@Given("User Launch Browser")
	public void user_launch_browser() {
	 if(br.equals("chrome"))   {
	driver =new ChromeDriver();}
	 
	 else if(br.equals("edge"))
	 {
		 driver=new EdgeDriver();
	 }else 
	 {
		 
		 driver=new FirefoxDriver();
	 }
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	 }

	@Given("Opens URL {string}")
	public void opens_url(String url) {
	    driver.get(url);
	    driver.manage().window().maximize();
	    
	}

	@When("User Navigate To MyAccount Menu")
	public void user_navigate_to_my_account_menu() {
		
		
		hp=new TestHomePage(driver) ;
		logger.info("clicked on my account link");
		hp.myAccountClick();
	}
	
	
	
	

	@When("Click on Login")
	public void click_on_login() {
		hp.logInClick();logger.info("clicked on my login link");
	}

	@When("User Enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
		lp=new TestLogInPage(driver);
		logger.info("providing login details");
		lp.emailAddress(email);lp.passwordAddress(password);
	}
	@When("Click on Login button")
	public void click_on_login_button() {
		lp.loginClick();
		
		logger.info("clicked on login button");
	}

	/*@Then("User Navigate to MyAccountPage")
	public void user_navigate_to_my_account_page() {
		MyAccountPage mcp=new MyAccountPage(driver);
		Boolean targetpage=	mcp.isMyAccountPageExists();	
			if(targetpage) {logger.info("login success");Assert.assertTrue(true);
				}
			
			else {
				Assert.assertTrue(false);logger.info("login failed");
			}
		logger.info("******Finished *****");
	}*/
	
	
	@When("Click on Register")
	public void click_on_register() {
		logger.info("clicked on registerlink");
		hp.register();
	}

	@When("User Enters First Name as {string} and Last Name as {string} and E-Mail as {string} and Password as {string}")
	public void user_enters_first_name_as_and_last_name_as_and_e_mail_as_and_password_as(String FirstName, String LastName, String Email, String Password) {
		arp=new TestAccountRegistrationPage(driver);arp.fname(FirstName);

arp.lname(LastName);
arp.mail(Email);
arp.pwd(Password);
	}

	@When("User click on the radio button yes to Subscribe NewsLetter")
	public void user_click_on_the_radio_button_yes_to_subscribe_news_letter() {
		arp.rd_click(); 
	}

	@When("User click on the check box to agree privacy policy")
	public void user_click_on_the_check_box_to_agree_privacy_policy() {
		arp.confirm(); 
	}

	@When("Click on continue button")
	public void click_on_continue_button() {
		arp.submit();
	}
	@When("click on the desktop")
	public void click_on_the_desktop() {
		logger.info("*****started TC_003_searchtest*****");
		 sp=new TestSearchPage(driver);
		
		//sp.buttonClick();
	//sp.macClick();
	sp.desktopClick();//sp.mac1Click();logger.info("*****finished TC_003_searchtest*****"); 
	}

	@When("click on the mac")
	public void click_on_the_mac() {
		sp.macClick();
	}

	@When("click on the mac1")
	public void click_on_the_mac1() {
		sp.mac1Click();
	}

	@When("click on the addtocart")
	public void click_on_the_addtocart() {
		 scp=new TestShoppingCartPage(driver);
		scp.addtocartClick();
	}

	@Then("validate the alert message")
	public void validate_the_alert_message() {
		String output1=scp.alertMessage();String exp_output="Success: You have added iMac to your shopping cart!";
		if(output1.equals(exp_output))
		{
		System.out.println("test is passed");
		}
		else
		{
			System.out.println("test is failed");
		}
	}

	@When("click on the shoppingcart")
	public void click_on_the_shoppingcart() {
		scp.shopingcartClick();
	}

	@When("click on the money")
	public void click_on_the_money() {
		scp.moneyClick();
	}

	@Then("validate the text message")
	public void validate_the_text_message() {
		String output2=scp.textClick();System.out.println(output2);
		String expoutput="Your shopping cart is empty!";Assert.assertEquals(output2,expoutput); 
	}

	@Then("click on the checkout")
	public void click_on_the_checkout() {
		scp.viewcartClick();
	}

	@Then("validate the message")
	public void validate_the_message() {
		String output =scp.message();String expectedoutput="Shopping Cart";System.out.println(output);
		Assert.assertEquals(output, expectedoutput); 
	}



}


