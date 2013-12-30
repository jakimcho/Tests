package toolkit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static toolkit.AbvStatics.*;

public class RegistrationForm {

	private final WebDriver driver;
	
	private WebElement userField;
	private WebElement passwordField;
	private WebElement passwordConfirmField;
	private WebElement secretQuestionField;
	private WebElement secretAnswerField;
	private WebElement alternativeEmailField;
	private WebElement userFirstNameField;
	private WebElement userSirNameField;
	private WebElement userGender;
	private WebElement registrationCaptcha;
	
	
	public RegistrationForm(WebDriver driver) {
		if (ABV_REGISTRATION_PAGE_TITLE.equals(driver.getTitle())){
			this.driver = driver;
			
			this.userField = this.driver.findElement(By.id("regformUsername"));
			this.passwordField = this.driver.findElement(By.id("regformPassword"));
			this.passwordConfirmField = this.driver.findElement(By.id("regformPasswordrepeat"));
			this.secretQuestionField = this.driver.findElement(By.id("regformSecQ"));
			this.secretAnswerField = this.driver.findElement(By.id("regformSecA"));
			this.alternativeEmailField = this.driver.findElement(By.id("regformAltEmail"));
			this.userFirstNameField = this.driver.findElement(By.id("regformName"));
			this.userSirNameField = this.driver.findElement(By.id("regformLastname"));
			this.userGender = this.driver.findElement(By.name("gender"));
			this.registrationCaptcha = this.driver.findElement(By.id("regformCode"));
			
		} else{
			throw new IllegalStateException("This is not the registration page");
		}
	}
	
	public RegistrationForm enterUserName(String userName){
		
		this.userField.clear();
		this.userField.sendKeys(userName);
		
		return this;
	}
	
	public RegistrationForm enterPassword(String password){
		
		this.passwordField.clear();
		this.passwordField.sendKeys(password);
		
		return this;
	}
	
	public RegistrationForm confirmPassword(String password){
		
		this.passwordConfirmField.clear();
		this.passwordConfirmField.sendKeys(password);
		
		return this;
	}
	
	public RegistrationForm enterSecretQuestion(String secretQuestion){
		
		this.secretQuestionField.clear();
		this.secretQuestionField.sendKeys(secretQuestion);
		
		return this;
	}
	
	public RegistrationForm enterSecretAnswer(String secretAnswer){
		
		this.secretAnswerField.clear();
		this.secretAnswerField.sendKeys(secretAnswer);
		
		return this;
	}
	
	public RegistrationForm enterAlternativeEmail(String altMail){
		
		this.alternativeEmailField.clear();
		this.alternativeEmailField.sendKeys(altMail);
		
		return this;
	}
	
	public RegistrationForm enterUserFirstName(String userFirstName){
		
		this.userFirstNameField.clear();
		this.userFirstNameField.sendKeys(userFirstName);
		
		return this;
	}
	
	public RegistrationForm enterUserSirName(String userSirName){
		
		this.userSirNameField.clear();
		this.userSirNameField.sendKeys(userSirName);
		
		return this;
	}
	
	public RegistrationForm enterCaptcha(String captcha){
		
		this.registrationCaptcha.clear();
		this.registrationCaptcha.sendKeys(captcha);
		
		return this;
	}
	
	public RegistrationForm setUserGender (Gender gender){
		
		switch (gender){
			case MALE:
				this.userGender.findElement(By.id("regformMan")).click();
				break;
			case FEMALE:	
				this.userGender.findElement(By.id("regformWoman")).click();
				break;
		}
		return this;
	}
	
}
