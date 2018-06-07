package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class scrollobj {
   
	
	WebDriver driver; 
	
	public scrollobj (WebDriver driver)
	{
		
		this.driver=driver;
	}
	

	By Next = By.cssSelector("#domain_details_next");
	By industryList = By.xpath("//div[@id='ui_selectable_list']/ul/li[2]");
	By knob = By.xpath("//body/div[10]/div[@class='knob']");
	By List = By.xpath("//div[@id='business-sector-multi-select-wrapper']/div[1]/div[2]/div");
	By towing = By.xpath("//li[20]");
	
	By Services = By.xpath("//*[contains(text(),'Auto Glass Services')]");
	By autoParts = By.xpath("//*[contains(text(),'Auto Parts & Accessories')]");
	By brakes = By.xpath("//*[contains(text(),'Brakes')]");
	//Added Elements 
	By addServices = By.xpath("//span[contains(text(),'Automotive > Auto Glass Services')]");
	By addBrakes = By.xpath("//span[contains(text(),'Automotive > Auto Parts & Accessories > Brakes')]");
	//Add Field
	By field = By.xpath("//form[@id='frm_business_sector']");
	
	
	
	public WebElement field()
	{
		
		return driver.findElement(field);
	}
	public WebElement addBrakes()
	{
		
		return driver.findElement(addBrakes);
	}
	public WebElement addServices()
	{
		
		return driver.findElement(addServices);
	}
	public WebElement brakes()
	{
		
		return driver.findElement(brakes);
	}
	public WebElement autoParts ()
	{
		
		return driver.findElement(autoParts);
	}
	public WebElement Services ()
	{
		
		return driver.findElement(Services);
	}
	
	public WebElement towing ()
	{
		
		return driver.findElement(towing);
	}
	public WebElement List ()
	{
		
		return driver.findElement(List);
	}
	public WebElement knob ()
	{
		
		return driver.findElement(knob);
	}
	public WebElement industryList ()
	{
		
		return driver.findElement(industryList);
	}
	public WebElement Next ()
	{
		
		return driver.findElement(Next);
	}
	
	
}
