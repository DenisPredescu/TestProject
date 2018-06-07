package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebsitePO {
   public WebDriver driver;
		
	@FindBy (css=".icon-earth_globe")
	WebElement SelectCountry;
	
	public WebsitePO(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
		
	}
	
	public void clickOnSelectCountry() {
		
		SelectCountry.click();
		
	}
		
		

}
