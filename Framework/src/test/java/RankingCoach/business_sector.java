package RankingCoach;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Resources.Base;
import Resources.Helper;
import Resources.WaitTypes;
import pageObjects.LoginPage;
import pageObjects.businessSectorObj;

public class business_sector extends Base {

	private Actions action;
	private businessSectorObj element;
	private WebDriverWait wait;
	public static ExtentReports report;
	public static ExtentTest test;

	@BeforeMethod
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.get(prop.getProperty("testurl"));
		driver.manage().window().maximize();

		action = new Actions(driver);
		element = new businessSectorObj(driver);
		wait = new WebDriverWait(driver, 15);

		LoginPage er = new LoginPage(driver);
		er.login().click();
		Thread.sleep(2000);
		er.username().sendKeys(prop.getProperty("email"));
		Thread.sleep(2000);
		er.password().sendKeys(prop.getProperty("pass"));
		Thread.sleep(2000);
		er.submit().click();

	}

	@Test
	public void a_pageContent() throws InterruptedException {

		Thread.sleep(2000);
		try {
			if (element.object().isDisplayed()) {
				System.out.println("Click on Tab");
				element.tab().click();
			}

		} catch (Exception e) {
			System.out.println("Click on Next");
			wait.until(ExpectedConditions.elementToBeClickable(element.Next()));
			Thread.sleep(2000);
			action.moveToElement(element.Next()).click().build().perform();
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(element.Next()));
		Thread.sleep(2000);
		action.moveToElement(element.Next()).click().build().perform();
		// test.log(LogStatus.INFO, "Wait until Next button is visible and and
		// click on it");

		Thread.sleep(2000);
		Helper.highLightElement(driver, element.headline());
		Assert.assertEquals(element.headline().getText(), prop.getProperty("bsHeadLine"));
		// test.log(LogStatus.INFO, "Verify if headline is displayed");

		Thread.sleep(2000);
		Helper.highLightElement(driver, element.subheadline());
		Assert.assertEquals(element.subheadline().getText(), prop.getProperty("bsSubLeadline"));
		// test.log(LogStatus.INFO, "Verify if subheadline is displayed");

		Thread.sleep(2000);
		Helper.highLightElement(driver, element.industry());
		Assert.assertTrue(element.industry().isDisplayed());
		// test.log(LogStatus.INFO, "Verify if INDUSTRY section is displayed");

		Thread.sleep(2000);
		Helper.highLightElement(driver, element.category());
		Assert.assertTrue(element.category().isDisplayed());
		// test.log(LogStatus.INFO, "Verify if CATEGORY section is displayed");

		Thread.sleep(2000);
		Helper.highLightElement(driver, element.sector());
		Assert.assertTrue(element.sector().isDisplayed());
		// test.log(LogStatus.INFO, "Verify if SECTOR section is displayed");

		Thread.sleep(2000);
		Helper.highLightElement(driver, element.selectCategory());
		Assert.assertEquals(element.selectCategory().getText(), prop.getProperty("bsFieldText"));
		// test.log(LogStatus.INFO, "Verify if Field Text is displayed");

		Thread.sleep(2000);
		Helper.highLightElement(driver, element.sectorFieldContent());
		Assert.assertTrue(element.sectorFieldContent().isDisplayed());
		// test.log(LogStatus.INFO, "Verify if Selected Sectors field is
		// displayed ");
	}

	@Test
	public void b_industrySection() throws InterruptedException {

		Thread.sleep(2000);
		try {
			if (element.object().isDisplayed()) {
				System.out.println("Click on Tab");
				element.tab().click();
			}

		} catch (Exception e) {
			System.out.println("Click on Next");
			wait.until(ExpectedConditions.elementToBeClickable(element.Next()));
			Thread.sleep(2000);
			action.moveToElement(element.Next()).click().build().perform();
		}
		wait.until(ExpectedConditions.elementToBeClickable(element.Next()));
		Thread.sleep(3000);
		action.moveToElement(element.Next()).click().build().perform();
		// test.log(LogStatus.INFO,"Wait until Next button is visible and and
		// click on it");

		Thread.sleep(2000);
		Helper.highLightElement(driver, element.industryList());
		int size = element.industryList().findElements(By.tagName("li")).size();
		System.out.println("Arts Industry contains " + size + " Categories");
		// test.log(LogStatus.INFO, "The number of elements available in
		// Industry box is : " + size);

		Thread.sleep(2000);
		action.moveToElement(element.Arts()).click().build().perform();
		Helper.highLightElement(driver, element.categoryList());
		int ArtsCategoris = element.categoryList().findElements(By.tagName("li")).size();
		System.out.println("Automatove Industry contains " + ArtsCategoris + " Categories");
		// test.log(LogStatus.INFO,"Click on Arts & Entertainment sector");

		Thread.sleep(2000);
		action.moveToElement(element.Automotive()).click().build().perform();
		Helper.highLightElement(driver, element.categoryList());
		int AutomotiveCategoris = element.categoryList().findElements(By.tagName("li")).size();
		System.out.println("Automotive Industry contains " + AutomotiveCategoris + " Categories");
		// test.log(LogStatus.INFO,"Click on Automotive sector");

		Thread.sleep(2000);
		action.moveToElement(element.Beauty()).click().build().perform();
		Helper.highLightElement(driver, element.categoryList());
		int BeautyCategoris = element.categoryList().findElements(By.tagName("li")).size();
		System.out.println("Beauty Industry contains " + BeautyCategoris + " Categories");
		// test.log(LogStatus.INFO,"Click on Beauty & Wellness sector");

		Thread.sleep(2000);
		action.moveToElement(element.Construction()).click().build().perform();
		Helper.highLightElement(driver, element.categoryList());
		int ConstructionCategoris = element.categoryList().findElements(By.tagName("li")).size();
		System.out.println("Construction Industry contains " + ConstructionCategoris + " Categories");
		// test.log(LogStatus.INFO,"Click on Construction & Handcraft sector");

		Thread.sleep(2000);
		action.moveToElement(element.Education()).click().build().perform();
		Helper.highLightElement(driver, element.categoryList());
		int EducationCategoris = element.categoryList().findElements(By.tagName("li")).size();
		System.out.println("Education Industry contains " + EducationCategoris + " Categories");
		// test.log(LogStatus.INFO,"Click on Education sector");
		Thread.sleep(2000); 

		WaitTypes wait = new WaitTypes(driver);
		wait.getVisibility(element.industryList(), 5).click();
		Helper.highLightElement(driver, element.categoryList());
		int PetsCategoris = element.categoryList().findElements(By.tagName("li")).size();
		System.out.println("Pets Industry contains " + PetsCategoris + " Categories");
		for (int i = 1; i <= 20; i++) {
			try {
				wait.clickElementWhenClickable(element.Pets(), 3);
				break;
			} catch (TimeoutException e) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("$(\"#ui_selectable_list\").animate({ scrollTop: \"" + 300 * i + "px\" })");
			}

		}
		// test.log(LogStatus.INFO,"Scroll to Pets element from he list");
		Thread.sleep(2000);
		action.moveToElement(element.Media()).click().build().perform();
		Helper.highLightElement(driver, element.categoryList());
		int MediaCategoris = element.categoryList().findElements(By.tagName("li")).size();
		System.out.println("Media Industry contains " + MediaCategoris + " Categories");

		Thread.sleep(2000);
		action.moveToElement(element.Leisure()).click().build().perform();
		Helper.highLightElement(driver, element.categoryList());
		int SportCategoris = element.categoryList().findElements(By.tagName("li")).size();
		System.out.println("Sport Industry contains " + SportCategoris + " Categories");

		Thread.sleep(2000);
		action.moveToElement(element.House()).click().build().perform();
		Helper.highLightElement(driver, element.categoryList());
		int GardenCategoris = element.categoryList().findElements(By.tagName("li")).size();
		System.out.println("Garden Industry contains " + GardenCategoris + " Categories");

		Thread.sleep(2000);
		action.moveToElement(element.Health()).click().build().perform();
		Helper.highLightElement(driver, element.categoryList());
		int HealthCategoris = element.categoryList().findElements(By.tagName("li")).size();
		System.out.println("Health Industry contains " + HealthCategoris + " Categories");

	}

	@Test
	public void c_categorySection() throws InterruptedException {

		Thread.sleep(2000);
		try {
			if (element.object().isDisplayed()) {
				System.out.println("Click on Tab");
				element.tab().click();
			}

		} catch (Exception e) {
			System.out.println("Click on Next");
			wait.until(ExpectedConditions.elementToBeClickable(element.Next()));
			Thread.sleep(2000);
			action.moveToElement(element.Next()).click().build().perform();
		}
		wait.until(ExpectedConditions.elementToBeClickable(element.Next()));
		Thread.sleep(3000);
		action.moveToElement(element.Next()).click().build().perform();
		// test.log(LogStatus.INFO, "Wait until Next button is visible and click
		// on it");
		Thread.sleep(2000);
		action.moveToElement(element.Automotive()).doubleClick().build().perform();
		// test.log(LogStatus.INFO,"Click on Automotive sector");
		Thread.sleep(2000);
		action.moveToElement(element.agricultural()).click().build().perform();
		// test.log(LogStatus.INFO, "Click on Agricultural Machinery Dealer");
		Thread.sleep(2000);
		action.moveToElement(element.automotive()).doubleClick().build().perform();
		// test.log(LogStatus.INFO, "DoubleClick on Automotive Paint Shop");
		Thread.sleep(2000);
		WaitTypes wait = new WaitTypes(driver);
		wait.getVisibility(element.categoryList(), 5).click();
		for (int i = 1; i <= 10; i++) {
			try {
				wait.clickElementWhenClickable(element.Manufacture(), 5);
				break;
			} catch (TimeoutException e) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript(
						"$(\"div[id*=\"ui_selectable_list_2\"]\").animate({ scrollTop: \"" + 120 * i + "px\" })");
			}
		}
		action.doubleClick(element.Manufacture()).build().perform();
		// test.log(LogStatus.INFO,"Scroll and select 'Car Manufacture'
		// Category");
		Thread.sleep(2000);
		action.moveToElement(element.carDealer()).doubleClick().build().perform();
		Thread.sleep(1000);
		action.moveToElement(element.newCarDealer()).doubleClick().build().perform();
		// test.log(LogStatus.INFO,"DoubleClick on 'Car Dealer' Category and
		// select 'New Car Dealer' Sector");
		int sectors = element.sectorField().findElements(By.tagName("span")).size();
		System.out.println(sectors);
		if (sectors == 4) {
			// test.log(LogStatus.PASS, "The number of added sectors is:" +
			// sectors);
			System.out.println("The number of added sectors is: " + sectors);
		} else {
			// test.log(LogStatus.ERROR, "Error");
			System.out.println("Error");
		}

		Thread.sleep(2000);
		Helper.highLightElement(driver, element.removeIcon());
		action.moveToElement(element.removeIcon()).click().build().perform();
		// test.log(LogStatus.INFO, "Remove first Sector");
		Thread.sleep(2000);
		Helper.highLightElement(driver, element.removeIcon());
		action.moveToElement(element.removeIcon()).click().build().perform();
		// test.log(LogStatus.INFO, "Remove second Sector");
		Thread.sleep(2000);
		Helper.highLightElement(driver, element.removeIcon());
		action.moveToElement(element.removeIcon()).click().build().perform();
		// test.log(LogStatus.INFO, "Remove third Sector");
		Thread.sleep(2000);
		Helper.highLightElement(driver, element.removeIcon());
		action.moveToElement(element.removeIcon()).click().build().perform();
		// test.log(LogStatus.INFO, "Remove last Sector");
		int removeSectors = element.sectorField().findElements(By.tagName("span")).size();
		System.out.println(removeSectors);
		if (removeSectors == 1) {
			// test.log(LogStatus.PASS, "The number of added sectors is:" +
			// sectors);
			System.out.println("The number of added sectors is: " + removeSectors +" .Test Pass.");
		} else {
			// test.log(LogStatus.ERROR, "Error");
			System.out.println("Error");
		}
		
	}

	@Test
	public void d_addSectorsManualy() throws InterruptedException {

		Thread.sleep(2000);
		try {
			if (element.object().isDisplayed()) {
				System.out.println("Click on Tab");
				element.tab().click();
			}

		} catch (Exception e) {
			System.out.println("Click on Next");
			wait.until(ExpectedConditions.elementToBeClickable(element.Next()));
			Thread.sleep(2000);
			action.moveToElement(element.Next()).click().build().perform();
		}

		wait.until(ExpectedConditions.elementToBeClickable(element.Next()));
		Thread.sleep(2000);
		action.moveToElement(element.Next()).click().build().perform();

		Thread.sleep(2000);
		element.sectorText().sendKeys("SEO");
		Thread.sleep(1000);
		action.sendKeys(Keys.ARROW_DOWN).pause(1000).sendKeys(Keys.ARROW_DOWN).pause(1000).sendKeys(Keys.ENTER).build()
				.perform();

		Thread.sleep(2000);
		// element.sectorText().clear();
		// Thread.sleep(1000);
		element.sectorText().sendKeys("MARKETING");
		Thread.sleep(1000);
		action.sendKeys(Keys.ARROW_DOWN).pause(1000).sendKeys(Keys.ENTER).build().perform();

		Thread.sleep(2000);
		// element.sectorText().clear();
		// Thread.sleep(1000);
		element.sectorText().sendKeys("MARK");
		Thread.sleep(2000);
		action.sendKeys(Keys.ARROW_DOWN).pause(1000).sendKeys(Keys.ARROW_DOWN).pause(1000).sendKeys(Keys.ARROW_DOWN)
				.pause(1000).sendKeys(Keys.ENTER).build().perform();

		Thread.sleep(2000);
		element.sectorText().sendKeys("SERVICES");
		Thread.sleep(2000);
		action.sendKeys(Keys.ARROW_DOWN).pause(1000).sendKeys(Keys.ENTER).build().perform();

		
		System.out.println("Place " + element.ForthIT().getText() + " first option in the field.");
		Helper.highLightElement(driver, element.FirstSeo());
		action.dragAndDrop(element.FirstSeo(), element.ForthIT()).build().perform();
		
		Thread.sleep(3000);
		Helper.highLightElement(driver, element.ForthIT());
		action.dragAndDrop(element.ForthIT(), element.SecondMarketing()).build().perform();
	
		System.out.println("Click on Next Button");
		element.NextButton().click();
		
		
	}
	

	@AfterMethod
	public void cookies() throws InterruptedException {
		Thread.sleep(4000);
		driver.manage().deleteAllCookies();
		driver.close();
		driver = null;
	}

}
