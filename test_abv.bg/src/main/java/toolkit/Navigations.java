package toolkit;

import static toolkit.AbvStatics.ABV_URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Navigations {
	
	public final WebDriver driver;
	
	public Navigations(WebDriver driver) {
		this.driver = driver;
	}
	
	public Navigations openABV(){
		
		this.driver.get(ABV_URL);
	
		return this;
	}
	
	public RegistrationForm newRegistration(){
		
		WebElement registrationLink = this.driver.findElement(By.xpath("(//a[@href[contains(., 'registration')]])[2]"));
		registrationLink.click();
		
		return new RegistrationForm(this.driver);
	}

}
