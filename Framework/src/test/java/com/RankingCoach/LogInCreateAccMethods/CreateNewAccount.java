package com.RankingCoach.LogInCreateAccMethods;

import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import CreateAccount.MailHelper;
import CreateAccount.TestEmail;
import Resources.Helper;
import extentReport.report.ExtentReport;
import extentReport.testBase.TestBase;
import extentReport.testBase.TestEnvironment;
import extentReport.utility.AppConfig;
import pageObjects.CreateAccountObj;
import pageObjects.LoginPage;
import pageObjects.domainnameobj;

public class CreateNewAccount extends TestEnvironment {
	
	public static ExtentReports extent;
	public static ExtentTest test;

	@Test(description = "Create new Accounts that include New User,Email Validation, Payment Data, Complete Onboarding")
	public void CreateNewAccountDE() throws Exception {

		TestBase.loadPropertiesFile();
		TestBase.driver.navigate().to(AppConfig.getURL());
		Thread.sleep(3000);

		Random rg = new Random();
		int randomInt = rg.nextInt(1000000);
		System.out.println("doesam848+" + randomInt + "@gmail.com");
		ExtentReport.test.log(LogStatus.INFO, "Generate a new user:doesam848+" + randomInt + "@gmail.com");

		//driver.get("https://www.rankingcoach.com/a/zuora_secure");
		driver.get("http://ami.dev.rankingcoach.com/a/zuora_secure");
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
		/*
		 * // Open new blank tab ((JavascriptExecutor)
		 * driver).executeScript("window.open('about:blank','_blank')"); //Switch from
		 * prent tab to child tab Set<String> ids = driver.getWindowHandles();
		 * Iterator<String> pg = ids.iterator(); String parentpage = pg.next(); String
		 * childpage = pg.next(); System.out.println("After Switching to child");
		 * driver.switchTo().window(childpage); driver.navigate().to(
		 * "http://rft.dev.rankingcoach.com/en-us/ricci/swissarmy_knife?email=doesam848+"
		 * + randomInt+ "@gmail.com"); Thread.sleep(2000); driver.close();
		 * driver.switchTo().window(parentpage);
		 */

		Thread.sleep(2000);
		MailHelper.main(null);
		// TestEmail.mainIT(null);;
		ExtentReport.test.log(LogStatus.INFO, "Verify Email and Access the confirmation URL");
		Thread.sleep(1000);
		// action.moveToElement(element.startTest()).click(element.startTest()).build().perform();
		ExtentReport.test.log(LogStatus.INFO, "Registration_dat page is displayed: " + driver.getCurrentUrl());

		/*
		 * System.out.println(element.email().getText());
		 * action.moveToElement(element.email()).click(element.email()).build().perform(
		 * ); Thread.sleep(2000);
		 * action.moveToElement(element.confirmationButton()).click(element.
		 * confirmationButton()).build().perform(); Thread.sleep(4000); Set<String> ids
		 * = driver.getWindowHandles(); Iterator<String> pg = ids.iterator(); String
		 * parentpage = pg.next(); String childpage = pg.next();
		 * System.out.println("After Switching to child");
		 * driver.switchTo().window(childpage);
		 */

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

	@Test(description="Log in into app using Facebook")
	public void LogInWithFacebook() throws Exception {

		TestBase.loadPropertiesFile();
		TestBase.driver.navigate().to(AppConfig.getURL());
		Thread.sleep(3000);

		// User is allready used
		// driver.get("https://www.rankingcoach.com/a/zuora_secure");

		el.createAccButon().click();
		Thread.sleep(1000);
		action.moveToElement(element.FB_BUTTON()).pause(2000).perform();
		action.click(element.FB_BUTTON()).perform();
		ExtentReport.test.log(LogStatus.INFO,
				"Open Create Account Interface and Press on'mit Facebook anmelden' button");
		Thread.sleep(2000);

		Set<String> ids = driver.getWindowHandles();
		Iterator<String> pg = ids.iterator();
		String parentpage = pg.next();
		String childpage = pg.next();
		driver.switchTo().window(childpage);
		action.click(element.FB_USER()).sendKeys("samdoe306@gmail.com").perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.TAB).sendKeys("TEST2109").perform();
		action.sendKeys(Keys.ENTER).perform();
		ExtentReport.test.log(LogStatus.INFO,
				"Switch to FaceBook window and insert user credentials:samdoe306@gmail.com/TEST2109 ");

		driver.switchTo().window(parentpage);
		Helper.highLightElement(driver, element.FB_ErrorAE());
		ExtentReport.test.log(LogStatus.INFO,
				"If account exists the fallowing error should be displayed: " + element.FB_ErrorAE().getText());
		String FBerror = element.FB_ErrorAE().getText();
		if (FBerror.equals(prop.getProperty("Emailexist"))) {
			driver.navigate().refresh();
			wait.until(ExpectedConditions.elementToBeClickable(login.login()));
			Thread.sleep(2000);
			login.login().click();
			Thread.sleep(1000);
			action.click(login.username()).sendKeys("samdoe306@gmail.com").perform();
			Thread.sleep(1000);
			action.click(login.password()).sendKeys("TEST2109").perform();
			Thread.sleep(1000);
			action.click(login.submit()).perform();
			ExtentReport.test.log(LogStatus.INFO,
					"After Acc. Already exists error is displayed go in Log In view and try to Log In with the FB credentials ");

			// String error = login.error3().getText();
			wait.until(ExpectedConditions.visibilityOf(login.error3()));
			ExtentReport.test.log(LogStatus.INFO, "An error is displayed: " + login.error3().getText());

			if (login.error3().isDisplayed()) {

				Thread.sleep(2000);
				action.click(element.FB_BUTTON()).perform();
				// driver.getCurrentUrl();
				wait.until(ExpectedConditions.urlContains(prop.getProperty("dmurl")));
				ExtentReport.test.log(LogStatus.INFO,
						"Press on 'mit Facebook einloggen' button and you should be redirected to Enboardind View");
				Thread.sleep(2000);
				action.moveToElement(domain.DomainField()).click().perform();
				domain.DomainField().sendKeys(prop.getProperty("url"));
				Thread.sleep(2000);
				domain.CheckWebsite().click();
				ExtentReport.test.log(LogStatus.INFO, "Add a website in domain field and press checkwebsite ");

				wait.until(ExpectedConditions.visibilityOf(domain.thumbcontent()));
				// Assert.assertTrue(domain.thumbcontent().isDisplayed());
				// Assert.assertTrue(domain.Next().isDisplayed());
				ExtentReport.test.log(LogStatus.INFO, "The thumb with your added website is displayed");

			} else {

				ExtentReport.test.log(LogStatus.ERROR, "Something went wrong please verify ");
				System.out.println("Error message is not displayed ");

			}

		} else {
			ExtentReport.test.log(LogStatus.ERROR, "Error message is not displayed or something went wrong");
			System.out.println("Error message didn't appear: ERROR");
		}

		// Go in Personal Data and verify user subscription

		action.moveToElement(element.dataicon()).pause(2000).perform();
		action.click(element.personaldata()).perform();
		action.click(element.subscription()).perform();
		ExtentReport.test.log(LogStatus.INFO, "Go in " + element.dataicon().getText() + " and click on "
				+ element.personaldata().getText() + "and select" + element.subscription().getText());

		wait.until(ExpectedConditions.visibilityOf(element.subsContent()));
		String Subscription = element.subsContent().getText();
		String SubscriptionPrice = element.subsPrice().getText();
		String SubscriptionStatus = element.subsStatus().getText();
		// String Content = element.PopUpContent().getText();
		WebElement SubscriptionAction = element.subsAction();
		// if(Subscription.equals())
		System.out.println(Subscription);
		System.out.println(SubscriptionPrice);
		System.out.println(SubscriptionStatus);
		// Remove space (/br) between the words
		String Price = SubscriptionPrice.replaceAll("\\r\\n|\\r|\\n", " ");

		if (Subscription.contains(prop.getProperty("SubsContent")) && Price.contains(prop.getProperty("SubsPrice"))
				&& SubscriptionStatus.contains(prop.getProperty("SubsStatus")) && SubscriptionAction.isDisplayed()) {
			Helper.highLightElement(driver, element.subsContent());
			ExtentReport.test.log(LogStatus.INFO,
					"User should have standard subscription: " + element.subsContent().getText());
			Thread.sleep(1000);
			Helper.highLightElement(driver, element.subsPrice());
			ExtentReport.test.log(LogStatus.INFO,
					"The Cost should be 24.95 Euro per Month: " + element.subsPrice().getText());
			Thread.sleep(1000);
			Helper.highLightElement(driver, element.subsStatus());
			ExtentReport.test.log(LogStatus.INFO, "Status should be Active " + element.subsStatus().getText());
			Thread.sleep(1000);
			Helper.highLightElement(driver, SubscriptionAction);
			Thread.sleep(1000);
			action.moveToElement(SubscriptionAction).pause(2000).perform();
			action.click(SubscriptionAction).perform();
			Thread.sleep(1000);
			ExtentReport.test.log(LogStatus.INFO, "Click on Action Button");

			if (element.subsCancelPopUp().isDisplayed()) {

				// Close the PopUp
				Helper.highLightElement(driver, element.CancelButton());
				Thread.sleep(1000);
				element.CancelButton().click();
				ExtentReport.test.log(LogStatus.INFO, "Press CANCEL button from the action pop-up");

			} else {
				ExtentReport.test.log(LogStatus.ERROR, "Something went wrong with the action button");
				System.out.println("ERROR IN CANCEL SUBS POPUP");
			}

		} else {

			ExtentReport.test.log(LogStatus.ERROR, "Something is not OK in Subscription View");
			System.out.println("Fail");

		}

		Thread.sleep(2000);
		CreateNewAccount remove = new CreateNewAccount();
		remove.removeDomain();

	}

