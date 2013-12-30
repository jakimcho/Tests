package toolkit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import static toolkit.AbvStatics.*;
import static toolkit.HomePage;

public class LoginForm {
	
	private WebElement userNameField = null;
	private WebElement passwordField = null;
	private WebElement submitButton = null;
	
	private final WebDriver driver;
	
	public LoginForm(WebDriver driver) {
		
		if (!ABV_LANDING_PAGE_TITLE.equals(driver.getTitle()) || !ABV_LANDING_PAGE_TITLE.equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("This is not the login page");
        }
		
		this.driver = driver;
		this.userNameField = driver.findElement(By.id("username"));
		this.passwordField = driver.findElement(By.id("password"));
		this.submitButton = driver.findElement(By.id("loginBut"));
	}
	
	public LoginForm enterUserName(String text){
		this.userNameField.clear();
		this.userNameField.sendKeys(text);
		
		return this;
	}
	
	public LoginForm enterUserPassword(String text){
		this.passwordField.clear();
		this.passwordField.sendKeys(text);
		
		return this;
	}
	
	public boolean checkErrorMessage(){
		WebElement errorMessage = this.driver.findElement(By.className("errorMessage"));
		
		return errorMessage.isDisplayed() && errorMessage.getText().contains("Грешен потребител/парола.");
	}
	
	public HomePage submitCorrectCredentials(){
		this.submitButton.click();
		
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.id("showGreeting")).getText().contains("Здравейте, Petur!");
            }
        });
		
		return new HomePage(this.driver);
	}
	
	public LoginForm submitIncorrectCredentials(){
	
		this.submitButton.click();
		
		return new LoginForm(driver);
	}

}
