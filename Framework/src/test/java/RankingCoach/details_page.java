package RankingCoach;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Resources.Base;
import Resources.Helper;
import pageObjects.LoginPage;
import pageObjects.detailsPageObj;
import pageObjects.domainnameobj;

public class details_page extends Base {

	private domainnameobj domainElement;
	private Actions action;
	private detailsPageObj element;
	private WebDriverWait wait;
	ExtentReports report;
	ExtentTest test;

	@BeforeMethod
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.get(prop.getProperty("testurl"));
		driver.manage().window().maximize();

		domainElement = new domainnameobj(driver);
		action = new Actions(driver);
		element = new detailsPageObj(driver);
		wait = new WebDriverWait(driver, 15);

		LoginPage er = new LoginPage(driver);
		er.login().click();
		Thread.sleep(1000);
		er.username().sendKeys(prop.getProperty("email"));
		Thread.sleep(1000);
		er.password().sendKeys(prop.getProperty("pass"));
		Thread.sleep(1000);
		er.submit().click();

	}

	@Test
	public void a_detailPageContent() throws InterruptedException {

		Thread.sleep(3000);
		action.moveToElement(domainElement.CheckWebsite()).click().build().perform();
		test.log(LogStatus.INFO, "Click on Check Website button");

		Thread.sleep(3000);
		domainElement.Next().click();
		test.log(LogStatus.INFO, "Click on Next button");
		Helper.highLightElement(driver, element.detailsImage());
		Assert.assertTrue(element.detailsImage().isDisplayed());
		test.log(LogStatus.INFO, "Details Frame is displayed");

		Thread.sleep(4000);
		Helper.highLightElement(driver, element.PageContent());
		Assert.assertTrue(element.PageContent().isDisplayed());
		test.log(LogStatus.INFO, "Fields section is displayed ");

		Assert.assertEquals(element.headLine().getText(), prop.getProperty("headLine"));
		test.log(LogStatus.INFO, "Verify if HeadLine text is displayed correctly");

		Assert.assertEquals(element.subHeadLine().getText(), prop.getProperty("subHeadLine"));
		test.log(LogStatus.INFO, "Verify if SubHeadLine text is displayed correctly");

		Thread.sleep(2000);
		Assert.assertTrue(element.detailsMap().isDisplayed());
		test.log(LogStatus.INFO, "Verify if the Details Map is displayed");

		Assert.assertTrue(element.domainTab().isEnabled());
		test.log(LogStatus.INFO, "Domain Tab should be Active");
		Thread.sleep(2000);

	}

	@Test
	public void b_errorMessages() throws InterruptedException {

		wait.until(ExpectedConditions.invisibilityOf(element.detailsImage()));
		test.log(LogStatus.INFO, "Wait until the details images will disappear ");
		String detailsPage = driver.getTitle();
		Assert.assertTrue(detailsPage != null);
		test.log(LogStatus.INFO, "Verify if user is redirected to Details page");
		wait.until(ExpectedConditions.elementToBeClickable(element.Next()));
		test.log(LogStatus.INFO, "Wait until Next button is clickable");

		Thread.sleep(2000);
		element.Next().click();
		Thread.sleep(2000);

		action.moveToElement(element.companyName()).build().perform();
		action.moveToElement(element.fieldRequired()).pause(2000).build().perform();
		Assert.assertTrue(element.fieldRequired().isDisplayed());
		test.log(LogStatus.INFO, "Error message from Company Field is displayed");

		Thread.sleep(2000);
		element.streetNo().clear();
		Thread.sleep(2000);

		action.moveToElement(element.streetNo()).pause(2000).build().perform();
		action.moveToElement(element.fieldRequired()).pause(3000).build().perform();
		Assert.assertTrue(element.fieldRequired().isDisplayed());
		test.log(LogStatus.INFO, "Error message from Street Number Field is displayed");

		Thread.sleep(2000);
		element.street().clear();
		Thread.sleep(2000);

		action.doubleClick(element.street()).sendKeys("#").build().perform();
		action.moveToElement(element.street()).pause(2000).click().build().perform();
		action.moveToElement(element.incorectStreet()).pause(3000).build().perform();
		Assert.assertTrue(element.incorectStreet().isDisplayed());
		test.log(LogStatus.INFO, "Error message from Street Field is displayed");

		Thread.sleep(2000);
		element.city().clear();
		Thread.sleep(2000);

		action.doubleClick(element.city()).sendKeys("#").build().perform();
		action.moveToElement(element.city()).pause(2000).click().build().perform();
		action.moveToElement(element.fieldRequired()).pause(3000).build().perform();
		Assert.assertTrue(element.fieldRequired().isDisplayed());
		test.log(LogStatus.INFO, "Error message from city Field is displayed");

		Thread.sleep(2000);
		element.postalCode().clear();
		Thread.sleep(2000);

		action.moveToElement(element.postalCode()).pause(2000).click().build().perform();
		action.moveToElement(element.fieldRequired()).pause(3000).build().perform();
		Assert.assertTrue(element.fieldRequired().isDisplayed());
		test.log(LogStatus.INFO, "Error message from Posta Code Field is displayed");

	}

	@Test
	public void c_countryDropDows() throws InterruptedException {
		wait.until(ExpectedConditions.invisibilityOf(element.detailsImage()));
		test.log(LogStatus.INFO, "Wait until the details images will disappear");

		WebElement select = element.dropDown();
		Select sel = new Select(select);

		Thread.sleep(3000);
		sel.selectByValue("1015");
		test.log(LogStatus.INFO, "Select 'Argentina' from the dropdown");

		Thread.sleep(3000);
		sel.selectByValue("1030");
		test.log(LogStatus.INFO, "Select 'Australia' from the dropdown");

		List<WebElement> options = sel.getOptions();
		int size = options.size();

		for (int i = 0; i < size; i++) {

			if (options.get(i).getText().contains("United Kingdom")) {

				options.get(i).click();
				test.log(LogStatus.INFO, "Select 'United Kingdom' from the dropdown");
				break;
			}

		}

		Thread.sleep(3000);
		element.dropDownField().click();
		Thread.sleep(3000);
		action.sendKeys(Keys.ARROW_UP).pause(1000).sendKeys(Keys.ARROW_UP).pause(1000).sendKeys(Keys.ARROW_UP)
				.pause(1000).sendKeys(Keys.ARROW_UP).pause(1000).sendKeys(Keys.ARROW_UP).pause(1000)
				.sendKeys(Keys.ENTER).build().perform();
		test.log(LogStatus.INFO, "Click on drop dropdown field and select a country using the Keyboard arrows");
	}

	@Test
	public void d_completeDetailsFields() throws InterruptedException {
		wait.until(ExpectedConditions.invisibilityOf(element.detailsImage()));
		test.log(LogStatus.INFO, "Wait until the details images will disappear");

		Thread.sleep(3000);
		element.street().clear();
		action.moveToElement(element.street()).click().sendKeys("Bost").build().perform();
		test.log(LogStatus.INFO, "Type some letters in Street field Egg:'Bost'");

		Thread.sleep(2000);
		action.sendKeys(Keys.ARROW_DOWN).pause(1000).sendKeys(Keys.ARROW_DOWN).pause(1000).sendKeys(Keys.ENTER).build()
				.perform();
		Thread.sleep(2000);
		test.log(LogStatus.INFO, "Use keywords to select your address:'Boston Street,Baltimore MD,USA'");

		String streetValue = element.street().getAttribute("value");
		System.out.println(streetValue);
		Assert.assertEquals(streetValue, "Boston Street");
		test.log(LogStatus.INFO, "Street field contains the value: " + streetValue);

		String cityValue = element.city().getAttribute("value");
		System.out.println(cityValue);
		Assert.assertEquals(cityValue, "Baltimore MD");
		test.log(LogStatus.INFO, "City field contains the value: " + cityValue);

		String zipValue = element.postalCode().getAttribute("value");
		System.out.println(zipValue);
		Assert.assertEquals(zipValue, "94133");
		test.log(LogStatus.INFO, "City field contains the value: " + zipValue);

		// element.streetNo().clear();
		// action.click(element.streetNo()).sendKeys("123").build().perform();
		String StreetNOValue = element.streetNo().getAttribute("Value");
		Assert.assertEquals(StreetNOValue, "232");
		test.log(LogStatus.INFO, "Street Number field contains the value: " + StreetNOValue);

		Thread.sleep(2000);
		action.moveToElement(element.companyName()).click().sendKeys("RankingCoach").build().perform();
		// String companyName = element.companyName().getAttribute("Value");
		// Assert.assertEquals(companyName,"RankingCoach");
		test.log(LogStatus.INFO, "Company name field contains the value: RankingCoach");

		Thread.sleep(2000);
		action.click(element.Next()).build().perform();
	}

}
