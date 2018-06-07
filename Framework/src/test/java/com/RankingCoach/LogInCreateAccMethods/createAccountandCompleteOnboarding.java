package com.RankingCoach.LogInCreateAccMethods;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import CreateAccount.MailHelper;
import RankingCoach.OnboardingPO;
import extentReport.report.ExtentReport;
import extentReport.testBase.TestBase;
import extentReport.testBase.TestEnvironment;
import extentReport.utility.AppConfig;
import pageObjects.LoginPage;

public class createAccountandCompleteOnboarding extends TestEnvironment {

	@Test(description = "Create new Accounts that include New User,Email Validation, Payment Data, Complete Onboarding")
	public void CreateNewAccountDE() throws Exception {

		TestBase.loadPropertiesFile();
		TestBase.driver.navigate().to(AppConfig.getURL());
		Thread.sleep(3000);

		Random rg = new Random();
		int randomInt = rg.nextInt(1000000);
		System.out.println("doesam848+" + randomInt + "@gmail.com");
		ExtentReport.test.log(LogStatus.INFO, "Generate a new user:doesam848+" + randomInt + "@gmail.com");

		driver.get("https://www.rankingcoach.com/a/zuora_secure");
		// driver.get("http://ami.dev.rankingcoach.com/a/zuora_secure");
		ExtentReport.test.log(LogStatus.INFO, "Add affliates by accessing the zuora_secure url");

		el.createAccButon().click();
		ExtentReport.test.log(LogStatus.INFO, "Click on Create Account button");
		Thread.sleep(1000);
		el.firstnamefield().sendKeys("Test");
		ExtentReport.test.log(LogStatus.INFO, "Type First Name");
		Thread.sleep(1000);
		el.lastnamefield().sendKeys("Test");
		ExtentReport.test.log(LogStatus.INFO, "Type Last Name");
		Thread.sleep(1000);
		el.emailfield().sendKeys("doesam848+" + randomInt + "@gmail.com");
		ExtentReport.test.log(LogStatus.INFO, "Type the Email Address");
		Thread.sleep(1000);
		el.passfield().sendKeys("test2109");
		ExtentReport.test.log(LogStatus.INFO, "Type the Password");
		el.register().click();
		ExtentReport.test.log(LogStatus.INFO, "Click on Create Account button");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(element.confirmText()));
		ExtentReport.test.log(LogStatus.INFO, "Confirmation Page is displayed: " + driver.getCurrentUrl());

		Thread.sleep(2000);
		MailHelper.main(null);
		// TestEmail.mainIT(null);;
		ExtentReport.test.log(LogStatus.INFO, "Verify Email and Access the confirmation URL");
		Thread.sleep(1000);
		// action.moveToElement(element.startTest()).click(element.startTest()).build().perform();
		ExtentReport.test.log(LogStatus.INFO, "Registration_dat page is displayed: " + driver.getCurrentUrl());

		wait.until(ExpectedConditions.elementToBeClickable(element.city()));
		ExtentReport.test.log(LogStatus.INFO, "Wait until user is able to select his country");
		Thread.sleep(2000);
		action.click(element.city()).pause(1000).sendKeys("Berlin").perform();
		action.sendKeys(Keys.ARROW_DOWN).pause(1000).sendKeys(Keys.ARROW_DOWN).pause(1000).build().perform();
		action.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		action.moveToElement(element.confirm()).pause(2000).click(element.confirm()).build().perform();
		ExtentReport.test.log(LogStatus.INFO, "User successfully select his address and press Confirm button ");

		Thread.sleep(3000);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("scroll(0,200)");

