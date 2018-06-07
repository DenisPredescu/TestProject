package RankingCoach;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import Resources.Base;
import pageObjects.LoginPage;
import pageObjects.scrollobj;

public class scroll_test extends Base {
	scrollobj element;
	Actions action;
	WebDriverWait wait;

	@BeforeMethod
	public void initialize() throws IOException, InterruptedException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("testurl"));
		driver.manage().window().maximize();
		
		element = new scrollobj(driver);
		action = new Actions (driver);
		 
		Reporter.log("User is log in the application" , true);
		LoginPage er=new LoginPage(driver);
		er.login().click();
		Thread.sleep(1000);
		er.username().sendKeys(prop.getProperty("email"));
		Thread.sleep(1000);
		er.password().sendKeys(prop.getProperty("pass"));
		Thread.sleep(1000);
		er.submit().click();
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
	}
	
	
	@Test
	public void scrollElement () throws InterruptedException
	{
		scrollobj element = new scrollobj(driver);
		WebDriverWait time = new WebDriverWait(driver, 5);
		time.until(ExpectedConditions.elementToBeClickable(element.Next()));
		Thread.sleep(2000);
		element.Next().click();
		Thread.sleep(2000);
		element.industryList().click();
		Thread.sleep(2000);
        action.moveToElement(element.Services()).doubleClick().build().perform();
        Assert.assertTrue(element.addServices().isDisplayed());
        Thread.sleep(1000);
        action.moveToElement(element.autoParts()).click().build().perform();
        Thread.sleep(1000);
        action.moveToElement(element.brakes()).doubleClick().build().perform();
		Assert.assertTrue(element.addBrakes().isDisplayed());
		
		Thread.sleep(1000);
        action.moveToElement(element.Services()).doubleClick().build().perform();
		int fieldelements=element.field().findElements(By.tagName("span")).size();
		System.out.println(fieldelements);
		 if(fieldelements==2) 
		 {
			 System.out.println("Two sections are added");
			 
		 }
		 else
		 {
			 
			 System.out.println("To many sections are added");
			 
		 }
		
		
 
}
public WebElement getVisibility(WebElement webElement, int timeout) {
    WebElement element = null;
    wait =  new WebDriverWait(driver, timeout);
    element = wait.until(ExpectedConditions.visibilityOf(webElement));
    return element;
    }
public void clickElementWhenClickable(WebElement webElement, int timeout) {
    WebElement element = null;
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
    element.click();
}
	
	@AfterMethod
	public void cookies() throws InterruptedException
	{
		
		driver.manage().deleteAllCookies();
		Thread.sleep(2000);
		driver.close();
		driver=null; 
		
	}
	

}

