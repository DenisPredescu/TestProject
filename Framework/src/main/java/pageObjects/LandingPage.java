package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	WebDriver driver;
	public LandingPage (WebDriver driver)
	{
		
		this.driver=driver;
		
	}
	
	By gtext=By.xpath("//p[@class='text-center']//a[@href='/customer/tasks/process/seo']");
	By overview=By.id("overview");
	By tasks=By.xpath("//span[@class='main-menu-nav-link-text'][contains(text(),'Tasks')]");
	By reports=By.xpath("//li[@id='reports']//a[@id='reports']//span[@class='main-menu-nav-link-text']");
	By settings=By.xpath("//a[@id='sidemenu-link-settings']//span[@class='main-menu-nav-link-text']");
	By tools=By.xpath("//span[@class='main-menu-nav-link-text'][contains(text(),'Tools')]");
	By blog=By.xpath("//a[@id='blog']");
	
	public WebElement gtext()
	{
		 return driver.findElement(gtext);
	}
	
	public WebElement overview()
	{
		 return driver.findElement(overview);
	}
	
	public WebElement tasks()
	{
		 return driver.findElement(tasks);
		 
	}
	
	public WebElement reports()
	{
		 return driver.findElement(reports);
	}
	
	public WebElement settings()
	{
		 return driver.findElement(settings);
	}
	
	public WebElement tools()
	{
		 return driver.findElement(tools);
	}
	
	public WebElement blog()
	{
		 return driver.findElement(blog);
	}
}
