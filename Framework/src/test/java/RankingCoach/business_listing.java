package RankingCoach;

import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import CreateAccount.MailHelper;
import Resources.Base;
import Resources.Helper;
import extentReport.report.ExtentReport;
import extentReport.testBase.TestBase;
import extentReport.testBase.TestEnvironment;
import extentReport.utility.AppConfig;
import pageObjects.CreateAccountObj;
import pageObjects.LoginPage;
import pageObjects.business_listingObj;
import pageObjects.domainnameobj;

public class business_listing extends TestEnvironment {


	/*@BeforeMethod
	public void initialize() throws IOException, InterruptedException {

		//driver = getBrowser("chrome");
		//TestBase.loadPropertiesFile();
		///TestBase.driver.navigate().to(AppConfig.getURL());
		///driver.get(prop.getProperty("url"));
		//driver.manage().window().maximize();

		
		 * LoginPage er = new LoginPage(driver); er.login().click(); Thread.sleep(1000);
		 * er.username().sendKeys(prop.getProperty("email")); Thread.sleep(1000);
		 * er.password().sendKeys(prop.getProperty("pass")); Thread.sleep(1000);
		 * er.submit().click(); driver.manage().window().maximize();
		 
	}*/

	/*@AfterMethod
	public void cookies() throws InterruptedException {
		Thread.sleep(4000);
		driver.manage().deleteAllCookies();
		driver.close();
		driver = null;
	}*/

	@Test
	public void a_pageContent() throws InterruptedException {
		Thread.sleep(3000);
		// String currenUrl = driver.getCurrentUrl();
		// System.out.println(currenUrl);
		// String SubHeaderText = element.subHeader().getText();
		String Headertext = element.Header().getText();
		try {
			if (element.GreenBar().isDisplayed()) {
				Helper.highLightElement(driver, element.Header());
				// System.out.println(text);
				// System.out.print(prop.getProperty("Headline1") +
				// element.number().getText() + prop.getProperty("Headline2"));

				if (Headertext.matches(
						prop.getProperty("Headline1") + element.number().getText() + prop.getProperty("Headline1.1"))) {

					System.out.println("Header Text is correct displayed");

				} else {

					System.out.println("ERROR:Something is wrong with the Header text");
				}

			}

		} catch (Exception e) {
			Helper.highLightElement(driver, element.Header());

		}

	}

	@Test
	public void CrateNewAcccount() throws Exception {
		
		TestBase.loadPropertiesFile();
		TestBase.driver.navigate().to(AppConfig.getURL());
		Thread.sleep(3000);
		// System.out.println(element.GreenBar().isDisplayed());
		// driver.get("https://accounts.google.com");

		// CheckEmail email = new CheckEmail();

		/*
		 * Thread.sleep(2000);
		 * action.moveToElement(element.name()).click(element.name()).sendKeys(
		 * "doesam848@gmail.com").perform();
		 * action.sendKeys(Keys.ENTER).build().perform(); Thread.sleep(2000);
		 * action.moveToElement(element.pass()).click(element.pass()).sendKeys(
		 * "test12345678").perform(); action.sendKeys(Keys.ENTER).build().perform();
		 * Thread.sleep(2000);
		 * action.moveToElement(element.icon()).click(element.icon()).build().perform();
		 * Thread.sleep(3000);
		 * GMail.automateGmailUsingImap("doesam848@gmail.com","test12345678");
		 */

		Random rg = new Random();

		int randomInt = rg.nextInt(1000000);
		System.out.println("samdoe306" + randomInt + "@gmail.com");

		driver.get("https://www.rankingcoach.com/a/zuora_secure");
		el = new CreateAccountObj(driver);
		el.createAccButon().click();
		Thread.sleep(1000);
		el.firstnamefield().sendKeys("Test");
		Thread.sleep(1000);
		el.lastnamefield().sendKeys("Test");
		Thread.sleep(1000);
		el.emailfield().sendKeys("samdoe306+" + randomInt + "@gmail.com");
		Thread.sleep(1000);
		el.passfield().sendKeys("test2109");
		el.register().click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(element.confirmText()));
		
		// Open new blank tab
		// ((JavascriptExecutor)
		// driver).executeScript("window.open('about:blank','_blank')");
		// Switch from prent tab to child tab
		// Set<String> ids = driver.getWindowHandles();
		// Iterator<String> pg = ids.iterator();
		// String parentpage = pg.next();
		// String childpage = pg.next();
		// System.out.println("After Switching to child");
		// driver.switchTo().window(childpage);
		// driver.navigate().to("http://rft.dev.rankingcoach.com/en-us/ricci/swissarmy_knife?email=doesam848+"
		// + randomInt+ "@gmail.com");
		// Thread.sleep(2000);
		// driver.close();
		// driver.switchTo().window(parentpage);
		
		Thread.sleep(2000);
		MailHelper.main(null);
		Thread.sleep(1000);
		action.moveToElement(element.startTest()).click(element.startTest()).build().perform();
		
