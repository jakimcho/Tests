package toolkit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private final WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isInBoxPage(){
		WebElement mailBox = this.driver.findElement(By.className("abvMainCont"));
		
		return mailBox.isDisplayed();
	}
}