	@Test(description="Try to create accounts from FEATURES Page")
	public void CreateAccountFromDifferentPages() throws InterruptedException, IOException {
		
		TestBase.loadPropertiesFile();
		TestBase.driver.navigate().to(AppConfig.getURL());
		Thread.sleep(3000);

		wait.until(ExpectedConditions.elementToBeClickable(element.features()));
		String Features = element.features().getText();
		action.click(element.features()).perform();
		ExtentReport.test.log(LogStatus.PASS, "Click on " + Features + " Button.Page URL is " + driver.getCurrentUrl());

		Thread.sleep(2000);
		if (element.Test_for_free1().isDisplayed()) {
			action.moveToElement(element.Test_for_free1()).pause(2000).perform();
			action.click(element.Test_for_free1()).perform();
			ExtentReport.test.log(LogStatus.PASS, "Click on firs Test for Free Button");
			Thread.sleep(1000);
			action.moveToElement(element.FB_BUTTON()).pause(2000).perform();
			action.click(element.FB_BUTTON()).perform();
			Set<String> ids = driver.getWindowHandles();
			Iterator<String> pg = ids.iterator();
			String parentpage = pg.next();
			String childpage = pg.next();
			System.out.println("After Switching to child");
			driver.switchTo().window(childpage);
			action.click(element.FB_USER()).sendKeys("samdoe306@gmail.com").perform();
			Thread.sleep(1000);
			action.sendKeys(Keys.TAB).sendKeys("TEST2109").perform();
			action.sendKeys(Keys.ENTER).perform();
			driver.switchTo().window(parentpage);
			String Error = element.FB_Error_Feature().getText();
			Helper.highLightElement(driver, element.FB_Error_Feature());
			ExtentReport.test.log(LogStatus.PASS,
					"Try to create Account using Facebook option.Account already exists Error should be displayed : "
							+ Error);

		} else {

			System.out.println("TEST FOR FREE button is not available:ERROR");
			ExtentReport.test.log(LogStatus.ERROR, "TEST FOR FREE button is not available:ERROR");
		}

		if (element.Test_for_free2().isDisplayed()) {
			// Scroll to your element
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			Thread.sleep(5000);
			js.executeScript("scroll(0,1600)");
			Thread.sleep(2000);
			element.Test_for_free2().click();
			ExtentReport.test.log(LogStatus.INFO, "Scroll to the second Test For Free Button and Press on it");
			Thread.sleep(1000);
			action.moveToElement(element.FB_BUTTON()).pause(2000).perform();
			action.click(element.FB_BUTTON()).perform();
			// String Error = element.FB_Error_Feature().getText();

			Helper.highLightElement(driver, element.FB_Error_Feature());
			ExtentReport.test.log(LogStatus.PASS,
					"Try to create Account using Facebook option.Account already exists Error should be displayed : "
							+ element.FB_Error_Feature().getText());

		} else {

			System.out.println("TEST FOR FREE button is not available:ERROR");
			ExtentReport.test.log(LogStatus.ERROR, "TEST FOR FREE button is not available:ERROR");
		}

		if (element.Sign_up1().isDisplayed()) {
			// Scroll to your element
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			Thread.sleep(5000);
			js.executeScript("scroll(1600,0)");
			Thread.sleep(2000);
			element.Sign_up1().click();
			ExtentReport.test.log(LogStatus.INFO,
					"Scroll to the " + element.Sign_up1().getText() + " Button and Press on it");
			Thread.sleep(1000);
			action.moveToElement(element.FB_BUTTON()).pause(2000).perform();
			action.click(element.FB_BUTTON()).perform();

			Helper.highLightElement(driver, element.FB_Error_Feature());
			ExtentReport.test.log(LogStatus.PASS,
					"Try to create Account using Facebook option.Account already exists Error should be displayed : "
							+ element.FB_Error_Feature().getText());

		} else {

			System.out.println("Sign Up button is not available:ERROR");
			ExtentReport.test.log(LogStatus.ERROR, "Sign Up button is not available:ERROR");
		}

		if (element.Sign_up2().isDisplayed()) {
			// Scroll to your element
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			Thread.sleep(5000);
			js.executeScript("scroll(0,1600)");
			Thread.sleep(2000);
			element.Sign_up2().click();
			ExtentReport.test.log(LogStatus.INFO,
					"Scroll to the second " + element.Sign_up2().getText() + " Button and Press on it");
			Thread.sleep(1000);
			action.moveToElement(element.FB_BUTTON()).pause(2000).perform();
			action.click(element.FB_BUTTON()).perform();

			Helper.highLightElement(driver, element.FB_Error_Feature());
			ExtentReport.test.log(LogStatus.PASS,
					"Try to create Account using Facebook option.Account already exists Error should be displayed : "
							+ element.FB_Error_Feature().getText());

		} else {

			System.out.println("Sign up button is not available:ERROR");
			ExtentReport.test.log(LogStatus.ERROR, "Second Sign Up button is not available:ERROR");
		}

	}

