package RankingCoach;

//import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.junit.Assert;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Resources.Base;
import pageObjects.LoginPage;
import pageObjects.domainnameobj;

public class domain_name extends Base {

	private WebDriver driver;
	//private static final String priority = null;
	public static domainnameobj el;
	public static Actions action;
	ExtentReports report;
	ExtentTest test;
	ExtentReports extent;
	
	public domain_name(WebDriver driver) {
		this.driver = driver;
	}

	@BeforeMethod
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.get(prop.getProperty("testurl"));
		driver.manage().window().maximize();
		el = new domainnameobj(driver);
		action = new Actions(driver);
 
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
	public void domainFieldErrors() throws InterruptedException, IOException {
		el.DomainField().clear();
		test.log(LogStatus.INFO, "Clear the field");
		Thread.sleep(2000);
		el.CheckWebsite().click();
		test.log(LogStatus.INFO, "Click on CheckWesite Button");
		Thread.sleep(2000);
		Assert.assertEquals(prop.getProperty("Emptyfield"), el.EmptyField().getText());
		test.log(LogStatus.INFO, "Verify if the error message is displayed: 'This field is required' ");

		// driver.navigate().refresh();

		action.moveToElement(el.DomainField()).click().sendKeys("test").perform();
		Thread.sleep(2000);
		el.CheckWebsite().click();
		Thread.sleep(2000);
		Assert.assertEquals(prop.getProperty("InvalidDomain"), el.InvalidDomain().getText());
		test.log(LogStatus.INFO, "Verify if the error message is displayed:" + prop.getProperty("InvalidDomain"));

		Thread.sleep(2000);
		action.moveToElement(el.DomainField()).click().sendKeys(Keys.BACK_SPACE, Keys.ENTER).build().perform();

	}

	@Test
	public void validExecutions() throws InterruptedException {

		//Thread.sleep(1000);
		//el.DomainField().clear();
		el.DomainField().sendKeys(prop.getProperty("url"));
		//test.log(LogStatus.INFO, "Type a valid Url in Domain field ");
		Thread.sleep(2000);
		el.CheckWebsite().click();
		//test.log(LogStatus.INFO, "Click on CheckWesite Button");
		WebDriverWait time = new WebDriverWait(driver, 10);
		time.until(ExpectedConditions.visibilityOf(el.thumbcontent()));
		//test.log(LogStatus.INFO, "Wait until the thumb is displayed");
		Assert.assertTrue(el.thumbcontent().isDisplayed());
		//test.log(LogStatus.INFO, "Verify if the Thumb display your website image");
		Assert.assertTrue(el.Next().isDisplayed());
		//test.log(LogStatus.INFO, "Verify if CheckWebsite button is replaced by Next button");
        
	}

	@Test(dependsOnMethods = { "validExecutions" })
	public void removeDomain() throws InterruptedException {

		Thread.sleep(2000);
		action.moveToElement(el.SettingsButton()).click().build().perform();
		test.log(LogStatus.INFO, "Click on Manage sites Icon");
		Thread.sleep(2000);
		Assert.assertTrue(el.addedSite().isDisplayed());
		test.log(LogStatus.INFO, "Verify if added site is displayed in Manage Projects");
		Thread.sleep(2000);
		action.moveToElement(el.addedSite()).click(el.deleteSite()).build().perform();
		test.log(LogStatus.INFO, "Click on Delete Icon and verify if the confirmatio window is displayed");
		Thread.sleep(2000);
		action.moveToElement(el.deletesiteNo()).click().build().perform();
		test.log(LogStatus.INFO, "From displayed window Click on NO button");
		Assert.assertTrue(el.addedSite().isDisplayed());
		test.log(LogStatus.INFO, "Added site should be displayed");
		Thread.sleep(2000);
		// Delete the your Added WebSite
		action.moveToElement(el.addedSite()).click(el.deleteSite()).build().perform();
		test.log(LogStatus.INFO, "Click again on Remove Icon,Confirmation window should open again");
		Thread.sleep(2000);
		action.moveToElement(el.deletesiteYes()).click().build().perform();
		test.log(LogStatus.INFO, "From displayed window Click on YES button");
		Thread.sleep(4000);
		Assert.assertTrue(el.AddNewSite().isDisplayed());
		test.log(LogStatus.INFO, "Site is not displayed anymore");
		Thread.sleep(3000);

	}

	@Test(dependsOnMethods = { "removeDomain" })
	public void addSiteFromManageProjects() throws InterruptedException {

		action.moveToElement(el.SettingsButton()).click().build().perform();
		test.log(LogStatus.INFO, "Click on Manage projects icon");
		Thread.sleep(2000);
		Assert.assertTrue(el.AddNewSite().isDisplayed());
		test.log(LogStatus.INFO, "Verify if add new site case si displayed");
		action.moveToElement(el.AddNewSite()).click().build().perform();
		test.log(LogStatus.INFO, "Click on add new site case ");
		Thread.sleep(3000);
		Assert.assertTrue(el.addWindow().isDisplayed());
		test.log(LogStatus.INFO, "Verify if the add new site confirmation window is displayed");
		Assert.assertEquals(prop.getProperty("AddSiteContent"), el.addWindowContent().getText());
		test.log(LogStatus.INFO, "Verify if window first text");
		Assert.assertEquals(prop.getProperty("AddSiteContent2"), el.addWindowContent2().getText());
		test.log(LogStatus.INFO, "Verify if window second text");
		action.moveToElement(el.addSitebuttonYes()).click().perform();
		WebDriverWait time = new WebDriverWait(driver, 10);
		time.until(ExpectedConditions.visibilityOf(el.DomainField()));
		test.log(LogStatus.INFO, "Press Yes button and wait until the Add field is displayed");
		if (el.cancelButton().isDisplayed()) {
			test.log(LogStatus.INFO, "Cancel button is displayed in Onboarding View");
			action.moveToElement(el.DomainField()).click().sendKeys(prop.getProperty("url")).sendKeys(Keys.ENTER)
					.build().perform();
			test.log(LogStatus.INFO, "Enter a valid URL in the domain field and hit Enter");
			WebElement sitevisibility = time.until(ExpectedConditions.visibilityOf(el.thumbcontent()));
			test.log(LogStatus.INFO, "Wait until the Thumb that contains your site Image si displayed");
			if (sitevisibility.isDisplayed()) {
				test.log(LogStatus.INFO, "The Site Image is displayed in the thumb");

				if (el.cancelButton().isDisplayed()) {
					test.log(LogStatus.FATAL, "Cancel Button is displayed.");
				} else {
					test.log(LogStatus.INFO, "Cancell Button is not displayed");
				}
			} else {
				test.log(LogStatus.FATAL, "Thumb did not displayed the correct image or is not displayed at all.");
			}

		} else {
			test.log(LogStatus.FATAL, "Cancel Button is not displayed.");
		}

	}

