package abv.registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import toolkit.Navigations;
import toolkit.RegistrationForm;

public class RegistrationTests {
	private final static String SHORT_USER_NAME_ERROR = "Това поле не може да съдържа по-малко от 3 символа.";

	private WebDriver driver;
	private Navigations nav;
	private RegistrationForm regForm;
	
	@Test(dataProvider = "dp")
	public void f(Integer n, String s) {
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, "a" },
				new Object[] { 2, "b" }, };
	}

	@Test(description = "Test Inavalid name")
	public void enterInvalidName() {
		Assert.assertEquals(this.regForm.enterUserName("mo"), SHORT_USER_NAME_ERROR);
	}

	@BeforeSuite
	public void beforeTest() {
		this.driver = new FirefoxDriver();
		this.nav = new Navigations(this.driver);
	}
	
	@BeforeMethod
	public void beforeMethod(){
		if(driver == null || !driver.getCurrentUrl().contains("ABV_REGISTRATION_PAGE_URL")){
			this.regForm = this.nav.openABV().newRegistration();
		}
	}

	@AfterSuite
	public void afterTest() {
		driver.close();
	}

}