	public void removeDomain() throws InterruptedException {

		Thread.sleep(2000);
		action.moveToElement(domain.SettingsButton()).click().build().perform();
		ExtentReport.test.log(LogStatus.INFO, "Click on Manage sites Icon");
		Thread.sleep(2000);
		Assert.assertTrue(domain.addedSite().isDisplayed());
		ExtentReport.test.log(LogStatus.INFO, "Verify if added site is displayed in Manage Projects");
		Thread.sleep(2000);
		action.moveToElement(domain.addedSite()).click(domain.deleteSite()).perform();
		ExtentReport.test.log(LogStatus.INFO, "Click on Delete Icon and verify if the confirmatio window is displayed");
		Thread.sleep(2000);
		action.moveToElement(domain.deletesiteNo()).click().build().perform();
		ExtentReport.test.log(LogStatus.INFO, "From displayed window Click on NO button");
		Assert.assertTrue(domain.addedSite().isDisplayed());
		ExtentReport.test.log(LogStatus.INFO, "Added site should be displayed");
		Thread.sleep(2000);
		// Delete the your Added WebSite
		action.moveToElement(domain.deleteSite()).click(domain.deleteSite()).perform();
		ExtentReport.test.log(LogStatus.INFO, "Click again on Remove Icon,Confirmation window should open again");
		Thread.sleep(2000);
		action.moveToElement(domain.deletesiteYes()).click().perform();
		ExtentReport.test.log(LogStatus.INFO, "From displayed window Click on YES button");
		Thread.sleep(4000);
		// Assert.assertTrue(domain.addedSite().isDisplayed());
		// ExtentReport.test.log(LogStatus.INFO, "Site is not displayed anymore");
		// Thread.sleep(3000);

	}
	