	@Test(dependsOnMethods = { "addSiteFromManageProjects" })
	public void addAnotherSiteFromDomainName() throws InterruptedException {

		//Select select = new Select(el.selectSites());
		test.log(LogStatus.INFO, "DropDown contains the last added website");
		if (el.selectSites().isDisplayed()) {
			action.moveToElement(el.selectSites()).click().perform();
			test.log(LogStatus.INFO, "Select sites DropDown is visible");
			Thread.sleep(3000);
			Assert.assertEquals(prop.getProperty("DPSite"), el.dropDownFirstSite().getText());
			test.log(LogStatus.INFO, "The site available in drop down is: " + el.dropDownFirstSite().getText());
		} else {
			test.log(LogStatus.FATAL, "The dropdown is not visible or don't contain any website");
		}

		Thread.sleep(2000);
		el.DomainField().clear();
		test.log(LogStatus.INFO, "Clear Domain Field content");
		action.click(el.DomainField()).sendKeys(prop.getProperty("testurl2")).sendKeys(Keys.ENTER).perform();
		test.log(LogStatus.INFO, "Type the new content and hit enter");
		WebDriverWait time = new WebDriverWait(driver, 10);
		WebElement sitevisibility = time.until(ExpectedConditions.visibilityOf(el.domainthumb()));
		test.log(LogStatus.INFO, "Wait until the Thumb is visible");
		if (sitevisibility.isDisplayed()) {

			driver.navigate().refresh();
			test.log(LogStatus.INFO, "Refresh the page");

			if (el.selectSites().isDisplayed()) {
				test.log(LogStatus.INFO, "Verify if the new site is added and the old site is removed");
				action.moveToElement(el.selectSites()).click().perform();
				test.log(LogStatus.INFO, "Select site DropDown is visible");
				Assert.assertEquals(prop.getProperty("DPSite2"), el.dropDownSecondSite().getText());
				test.log(LogStatus.INFO, "The new Website is available in the dropdown select");
			} else {
				test.log(LogStatus.FATAL, "DropDown is not displayed");
			}

		} else {
			test.log(LogStatus.FATAL, "Thumb element is not displayed");
		}
	}

	@Test(dependsOnMethods = { "addAnotherSiteFromDomainName" })
	public void addMultipleDomainsFromManageSites() throws InterruptedException

	{
		WebDriverWait time = new WebDriverWait(driver, 10);
		String ManageSitesTitle = null;
		String DomainNameTitle = null;
		// Interact and Click on settings icon
		action.moveToElement(el.SettingsButton()).click().perform();
		ManageSitesTitle = driver.getTitle();
		// Add new site
		if (el.AddNewSite().isDisplayed()) {
			action.click(el.AddNewSite()).perform();
			// Verify if the correct texts are displayed
			Assert.assertEquals(prop.getProperty("AddSecondSiteContent"), "Total costs presently : $29.95 per month");
			Assert.assertEquals(prop.getProperty("AddSecondSiteContent2"),
					"The costs will increase to $54.90 per month.");
			Thread.sleep(2000);
			// Click on Windows Yes button
			el.addSiteYes().click();
			DomainNameTitle = driver.getTitle();
			// Verify if the user is redirected to the right page
			if (ManageSitesTitle != DomainNameTitle) {
				System.out.println("User is redirected to the correct page");
				// Cancell Button should be displayed
				Assert.assertTrue(el.cancelButton().isDisplayed());
				// Add the new site
				action.click(el.DomainField()).sendKeys(prop.getProperty("testurl3"), Keys.ENTER).build().perform();
				;
				WebElement SiteVisibility = time.until(ExpectedConditions.visibilityOf(el.domainthumb()));
				// Verify if all the sites are available in Manage Sites
				if (SiteVisibility.isDisplayed()) {
					// Cancel button is not displayed anymore
					Assert.assertFalse(el.cancelButton().isDisplayed());
					// Click on settings
					action.click(el.SettingsButton()).perform();
					Thread.sleep(2000);
					// First and second site should be displayed
					Assert.assertTrue(el.addedSecondSite().isDisplayed());
					Assert.assertTrue(el.addedThirdSite().isDisplayed());
				} else {
					System.out.println("Thumb is not visible :ERROR");
				}
			} else {
				System.out.println("User is not redirected to the right page:Error");
			}
		} else {
			System.out.println("Add Button is not displayed:Error");
		}

	}

}
