package RankingCoach;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Resources.Base;
import pageObjects.CreateAccountObj;

public class CreateAccount extends Base {

	@BeforeMethod
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}

	@Test
	public void CreateAccountErrors() throws InterruptedException {

		CreateAccountObj el = new CreateAccountObj(driver);
		el.createAccButon().click();
		el.register().click();
		Thread.sleep(2000);
		Assert.assertTrue(el.reqname().isDisplayed());
		Assert.assertEquals("This field is required", el.reqname().getText());

		Assert.assertTrue(el.reqlastname().isDisplayed());
		Assert.assertEquals("This field is required", el.reqlastname().getText());

		Assert.assertTrue(el.reqemail().isDisplayed());
		Assert.assertEquals("This field is required", el.reqemail().getText());

		Assert.assertTrue(el.reqpass().isDisplayed());
		Assert.assertEquals("This field is required", el.reqpass().getText());

	}

	@Test
	public void CreateAccountErrors2() throws InterruptedException {
		CreateAccountObj el = new CreateAccountObj(driver);
		el.createAccButon().click();
		Thread.sleep(2000);
		el.firstnamefield().sendKeys("t");
		el.lastnamefield().sendKeys("t");
		el.emailfield().sendKeys("te");
		el.passfield().sendKeys("tes");
		el.register().click();

		Thread.sleep(2000);
		Assert.assertTrue(el.incname().isDisplayed());
		Assert.assertEquals("Please enter at least 2 characters (you have inserted only 1 character(s))",
				el.incname().getText());

		Assert.assertTrue(el.inclastname().isDisplayed());
		Assert.assertEquals("Please enter at least 2 characters (you have inserted only 1 character(s))",
				el.inclastname().getText());

		Assert.assertTrue(el.incemail().isDisplayed());
		Assert.assertEquals("Please enter a valid Email address. For example \"fred@domain.com\".",
				el.incemail().getText());

		Assert.assertTrue(el.incpass().isDisplayed());
		Assert.assertEquals("Please enter at least 5 characters (you have inserted only 3 character(s))",
				el.incpass().getText());

	}

	@Test
	public void CreateAccountErrors3() throws InterruptedException {

		System.out.println("Verify what happens if user complete the fields with invalid characters");
		CreateAccountObj el = new CreateAccountObj(driver);
		el.createAccButon().click();
		Thread.sleep(2000);
		el.firstnamefield().sendKeys("$$$$");
		el.lastnamefield().sendKeys("$$$$");
		el.emailfield().sendKeys("$$$$");
		el.passfield().sendKeys("$$$$");
		el.register().click();

		Thread.sleep(2000);
		Assert.assertTrue(el.invname().isDisplayed());
		Assert.assertEquals("Please use only letters, numbers and the following characters: +,, _, (,) -:",
				el.invname().getText());

		Assert.assertTrue(el.invlastname().isDisplayed());
		Assert.assertEquals("Please use only letters, numbers and the following characters: +,, _, (,) -:",
				el.invlastname().getText());

		Assert.assertTrue(el.incemail().isDisplayed());
		Assert.assertEquals("Please enter a valid Email address. For example \"fred@domain.com\".",
				el.incemail().getText());

		Assert.assertTrue(el.incpass().isDisplayed());
		Assert.assertEquals("Please enter at least 5 characters (you have inserted only 4 character(s))",
				el.incpass().getText());
		Thread.sleep(3000);

	}

	@Test
	public void CreateAccountErrors4() throws InterruptedException {
		// Verify if error messages are displayed after user delete his
		// credentials from the fields

		CreateAccountObj el = new CreateAccountObj(driver);
		el.createAccButon().click();
		Thread.sleep(2000);
		el.firstnamefield().sendKeys("T");
		el.lastnamefield().sendKeys("T");
		el.emailfield().sendKeys("T");
		el.passfield().sendKeys("1");
		el.register().click();

		Actions ac = new Actions(driver);

		WebElement firstname = el.firstnamefield();
		ac.moveToElement(firstname).click().sendKeys(Keys.BACK_SPACE, Keys.TAB).build().perform();
		Thread.sleep(1000);
		Assert.assertTrue(el.reqname().isDisplayed());
		Assert.assertEquals("This field is required", el.reqname().getText());
		Thread.sleep(1000);

		WebElement lastname = el.lastnamefield();
		ac.moveToElement(lastname).click().sendKeys(Keys.BACK_SPACE, Keys.TAB).build().perform();
		Thread.sleep(1000);
		Assert.assertTrue(el.reqlastname().isDisplayed());
		Assert.assertEquals("This field is required", el.reqlastname().getText());
		Thread.sleep(1000);

		WebElement emailfield = el.emailfield();
		ac.moveToElement(emailfield).click().sendKeys(Keys.BACK_SPACE, Keys.TAB).build().perform();
		Thread.sleep(1000);
		Assert.assertTrue(el.reqemail().isDisplayed());
		Assert.assertEquals("This field is required", el.reqemail().getText());
		Thread.sleep(1000);

		WebElement passfield = el.passfield();
		ac.moveToElement(passfield).click().sendKeys(Keys.BACK_SPACE, Keys.TAB).build().perform();
		Thread.sleep(1000);
		Assert.assertTrue(el.reqpass().isDisplayed());
		Assert.assertEquals("This field is required", el.reqpass().getText());
		Thread.sleep(1000);

	}

	@Test
	public void CreateAccountErrors5() throws InterruptedException {
		// Verify if errors are displayed after user rewrote his create account
		// details
		CreateAccountObj el = new CreateAccountObj(driver);
		el.createAccButon().click();
		Thread.sleep(2000);
		el.firstnamefield().sendKeys("Test");
		el.lastnamefield().sendKeys("Test");
		el.emailfield().sendKeys("Test");
		el.passfield().sendKeys("T");
		el.register().click();
		Thread.sleep(3000);

		Actions ac = new Actions(driver);
		WebElement firstname = el.firstnamefield();
		ac.moveToElement(firstname).doubleClick().sendKeys("D", Keys.TAB).build().perform();
		Thread.sleep(1000);
		Assert.assertTrue(el.incname().isDisplayed());
		Assert.assertEquals("Please enter at least 2 characters (you have inserted only 1 character(s))",
				el.incname().getText());
		Thread.sleep(1000);

		WebElement lastname = el.lastnamefield();
		ac.moveToElement(lastname).doubleClick().sendKeys("D", Keys.TAB).build().perform();
		Thread.sleep(1000);
		Assert.assertTrue(el.inclastname().isDisplayed());
		Assert.assertEquals("Please enter at least 2 characters (you have inserted only 1 character(s))",
				el.inclastname().getText());
		Thread.sleep(1000);

		WebElement emailfield = el.emailfield();
		ac.moveToElement(emailfield).doubleClick().sendKeys("D", Keys.TAB).build().perform();
		Thread.sleep(1000);
		Assert.assertTrue(el.incemail().isDisplayed());
		Assert.assertEquals("Please enter a valid Email address. For example \"fred@domain.com\".",
				el.incemail().getText());
		Thread.sleep(1000);

		WebElement passfield = el.passfield();
		ac.moveToElement(passfield).doubleClick().sendKeys("D", Keys.TAB).build().perform();
		Thread.sleep(1000);
		Assert.assertTrue(el.incpass().isDisplayed());
		Assert.assertEquals("Please enter at least 5 characters (you have inserted only 1 character(s))",
				el.incpass().getText());
		Thread.sleep(1000);

	}

	@Test
	public void TermnsAndConditions() throws InterruptedException

	{
		// Verify if user is redirected to the correct ToC page
		CreateAccountObj el = new CreateAccountObj(driver);
		el.createAccButon().click();
		Thread.sleep(2000);
		el.ToC().click();
		Thread.sleep(2000);

		Set<String> ids = driver.getWindowHandles();
		Iterator<String> pg = ids.iterator();
		String parentpage = pg.next();
		String childpage = pg.next();
		driver.switchTo().window(childpage);
		Assert.assertEquals("All of rankingCoach’s terms and conditions", driver.getTitle());
		Assert.assertEquals("https://www.rankingcoach.com/en-us/terms-and-conditions", driver.getCurrentUrl());
		Thread.sleep(2000);
		// Scroll down to view all page
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//a[@href='/en-us/contact']"));
		je.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);

		driver.switchTo().window(parentpage);

	}

	@Test
	public void PrivacyPolicy() throws InterruptedException

	{
		// Verify if user is redirected to the correct ToC page
		CreateAccountObj el = new CreateAccountObj(driver);
		el.createAccButon().click();
		Thread.sleep(2000);
		el.PP().click();
		Thread.sleep(2000);

		Set<String> ids = driver.getWindowHandles();
		Iterator<String> pg = ids.iterator();
		String parentpage = pg.next();
		String childpage = pg.next();
		driver.switchTo().window(childpage);
		Assert.assertEquals("rankingCoach’s privacy protection policy", driver.getTitle());
		Assert.assertEquals("https://www.rankingcoach.com/en-us/privacy-policy", driver.getCurrentUrl());
		Thread.sleep(2000);

		// Scroll down
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//a[@href='/en-us/contact']"));
		je.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		driver.switchTo().window(parentpage);

	}

	@Test
	public void GoogleLogIn() throws InterruptedException {
		// Verify if the error message will be displayed if user try to create
		// account with an existing account

		CreateAccountObj el = new CreateAccountObj(driver);
		el.createAccButon().click();
		Thread.sleep(1000);
		el.SignUpGoogle().click();

		Set<String> ids = driver.getWindowHandles();
		Iterator<String> pg = ids.iterator();
		String parentpage = pg.next();
		String childpage = pg.next();
		driver.switchTo().window(childpage);
		Thread.sleep(2000);
		// System.out.println(driver.getTitle());
		el.GoogleEmail().sendKeys(prop.getProperty("email"));
		Thread.sleep(3000);
		el.Nextid().click();
		Thread.sleep(2000);
		el.GooglePass().sendKeys(prop.getProperty("googlepass"));
		Thread.sleep(4000);
		// el.Nextpass().click();
		// Thread.sleep(4000);

		driver.switchTo().window(parentpage);

	}

	@AfterMethod
	public void cookies() {

		// driver.manage().deleteAllCookies();
		driver.close();
		driver = null;
	}

}