		wait.until(ExpectedConditions.visibilityOf(element.card()));
		Thread.sleep(3000);
		action.moveToElement(element.card()).click(element.card()).build().perform();
		ExtentReport.test.log(LogStatus.INFO, "User successfully select credit card option");
		Thread.sleep(2000);
		action.click(element.cardfield()).sendKeys("4242424242424242").build().perform();
		ExtentReport.test.log(LogStatus.INFO, "Card Number : 4242424242424242 ");
		Select select = new Select(element.month());
		select.selectByValue("12");
		ExtentReport.test.log(LogStatus.INFO, "Month : 12 ");
		Select selectyear = new Select(element.year());
		selectyear.selectByValue("2022");
		ExtentReport.test.log(LogStatus.INFO, "Expiration Year : 2022 ");
		action.moveToElement(element.cvc()).click(element.cvc()).sendKeys("222").build().perform();
		ExtentReport.test.log(LogStatus.INFO, "CVC : 222 ");
		Thread.sleep(2000);
		action.moveToElement(element.confrmcard()).click(element.confrmcard()).build().perform();
		ExtentReport.test.log(LogStatus.INFO, "User Press on Confirm Card button");
		Thread.sleep(18000);
		wait.until(ExpectedConditions.urlContains(prop.getProperty("dmurl")));

	}

//	@Test(dependsOnMethods = { "CreateNewAccountDE" })
//	public void CompleteOnboarding() throws InterruptedException, IOException {
//
//		TestBase.loadPropertiesFile();
//		/* TestBase.driver.navigate().to(AppConfig.getURL()); */
//		Thread.sleep(3000);
//
//		OnboardingPO onboarding = new OnboardingPO(driver);
//
//		/*
//		 * login.login().click(); Thread.sleep(1000);
//		 * login.username().sendKeys("doesam848+362241@gmail.com"); Thread.sleep(1000);
//		 * login.password().sendKeys("test2109"); Thread.sleep(1000);
//		 * login.submit().click();
//		 * 
//		 * Thread.sleep(4000);
//		 */
//
//		// action.click(onboarding.TutorialToggle()).perform();
////
//		wait.until(ExpectedConditions.visibilityOf(onboarding.VideoPlayer()));
//		if (onboarding.VideoPlayer().isDisplayed()) {
//
//			Thread.sleep(2000);
//			action.moveToElement(onboarding.CloseIcon()).click().perform();
//
//		} else {
//
//			System.out.println("Error");
//
//		}
//			
//		onboarding.addDomainAndPressCheck("www.rankingcoach.com");
//		
//
//		onboarding.checkThumbandPressNext();
//		
//		onboarding.CompleteDomainDetails();
//
//		onboarding.CompleteSectorPage();
//
//		onboarding.CustomersLocation();
//
//		onboarding.BusinessListing();
//
//		onboarding.Platform();
//
//		onboarding.KeyWords();
//
//		onboarding.SelectKeywords();
//
//		onboarding.KeywordsPriority();
//
//		onboarding.SelectCompetitors();
//
//		onboarding.analysisPage();
//
//		onboarding.Subscription();
//
//		Thread.sleep(8000);
//
//	}
	
	@Test(dependsOnMethods = { "CreateNewAccountDE" })
	public void AddNewDomain() throws InterruptedException, IOException {

		wait.until(ExpectedConditions.visibilityOf(onboarding.VideoPlayer()));
		if (onboarding.VideoPlayer().isDisplayed()) {

			Thread.sleep(2000);
			action.moveToElement(onboarding.CloseIcon()).click().perform();

		} else {

			System.out.println("Error");

		}

		TestBase.loadPropertiesFile();
		/* TestBase.driver.navigate().to(AppConfig.getURL()); */
		Thread.sleep(3000);

		onboarding.addDomainAndPressCheck("www.rankingcoach.com");

		onboarding.checkThumbandPressNext();
	}

	@Test(dependsOnMethods = { "AddNewDomain" })
	public void CompleteDomainDetails() throws InterruptedException {

		onboarding.CompleteDomainDetails();

	}

	@Test(dependsOnMethods = { "CompleteDomainDetails" })
	public void SelectBusinessSectors() throws InterruptedException {

		onboarding.CompleteSectorPage();

	}
	
	@Test(dependsOnMethods = { "SelectBusinessSectors" })
	public void Customerslocation() throws InterruptedException {

		onboarding.CustomersLocation();

	}
	
	@Test(dependsOnMethods = { "SelectBusinessSectors" })
	public void VerifyIfYourLocalDirectories() throws InterruptedException {

		onboarding.BusinessListing();

	}

	@Test(dependsOnMethods = { "Customerslocation" })
	public void SelectYourPlatform() throws InterruptedException {

		onboarding.Platform();

	}

	@Test(dependsOnMethods = { "VerifyIfYourLocalDirectories" })
	public void TypeYourKeyWords() throws InterruptedException {

		onboarding.KeyWords();
	}

	@Test(dependsOnMethods = { "TypeYourKeyWords" })
	public void SelectYourKeywords() throws InterruptedException {

		onboarding.SelectKeywords();
	}

	@Test(dependsOnMethods = { "SelectYourKeywords" })
	public void VerifyYourKeywords() throws InterruptedException {

		onboarding.KeywordsPriority();

	}

	@Test(dependsOnMethods = { "VerifyYourKeywords" })
	public void SelectCompetitors() throws InterruptedException {

		onboarding.SelectCompetitors();

	}

	@Test(dependsOnMethods = { "SelectCompetitors" })
	public void VeirifyAnalysisPage() throws InterruptedException {

		onboarding.analysisPage();

	}

	@Test(dependsOnMethods = { "VeirifyAnalysisPage" })
	public void UpgradeSubscriptionTo360() throws InterruptedException {

		onboarding.Subscription();

	}


