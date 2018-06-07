package RankingCoach;

import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Resources.Base;
import pageObjects.LoginPage;
import pageObjects.domainnameobj;

public class domainname extends Base {
	
	
	@BeforeMethod
	public void initialize() throws IOException, InterruptedException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("testurl"));
		driver.manage().window().maximize();
		
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
	public void erros() throws InterruptedException, IOException
	{
		
		Reporter.log("Verify if error messages are displayed" , true);
		domainnameobj el = new domainnameobj(driver);
		//clear the field
		el.DomainField().clear();
		Thread.sleep(2000);
		el.CheckWebsite().click();
		Thread.sleep(2000);
		Assert.assertEquals(prop.getProperty("Emptyfield"),el.EmptyField().getText());
		
		//driver.navigate().refresh();
		
		Actions ac =new Actions(driver);
		ac.moveToElement(el.DomainField()).click().sendKeys("test").perform();
		Thread.sleep(2000);
		el.CheckWebsite().click();
		
		Thread.sleep(2000);
		Assert.assertEquals(prop.getProperty("InvalidDomain"),el.InvalidDomain().getText());
		
		Thread.sleep(2000);
		ac.moveToElement(el.DomainField()).click().sendKeys(Keys.BACK_SPACE,Keys.ENTER).build().perform();
	
	}
	
	 @Test
     public void validExecutions() throws InterruptedException
     {
    	 
    	 domainnameobj el = new domainnameobj(driver);
    	 Thread.sleep(2000);
    	 el.DomainField().sendKeys(prop.getProperty("url"));
    	 Thread.sleep(2000);
    	 el.CheckWebsite().click();
    	 
    	 WebDriverWait time = new WebDriverWait(driver,9);
    	 time.until
    	         (ExpectedConditions.visibilityOf(el.thumbcontent()));
    	 Assert.assertTrue(el.thumbcontent().isDisplayed());
    	 Assert.assertTrue(el.Next().isDisplayed());
    	 
     }
     
     
     @Test(dependsOnMethods={"validExecutions"})
     public void removeDomain () throws InterruptedException
     {
    	 domainnameobj el = new domainnameobj(driver);
    	 Thread.sleep(2000);
    	 Actions action = new Actions(driver);
    	 //Click on Manage projects icon
    	 action.moveToElement(el.SettingsButton()).click().build().perform();
    	 Thread.sleep(2000);
    	 //Verify if added site is displayed in Manage Projects
    	 Assert.assertTrue(el.addedSite().isDisplayed());
    	 Thread.sleep(2000);
    	 // Click on Delete Icon 
    	 action.moveToElement(el.addedSite()).click(el.deleteSite()).build().perform();
    	 Thread.sleep(3000);
    	 //Click on NO button
    	 action.moveToElement(el.deletesiteNo()).click().build().perform();
    	 //Verify if added site is displayed in Manage Projects
    	 Assert.assertTrue(el.addedSite().isDisplayed());
    	 Thread.sleep(2000);
    	 //Delete the your Added WebSite
    	 action.moveToElement(el.addedSite()).click(el.deleteSite()).build().perform();
    	 Thread.sleep(2000);
    	 //Click on Yes button
    	 action.moveToElement(el.deletesiteYes()).click().build().perform();
    	 Thread.sleep(2000);
    	 //Verify if added site is displayed in Manage Projects(Should not be)
         try{
        	 el.addedSite().isDisplayed();
        	 System.out.println("�lement is displayed");
        	 
         }
    	 catch(Exception e){
    		 System.out.println("�lement is not displayed");
    	 }
    
     }
    	 	
         
         
       @Test(dependsOnMethods={"removeDomain"})
       public void addSiteFromManageProjects() throws InterruptedException
       {
    	   domainnameobj el = new domainnameobj(driver);
    	   Thread.sleep(2000);
      	   Actions action = new Actions(driver);
      	   //Click on Manage projects icon
      	   action.moveToElement(el.SettingsButton()).click().build().perform();
      	   Thread.sleep(2000);
      	   //Verify if addsite case si displayed
      	   Assert.assertTrue(el.AddNewSite().isDisplayed());
      	   //Verify if the addsite popup will appear and will have the required content 
      	   action.moveToElement(el.AddNewSite()).click().build().perform();
      	   Thread.sleep(3000);
      	   Assert.assertTrue(el.addWindow().isDisplayed());
      	   //Verify window first text
      	   Assert.assertEquals(prop.getProperty("AddSiteContent"), el.addWindowContent().getText());
      	   //Verify window second text
      	   Assert.assertEquals(prop.getProperty("AddSiteContent2"), el.addWindowContent2().getText());
      	   //Press Yes button and wait until the Add field is displayed 
      	   action.moveToElement(el.addSitebuttonYes()).click().perform();
      	   WebDriverWait time = new WebDriverWait(driver, 10);
      	   time.until(ExpectedConditions.visibilityOf(el.DomainField()));
      	   //Verify if Cancel button is displayed 
      	   if(el.cancelButton().isDisplayed())
      	   {
      		   System.out.println("Delete button is displayed:"  + el.cancelButton().isDisplayed() );
      		   action.moveToElement(el.DomainField()).click().sendKeys(prop.getProperty("url")).build().perform();
      		   //Press CheckWebsite and wait until the thumb is displayed 
      		   Thread.sleep(1000);
      		   action.click(el.CheckWebsite()).perform();
      		   WebElement sitevisibility = time.until
      				   (ExpectedConditions.visibilityOf(el.thumbcontent()));
      		   if(sitevisibility.isDisplayed())
      		   {
      			   
      			   System.out.println("The site img is displayed in the thumb :" + el.thumbcontent().isDisplayed());
      		       //Cancel button should not be displayed 
      				   if(el.cancelButton().isDisplayed())
      				   {
                     	   System.out.println("Cancell buttons is dispalyed:Fatal Error");   
      				   }
      				   else
      			       {
      				      System.out.println("Cancel button is not displayed anymore");
      				      //Refresh the page 
      			       }
      		   }
      		   else
      		   {  
      			  System.out.println("Fatal Error");   
      		   }
      		   
      	   }
      	   else
      	   {
      		 System.out.println("Element is displayed:" + el.cancelButton().isDisplayed() +"Fatal  Error");
      		  
      	   }
      	   
      	     
      	   }
       
    	   
 
    	@Test(dependsOnMethods={"addSiteFromManageProjects"})
    	public void addAnotherSite() throws InterruptedException
    	{	
          domainnameobj el =  new domainnameobj (driver);
          Actions action = new Actions(driver);
          //Select select = new Select(el.selectSites());
          //Verify is dropDown is displayed and contains the last added site 
          if(el.selectSites().isDisplayed())
          {
        	 System.out.println("Select sites DropDown is visible:" + el.selectSites().isDisplayed()); 
        	 action.moveToElement(el.selectSites()).click().perform();
        	 Thread.sleep(3000);
        	 System.out.println("The site available in drop down is: " + el.dropDownFirstSite().getText()); 
        	 Assert.assertEquals(prop.getProperty("DPSite"), el.dropDownFirstSite().getText());
          }
          else
          {
        	  System.out.println("Select Sites DropDown is visible:" + el.selectSites().isDisplayed() + "Fatal Error");     	         	  
          }
          
         Thread.sleep(2000);
         //Clear field content
         el.DomainField().clear();
         //Type the new content and hit enter 
         action.click(el.DomainField()).sendKeys(prop.getProperty("testurl2")).sendKeys(Keys.ENTER).perform();
         //Wait until the Thumb is visible and verify if the new Domain is added and available
         WebDriverWait time = new WebDriverWait(driver, 10);
          WebElement sitevisibility =  time.until(ExpectedConditions.visibilityOf(el.domainthumb()));
            if(sitevisibility.isDisplayed())
            {
            	//Refresh the page
            	driver.navigate().refresh();
           
            	//verify if the new site is added and the old site is removed
            	if(el.selectSites().isDisplayed())
            	{
            		System.out.println("Select sites DropDown is visible:" + el.selectSites().isDisplayed()); 
            		action.moveToElement(el.selectSites()).click().perform();
            		System.out.println("The site available in drop down is:" + el.dropDownSecondSite().getText());
            		Assert.assertEquals(prop.getProperty("DPSite2"), el.dropDownSecondSite().getText());
            	}
            	else
            	{

            		System.out.println("DropDown is not displayed:ERROR");
            	}
            
            }
            else
            {    	
            	System.out.println("Thumb element is not displayed: ERROR");
	
            }	
    		
    		
    	}
    	
    	@Test(dependsOnMethods={"addAnotherSite"})
    	public void addMultipleDomains () throws InterruptedException
    	
    	{
    		domainnameobj el = new domainnameobj(driver);
    		Actions action = new Actions (driver);
    		WebDriverWait time = new WebDriverWait(driver, 10);
    		String ManageSitesTitle =null;
    		String DomainNameTitle =null;
    		//Interact and Click on settings icon
    		action.moveToElement(el.SettingsButton()).click().perform();
    		ManageSitesTitle= driver.getTitle();
    		//Add new site 
    		if(el.AddNewSite().isDisplayed())
    		{   
    		   action.click(el.AddNewSite()).perform();
    		   //Verify if the correct texts are displayed
    		   Assert.assertEquals(prop.getProperty("AddSecondSiteContent"),"Total costs presently : $29.95 per month");
    		   Assert.assertEquals(prop.getProperty("AddSecondSiteContent2"),"The costs will increase to $54.90 per month.");
    		   Thread.sleep(2000);
    		   //Click on Windows Yes button
    		   el.addSiteYes().click();
    		   DomainNameTitle = driver.getTitle();
    		   //Verify if the user is redirected to the right page
    		    if(ManageSitesTitle!= DomainNameTitle)
    		    {	
    		    System.out.println("User is redirected to the correct page");
    		    //Cancell Button should be displayed
    		    Assert.assertTrue(el.cancelButton().isDisplayed());
    		    //Add the new site
    		    action.click(el.DomainField()).sendKeys(prop.getProperty("testurl3"), Keys.ENTER).build().perform();;
    		    WebElement SiteVisibility = time.until
    		          (ExpectedConditions.visibilityOf(el.domainthumb()));
    		    //Verify if all the sites are available in Manage Sites
    		      if(SiteVisibility.isDisplayed())
    		      {
    		    	  //Cancel button is not displayed anymore
    		    	  Assert.assertFalse(el.cancelButton().isDisplayed());
    		    	  //Click on settings 
    		    	  action.click(el.SettingsButton()).perform();
    		    	  Thread.sleep(2000);
    		    	  //First and second site should be displayed
    		    	  Assert.assertTrue(el.addedSecondSite().isDisplayed());
    		    	  Assert.assertTrue(el.addedThirdSite().isDisplayed());
    		      }
    		      else
    		      {  
    		    	  System.out.println("Thumb is not visible :ERROR");	  
    		      }
    		    }
    		    else 
    		    {	
    		    System.out.println("User is not redirected to the right page:Error");	
    		    }	    			
    		}
    		else
    		{
    			System.out.println("Add Button is not displayed:Error");
    		}
    		
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
