package RankingCoach;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.Base;
import pageObjects.LoginPage;
public class Validations extends Base {

	WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void HomePage() throws IOException
	{ 
		
		
		LoginPage action =new LoginPage(driver);
		
		action.login().click();
		action.username().sendKeys(prop.getProperty("email"));
		action.password().sendKeys(prop.getProperty("pass"));
		action.submit().click();
		
		//LandingPage tx = new LandingPage(driver);
		//System.out.println(tx.gtext().getText());
		//System.out.println("Texts are correct displayed");
		//Assert.assertEquals("SEARCH ENGINES", tx.gtext().getText());
		//Assert.assertEquals("OVERVIEW", tx.overview().getText());
		//Assert.assertEquals("TASKS", tx.tasks().getText());
		//Assert.assertEquals("REPORTS", tx.reports().getText());
		//Assert.assertEquals("SETTINGS", tx.settings().getText());
		//Assert.assertEquals("TOOLS", tx.tools().getText());
	    ///Assert.assertTrue(tx.blog().isDisplayed());
		
		
	}
	
	@AfterTest
	public void closeBrowser()
	{
		
		driver.close();
	}
	
	
}
 