		// System.out.println(element.email().getText());
		// action.moveToElement(element.email()).click(element.email()).build().perform();
		// Thread.sleep(2000);
		// action.moveToElement(element.confirmationButton()).click(element.confirmationButton()).build().perform();
		// Thread.sleep(4000);
		// Set<String> ids = driver.getWindowHandles();
		// Iterator<String> pg = ids.iterator();
		// String parentpage = pg.next();
		// String childpage = pg.next();
		// System.out.println("After Switching to child");
		// driver.switchTo().window(childpage);
		
		System.out.println(driver.getCurrentUrl());
		wait.until(ExpectedConditions.elementToBeClickable(element.city()));
		Thread.sleep(2000);
		action.click(element.city()).pause(1000).sendKeys("Berlin").perform();
		action.sendKeys(Keys.ARROW_DOWN).pause(1000).sendKeys(Keys.ARROW_DOWN).pause(1000).build().perform();
		action.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		action.moveToElement(element.confirm()).pause(2000).click(element.confirm()).build().perform();
		Thread.sleep(3000);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("scroll(0,200)");
		wait.until(ExpectedConditions.visibilityOf(element.card()));
		Thread.sleep(3000);
		action.moveToElement(element.card()).click(element.card()).build().perform();
		Thread.sleep(2000);
		action.click(element.cardfield()).sendKeys("4242424242424242").build().perform();
		Select select = new Select(element.month());
		select.selectByValue("12");
		Select selectyear = new Select(element.year());
		selectyear.selectByValue("2022");
		action.moveToElement(element.cvc()).click(element.cvc()).sendKeys("222").build().perform();
		Thread.sleep(2000);
		action.moveToElement(element.confrmcard()).click(element.confrmcard()).build().perform();
		Thread.sleep(18000);
	}

	@Test
	public void CreateAccountLogInWithFb() throws Exception {
		
		TestBase.loadPropertiesFile();
		TestBase.driver.navigate().to(AppConfig.getURL());
		Thread.sleep(3000);

		// User is allready used
		// driver.get("https://www.rankingcoach.com/a/zuora_secure");
		el = new CreateAccountObj(driver);
		LoginPage login = new LoginPage(driver);
		domain = new domainnameobj(driver);
		el.createAccButon().click();
		Thread.sleep(1000);
		action.moveToElement(element.FB_BUTTON()).pause(2000).perform();
		action.click(element.FB_BUTTON()).perform();
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> pg = ids.iterator();
		String parentpage = pg.next();
		String childpage = pg.next();
		System.out.println("After Switching to child");
		driver.switchTo().window(childpage);
		// driver.manage().window().maximize();
		action.click(element.FB_USER()).sendKeys("samdoe306@gmail.com").perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.TAB).sendKeys("TEST2109").perform();
		action.sendKeys(Keys.ENTER).perform();
		driver.switchTo().window(parentpage);
		Helper.highLightElement(driver, element.FB_ErrorAE());
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

			// String error = login.error3().getText();
			wait.until(ExpectedConditions.visibilityOf(login.error3()));

			if (login.error3().isDisplayed()) {

				Thread.sleep(2000);
				action.click(element.FB_BUTTON()).perform();
				// driver.getCurrentUrl();
				wait.until(ExpectedConditions.urlContains(prop.getProperty("dmurl")));
				Thread.sleep(2000);
				domain.DomainField().clear();
				domain.DomainField().sendKeys(prop.getProperty("url"));
				Thread.sleep(2000);
				domain.CheckWebsite().click();

				WebDriverWait time = new WebDriverWait(driver, 9);
				time.until(ExpectedConditions.visibilityOf(domain.thumbcontent()));
				Assert.assertTrue(domain.thumbcontent().isDisplayed());
				Assert.assertTrue(domain.Next().isDisplayed());

			} else {

				System.out.println("Error message is not displayed ");

			}

		} else {

			System.out.println("Error message didn't appear: ERROR");
		}

		// Go in Personal Data and verify user subscription

		action.moveToElement(element.dataicon()).pause(2000).perform();
		action.click(element.personaldata()).perform();
		action.click(element.subscription()).perform();
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
			Thread.sleep(1000);
			Helper.highLightElement(driver, element.subsPrice());
			Thread.sleep(1000);
			Helper.highLightElement(driver, element.subsStatus());
			Thread.sleep(1000);
			Helper.highLightElement(driver, SubscriptionAction);
			Thread.sleep(1000);
			action.moveToElement(SubscriptionAction).pause(2000).perform();
			action.click(SubscriptionAction).perform();
			Thread.sleep(1000);
			if (element.subsCancelPopUp().isDisplayed()) {

				// Close the PopUp
				Helper.highLightElement(driver, element.CancelButton());
				Thread.sleep(1000);
				element.CancelButton().click();

			} else {

				System.out.println("ERROR IN CANCEL SUBS POPUP");
			}

		} else {

			System.out.println("Fail");

		}

	}

	@Test
	public void CreateAccountLogInWithGoogle() throws InterruptedException, IOException {

		TestBase.loadPropertiesFile();
		TestBase.driver.navigate().to(AppConfig.getURL());
		Thread.sleep(3000);
		
		el = new CreateAccountObj(driver);
		LoginPage login = new LoginPage(driver);
		domain = new domainnameobj(driver);
		ExtentReport.test.log(LogStatus.INFO, "click");
		el.createAccButon().click();
		Thread.sleep(1000);
		action.moveToElement(el.SignUpGoogle()).pause(2000).perform();
		action.click(el.SignUpGoogle()).perform();
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
		driver.switchTo().window(parentpage);
		wait.until(ExpectedConditions.invisibilityOf(element.GoogleError()));
		Helper.highLightElement(driver, element.GoogleError());
		String googleerror = element.GoogleError().getText();
		System.out.println(googleerror);
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

			if (login.error3().isDisplayed()) {

				// Thread.sleep(2000);
				//action.moveToElement(element.LoginGoogle()).perform();
				element.LoginGoogle().click();
				// driver.getCurrentUrl();
				wait.until(ExpectedConditions.urlContains(prop.getProperty("dmurl")));
				Thread.sleep(2000);

			} else {

				System.out.println("Error message is not displayed ");

			}

		} else {

			System.out.println("error");
		}

		// System.out.println(domain.DomainField().isEnabled());

		if (domain.DomainField().isEnabled()) {
			action.moveToElement(domain.SettingsButton()).click().build().perform();
			// test.log(LogStatus.INFO, "Click on Manage projects icon");
			Thread.sleep(2000);
			Assert.assertTrue(domain.AddNewSite().isDisplayed());
			// test.log(LogStatus.INFO, "Verify if add new site case si displayed");
			action.moveToElement(domain.AddNewSite()).click().build().perform();
			// test.log(LogStatus.INFO, "Click on add new site case ");
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

	@Test
	public void CreateAccountFromDifferentPages() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(element.features()));
		action.click(element.features()).perform();
		Thread.sleep(2000);
		if (element.Test_for_free1().isDisplayed()) {
			action.moveToElement(element.Test_for_free1()).pause(2000).perform();
			action.click(element.Test_for_free1()).perform();
			Thread.sleep(1000);
			action.moveToElement(element.FB_BUTTON()).pause(2000).perform();
			action.click(element.FB_BUTTON()).perform();
			Set<String> ids = driver.getWindowHandles();
			Iterator<String> pg = ids.iterator();
			String parentpage = pg.next();
			String childpage = pg.next();
			System.out.println("After Switching to child");
			driver.switchTo().window(childpage);
			driver.manage().window().maximize();
			action.click(element.FB_USER()).sendKeys("samdoe306@gmail.com").perform();
			Thread.sleep(1000);
			action.sendKeys(Keys.TAB).sendKeys("TEST2109").perform();
			action.sendKeys(Keys.ENTER).perform();
			driver.switchTo().window(parentpage);
			String Error = element.FB_Error_Feature().getText();

			Helper.highLightElement(driver, element.FB_Error_Feature());

		} else {

			System.out.println("TEST FOR FREE button is not available:ERROR");
		}

		if (element.Test_for_free2().isDisplayed()) {
			// Scroll to your element
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			Thread.sleep(5000);
			js.executeScript("scroll(0,1600)");
			Thread.sleep(2000);
			element.Test_for_free2().click();
			Thread.sleep(1000);
			action.moveToElement(element.FB_BUTTON()).pause(2000).perform();
			action.click(element.FB_BUTTON()).perform();
			String Error = element.FB_Error_Feature().getText();

			Helper.highLightElement(driver, element.FB_Error_Feature());

		} else {

			System.out.println("TEST FOR FREE button is not available:ERROR");
		}

		if (element.Sign_up1().isDisplayed()) {
			// Scroll to your element
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			Thread.sleep(5000);
			js.executeScript("scroll(1600,0)");
			Thread.sleep(2000);
			element.Sign_up1().click();
			Thread.sleep(1000);
			action.moveToElement(element.FB_BUTTON()).pause(2000).perform();
			action.click(element.FB_BUTTON()).perform();
			// String Error = element.FB_Error_Feature().getText();

			Helper.highLightElement(driver, element.FB_Error_Feature());

		} else {

			System.out.println("Sign Up button is not available:ERROR");
		}

		if (element.Sign_up2().isDisplayed()) {
			// Scroll to your element
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			Thread.sleep(5000);
			js.executeScript("scroll(0,1600)");
			Thread.sleep(2000);
			element.Sign_up2().click();
			Thread.sleep(1000);
			action.moveToElement(element.FB_BUTTON()).pause(2000).perform();
			action.click(element.FB_BUTTON()).perform();
			// String Error = element.FB_Error_Feature().getText();

			Helper.highLightElement(driver, element.FB_Error_Feature());

		} else {

			System.out.println("Sign up button is not available:ERROR");
		}

	}

}
