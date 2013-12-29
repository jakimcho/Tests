package abv;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import toolkit.HomePage;
import toolkit.LoginForm;
import static toolkit.AbvStatics.*;


public class Basic {

	private WebDriver driver = null;
	private LoginForm loginForm = null;
	private HomePage homePage = null;
	
	@Test(alwaysRun = true)
	public void loadABV() {
		this.driver.get(ABV_URL);
	}
	
	@Test(groups = {"negative"})
	public void tryLoginWithNoPassword(){
		if (this.loginForm == null){
			this.loginForm = new LoginForm(driver);
		}
		
		loginForm.enterUserName("Pesho");
		this.loginForm = loginForm.submitIncorrectCredentials();
		
		Assert.assertTrue(this.loginForm.checkErrorMessage());
	}
	
	@Test(groups = {"negative"})
	public void tryLoginWithNoUserName(){
		if (this.loginForm == null){
			this.loginForm = new LoginForm(driver);
		}
		
		loginForm.enterUserPassword("Pesho");
		this.loginForm = loginForm.submitIncorrectCredentials();
		
		Assert.assertTrue(this.loginForm.checkErrorMessage());
	}
	
	@Test(groups = {"negative"})
	public void tryLoginWithIncorrectCredentials(){
		if (this.loginForm == null){
			this.loginForm = new LoginForm(driver);
		}
		
		loginForm.enterUserPassword("Pensho");
		loginForm.enterUserName("Pensho");
		this.loginForm = loginForm.submitIncorrectCredentials();
		
		Assert.assertTrue(this.loginForm.checkErrorMessage());
	}
	
	@Test(groups = {"positive"})
	public void loginWithCorrectCredentials(){
		if (this.loginForm == null){
			this.loginForm = new LoginForm(driver);
		}
		
		loginForm.enterUserName("Pepentino");
		loginForm.enterUserPassword("HellFire");
		this.homePage = loginForm.submitCorrectCredentials();
		
		Assert.assertTrue(this.homePage.isInBoxPage());
	}
	
	
	@BeforeTest(alwaysRun = true)
	public void beforeSuite() {
		this.driver = new FirefoxDriver();
	}

	@AfterTest(alwaysRun = true)
	public void afterSuite() {
		this.driver.close();
	}

}