	@Test
	public void CreateAccountLogInWithGoogle() throws InterruptedException, IOException {

		TestBase.loadPropertiesFile();
		TestBase.driver.navigate().to(AppConfig.getURL());
		Thread.sleep(3000);
		
	
		
		
		el.createAccButon().click();
		ExtentReport.test.log(LogStatus.INFO, "Open Create Account interface");
		Thread.sleep(1000);
		action.moveToElement(el.SignUpGoogle()).pause(2000).perform();
		action.click(el.SignUpGoogle()).perform();
		ExtentReport.test.log(LogStatus.INFO, "Hover over the SignUp with Google Button and after click on it");
		Thread.sleep(3000);
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> pg = ids.iterator();
		String parentpage = pg.next();
		String childpage = pg.next();
		System.out.println("After Switching to child");
		driver.switchTo().window(childpage);
		Thread.sleep(1000);
		action.moveToElement(el.GoogleEmail()).sendKeys("doesam848@gmail.com").perform();
		action.sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);
		action.moveToElement(el.GooglePass()).sendKeys("test12345678");
		Thread.sleep(1000);
		action.sendKeys(Keys.ENTER).perform();
		ExtentReport.test.log(LogStatus.INFO, "Enter email and Password and press submit");
		driver.switchTo().window(parentpage);
		wait.until(ExpectedConditions.invisibilityOf(element.GoogleError()));
		Helper.highLightElement(driver, element.GoogleError());
		String googleerror = element.GoogleError().getText();
		System.out.println(googleerror);
		ExtentReport.test.log(LogStatus.INFO, "Account allready exists error should be displayed: " +element.GoogleError().getText());
		if (googleerror.equals(prop.getProperty("googleerror"))) {
			driver.navigate().refresh();
			wait.until(ExpectedConditions.elementToBeClickable(login.login()));
			Thread.sleep(2000);
			login.login().click();
			Thread.sleep(1000);
			action.click(login.username()).sendKeys("samdoe306@gmail.com").perform();
			Thread.sleep(1000);
			action.click(login.password()).sendKeys("test12345678").perform();
			Thread.sleep(1000);
			action.click(login.submit()).perform();

			wait.until(ExpectedConditions.visibilityOf(login.error3()));
			Helper.highLightElement(driver, login.error3());
			ExtentReport.test.log(LogStatus.INFO, "Open Sign in view and try to log in with google Credentials");

			if (login.error3().isDisplayed()) {

				// Thread.sleep(2000);
				//action.moveToElement(element.LoginGoogle()).perform();
				element.LoginGoogle().click();
				// driver.getCurrentUrl();
				wait.until(ExpectedConditions.urlContains(prop.getProperty("dmurl")));
				ExtentReport.test.log(LogStatus.INFO, "After error is displayed Press on log with google button, user is redirected to Onboarding");
				Thread.sleep(2000);

			} else {

				System.out.println("Error message is not displayed ");
				ExtentReport.test.log(LogStatus.ERROR, "Log In button didn't work or user is not redirect to Onboarding");

			}

		} else {

			System.out.println("error");
			ExtentReport.test.log(LogStatus.ERROR, "Error message was not displayed or something went wrong in Create Account with google");
		}

