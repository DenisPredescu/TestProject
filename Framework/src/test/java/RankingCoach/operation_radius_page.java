package RankingCoach;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Resources.Base;
import Resources.Helper;
import pageObjects.LoginPage;
import pageObjects.operationRadiusObj;

public class operation_radius_page extends Base {

	public static Actions action;
	public static operationRadiusObj element;
	public static WebDriverWait wait;

	@BeforeMethod
	public void initialize() throws IOException, InterruptedException {

		driver = initializeDriver();
		driver.get(prop.getProperty("testurl"));
		driver.manage().window().maximize();
		element = new operationRadiusObj(driver);
		action = new Actions(driver);
		wait = new WebDriverWait(driver, 5);

		LoginPage er = new LoginPage(driver);
		er.login().click();
		Thread.sleep(1000);
		er.username().sendKeys(prop.getProperty("email"));
		Thread.sleep(1000);
		er.password().sendKeys(prop.getProperty("pass"));
		Thread.sleep(1000);
		er.submit().click();
		driver.manage().window().maximize();
	}

	@Test
	public void a_pageContent() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Verify the Headline of the page");
		Helper.highLightElement(driver, element.headline());
		Assert.assertEquals(element.headline().getText(), prop.getProperty("orHeadline"));

		Thread.sleep(2000);
		System.out.println("Verify the first text");
		Helper.highLightElement(driver, element.lOperating());
		Assert.assertEquals(element.lOperating().getText(), prop.getProperty("orText1"));

		Thread.sleep(2000);
		System.out.println("Verify the second text");
		Helper.highLightElement(driver, element.nationWide());
		Assert.assertEquals(element.nationWide().getText(), prop.getProperty("orText2"));

		Thread.sleep(2000);
		System.out.println("Verify if the Slider is displayed");
		Helper.highLightElement(driver, element.slider());
		Assert.assertTrue(element.slider().isDisplayed());

		Thread.sleep(2000);
		System.out.println("Verify Slider text");
		Helper.highLightElement(driver, element.sliderText());
		Assert.assertEquals(element.sliderText().getText(), prop.getProperty("orText3"));

		Thread.sleep(2000);
		System.out.println("Verify First ToolTip");
		Helper.highLightElement(driver, element.maxLocations());
		Assert.assertEquals(element.maxLocations().getText(), prop.getProperty("orText4"));

		Thread.sleep(2000);
		System.out.println("Verify if the Field is displayed");
		Helper.highLightElement(driver, element.field());
		Assert.assertTrue(element.field().isDisplayed());

		Thread.sleep(2000);
		System.out.println("Verify the second ToolTip");
		Helper.highLightElement(driver, element.tooltip());
		Assert.assertEquals(element.tooltip().getText(), prop.getProperty("orText5"));

		Thread.sleep(2000);
		System.out.println("Vrify if map is displayed");
		Helper.highLightElement(driver, element.map());
		Assert.assertTrue(element.map().isDisplayed());

	}

	@Test
	public void b_radioButtonsAndSlider() throws InterruptedException {

		Thread.sleep(3000);
		System.out.println("Click on second radio button");
		element.Button2().click();

		Thread.sleep(2000);
		System.out.println("Click on first radio button");
		element.Button1().click();

		Thread.sleep(2000);
		System.out.println("Click on second radio button");
		element.Button2().click();
		try {
			if (element.fade().isDisplayed()) {

				System.out.println("Elements are faded");
			}
		} catch (Exception e) {
			System.out.println("ERROR");

		}

		Thread.sleep(2000);
		System.out.println("Click on first radio button");
		element.Button1().click();
		try {
			if (element.fade().isDisplayed()) {

				System.out.println("Elements are still faded:ERROR");

			}
		} catch (Exception e) {
			// Assert.assertFalse(element.fade().isDisplayed());
			System.out.println("Elements are all visible");
		}

		Thread.sleep(3000);
		System.out.println("Click on 10 mi. point");
		action.moveToElement(element.sliderPoint1()).click().build().perform();
		Thread.sleep(2000);
		System.out.println("Click on 200 mi. point");
		action.moveToElement(element.sliderPoint2()).click().build().perform();
		Thread.sleep(2000);
		System.out.println("Click on 10 mi. point");
		action.moveToElement(element.sliderPoint1()).click().build().perform();

	}
 
	@Test
	public void c_cityField() throws InterruptedException {

		Thread.sleep(2000);
		if (element.sf().isDisplayed()) {
			System.out.println("The Dafault value is displayed");
			action.moveToElement(element.closeIcon()).pause(1000).click(element.closeIcon()).build().perform();
			System.out.println("Element is Removed");
		} else {
			System.out.println("ERROR");
		}

		Thread.sleep(3000);
		System.out.println("Add 3 locations and verify if error message is displayed");
		action.moveToElement(element.fieldContent()).click(element.fieldContent()).sendKeys("BOS").build().perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.ARROW_DOWN).pause(1000).sendKeys(Keys.ARROW_DOWN).pause(1000).sendKeys(Keys.ARROW_DOWN)
				.pause(1000).sendKeys(Keys.ARROW_DOWN).pause(2000).sendKeys(Keys.ENTER).build().perform();

		Thread.sleep(3000);

		action.moveToElement(element.fieldContent()).click(element.fieldContent()).sendKeys("NEW").build().perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.ARROW_DOWN).pause(1000).sendKeys(Keys.ARROW_DOWN).pause(1000).sendKeys(Keys.ARROW_DOWN)
				.pause(1000).sendKeys(Keys.ARROW_DOWN).pause(2000).sendKeys(Keys.ENTER).build().perform();

		Thread.sleep(3000);

		action.moveToElement(element.fieldContent()).click(element.fieldContent()).sendKeys("Cle").build().perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.ARROW_DOWN).pause(1000).sendKeys(Keys.ARROW_DOWN).pause(1000).sendKeys(Keys.ARROW_DOWN)
				.pause(2000).sendKeys(Keys.ENTER).build().perform();

		System.out.println("Wait until the error is displayed");
		wait.until(ExpectedConditions.visibilityOf(element.error()));
		// Helper.highLightElement(driver, element.error());
		// Assert.assertEquals(element.error().getText(),
		// prop.getProperty("error"));
		String errorText = element.error().getText();
		if (errorText.matches(prop.getProperty("error"))) {
			System.out.println("Error message is correct displayed");
			
		} else {
			System.out.println("ERROR");

		}
		
		System.out.println("Verify if the field contains Max 2 cities");
		int cities=element.field().findElements(By.tagName("li")).size();
		if(cities==2)
		{
		System.out.println("The number of cities is: " +cities);
		}else
		{
		System.out.println("The number of cities is: " +cities+".ERROR");	
		}
		
		System.out.println("Click on Next button");
		Thread.sleep(3000);
		//action.moveToElement(element.next()).click(element.next()).build().perform();
		element.next().click();
	}

	@AfterMethod
	public void cookies() throws InterruptedException {
		Thread.sleep(4000);
		driver.manage().deleteAllCookies();
		driver.close();
		driver = null;
	}

}