//	 @Test
//	 public void test () throws IOException, InterruptedException {
//	
//	TestBase.loadPropertiesFile();
//	TestBase.driver.navigate().to(AppConfig.getURL());
//	Thread.sleep(3000);
//	
//	

	///WebElement tab
	// =driver.findElement(By.cssSelector("#keywords_input_tab_nav"));
	
//	login.login().click();
//	Thread.sleep(1000);
//	login.username().sendKeys("doesam848+784237@gmail.com");
//	Thread.sleep(1000);
//	login.password().sendKeys("test2109");
//	Thread.sleep(100);
//	login.submit().click();
//	
	//// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h1[text()='Bitte
	// warte']")));
	//// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h1[text()='Bitte
	// wähle deine Konkurrenten aus.']")));
	////
	//// //wait.until(ExpectedConditions.("tab"));
	////
	//// Thread.sleep(6000);
	//// driver.findElement(By.cssSelector("#competitors_tab_nav")).click();
	////
	//// //onboarding.KeyWords();
	//// Thread.sleep(2000);
	//// driver.findElement(By.linkText("WEITER")).click();
	////
	//// wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#btn-save-keywords-bubble
	// .hidden-xxs"))));
	//// Thread.sleep(5000);
	//// driver.findElement(By.cssSelector("#btn-save-keywords-bubble
	// .hidden-xxs")).click();
	//// //onboarding.SelectKeywords();
	//
	// //Thread.sleep(3000);
	// //driver.findElement(By.cssSelector("#competitors_tab_nav")).click();
//
//	onboarding.addDomainAndPressCheck("www.rankingcoach.com");
//	
//	onboarding.checkThumbandPressNext();

	
	
	//// onboarding.CompleteDomainDetails();
	////
	//// onboarding.CompleteSectorPage();
	////
	//// onboarding.CustomersLocation();
	////
	//// onboarding.BusinessListing();
	////
	//// onboarding.Platform();
	////
	//// onboarding.KeyWords();
	////
	//// onboarding.SelectKeywords();
	////
	//// onboarding.KeywordsPriority();
	////
	//// onboarding.SelectCompetitors();
	//
	//// onboarding.analysisPage();
	//
	// onboarding.Subscription();
	//
	// Thread.sleep(8000);
	
//	 }
}