		// System.out.println(domain.DomainField().isEnabled());

		if (domain.DomainField().isEnabled()) {
			
			action.moveToElement(domain.SettingsButton()).click().build().perform();
			ExtentReport.test.log(LogStatus.INFO, "Click on Manage projects icon");
			Thread.sleep(2000);
			Assert.assertTrue(domain.AddNewSite().isDisplayed());
			ExtentReport.test.log(LogStatus.INFO, "Verify if add new site case si displayed");
			action.moveToElement(domain.AddNewSite()).click().build().perform();
			ExtentReport.test.log(LogStatus.INFO, "Click on add new site case ");
			Thread.sleep(2000);
			action.moveToElement(domain.addSitebuttonYes()).click().perform();
			wait.until(ExpectedConditions.visibilityOf(domain.DomainField()));
			domain.DomainField().sendKeys(prop.getProperty("url"));
			Thread.sleep(2000);
			domain.CheckWebsite().click();
			wait.until(ExpectedConditions.visibilityOf(domain.thumbcontent()));
			Assert.assertTrue(domain.thumbcontent().isDisplayed());
			Assert.assertTrue(domain.Next().isDisplayed());

		} else {
			
			Thread.sleep(2000);
			domain.DomainField().clear();
			domain.DomainField().sendKeys(prop.getProperty("url"));
			Thread.sleep(2000);
			domain.CheckWebsite().click();
			wait.until(ExpectedConditions.visibilityOf(domain.thumbcontent()));
			Assert.assertTrue(domain.thumbcontent().isDisplayed());
			Assert.assertTrue(domain.Next().isDisplayed());

		}
	}

}
