package RankingCoach;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Resources.Base;
import pageObjects.LoginPage;

public class LoginTest extends Base {

	@BeforeMethod
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}

	@Test
	public void VerifyErrors1() throws InterruptedException, IOException {
		LoginPage er = new LoginPage(driver);

		er.login().click();
		er.submit().click();
		Thread.sleep(2000);
		Assert.assertTrue(er.error().isEnabled());
		Assert.assertTrue(er.seconderror().isEnabled());
		Thread.sleep(1000);
		Assert.assertEquals(getCellData(0, 1), er.error().getText());
		Assert.assertEquals(getCellData(0, 2), er.seconderror().getText());
		Thread.sleep(2000);

	}

	@Test
	public void VerifyErrors2() throws InterruptedException {
		LoginPage er = new LoginPage(driver);
		er.login().click();
		Thread.sleep(2000);
		er.username().sendKeys("test");
		er.password().sendKeys("123");
		Thread.sleep(1000);
		er.submit().click();
		Assert.assertTrue(er.error2().isEnabled());
		Assert.assertTrue(er.seconderror2().isEnabled());
		Thread.sleep(1000);
		// System.out.print("\"Hello\""); double quotes in double quotes
		Assert.assertEquals("Please enter a valid Email address. For example \"fred@domain.com\".",
				er.error2().getText());
		Assert.assertEquals("Please enter at least 4 characters (you have inserted only 3 character(s))",
				er.seconderror2().getText());

	}

	@Test
	public void VerifyErrors3() throws InterruptedException {

		LoginPage er = new LoginPage(driver);
		er.login().click();
		Thread.sleep(2000);
		er.username().sendKeys("test@yahoo.com");
		er.password().sendKeys("1234");
		er.submit().click();
		Thread.sleep(2000);
		Assert.assertTrue(er.error3().isEnabled());
		Assert.assertEquals("Please review your entry", er.error3().getText());

	}

	@Test
	public void PasswordActions() throws InterruptedException {
		LoginPage er = new LoginPage(driver);
		er.login().click();
		Thread.sleep(2000);
		er.username().sendKeys("test@yahoo.com");
		er.password().sendKeys("1234");
		er.submit().click();

		Thread.sleep(2000);
		Actions action = new Actions(driver);
		WebElement sub = er.submit();
		WebElement pass = er.password();

		Thread.sleep(2000);
		action.moveToElement(pass).click().sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE).build().perform();
		action.clickAndHold(sub).pause(3000).release().build().perform();

		Thread.sleep(2000);
		Assert.assertTrue(er.error3().isEnabled());
		Assert.assertFalse(er.seconderror2().isEnabled());

	}

	@Test
	public void PasswordActions2() throws InterruptedException {
		LoginPage er = new LoginPage(driver);
		er.login().click();
		er.username().sendKeys("test@gmail.com");
		er.password().sendKeys("1223");
		er.submit().click();

		Actions action = new Actions(driver);
		WebElement sub = er.submit();
		WebElement pass = er.password();

		Thread.sleep(2000);
		action.moveToElement(pass).click().sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE)
				.build().perform();
		action.clickAndHold(sub).pause(3000).release().build().perform();

		Thread.sleep(2000);
		Assert.assertTrue(er.error3().isEnabled());
		Assert.assertFalse(er.seconderror().isEnabled());

	}

	@Test
	public void CheckBox() throws InterruptedException {
		LoginPage er = new LoginPage(driver);
		er.login().click();
		er.username().sendKeys(prop.getProperty("email"));
		er.password().sendKeys(prop.getProperty("pass"));

		Assert.assertTrue(er.check().isEnabled());
		Thread.sleep(2000);
		er.checkbox().click();
		Thread.sleep(2000);
		Assert.assertTrue(er.uncheck().isEnabled());

	}

	@Test
	public void CheckBoxAfterLogout() throws InterruptedException {
		LoginPage er = new LoginPage(driver);
		er.login().click();
		Thread.sleep(2000);
		er.username().sendKeys(prop.getProperty("email"));
		er.password().sendKeys(prop.getProperty("pass"));
		er.checkbox().click();
		er.submit().click();

		Actions action = new Actions(driver);
		WebElement icon = er.icon();
		action.moveToElement(icon).pause(3000).build().perform();
		er.logout().click();
		// Thread.sleep(3000);
		er.login().click();
		Assert.assertTrue(er.check().isEnabled());

	}

	@Test
	public void ResetPassErrors() throws InterruptedException {
		LoginPage er = new LoginPage(driver);
		er.login().click();
		Thread.sleep(3000);
		Assert.assertTrue(er.newpass().isDisplayed());
		Thread.sleep(3000);
		er.newpass().click();
		Thread.sleep(2000);
		er.resetpass().click();
		Assert.assertTrue(er.error().isEnabled());
		Assert.assertEquals("This field is required", er.error().getText());

	}

	@Test 
	public void ResetPassErrors2() throws InterruptedException {
		LoginPage er = new LoginPage(driver);
		er.login().click();
		Thread.sleep(2000);

		Assert.assertTrue(er.newpass().isDisplayed());
		er.newpass().click();
		er.resetpass().click();
		Thread.sleep(2000);
		er.fpass().sendKeys("test");
		Thread.sleep(2000);
		Assert.assertTrue(er.error2().isEnabled());
		Assert.assertEquals("Please enter a valid Email address. For example \"fred@domain.com\".",
				er.error2().getText());

	}

	@Test
	public void ResetPassValidation() {
		LoginPage er = new LoginPage(driver);
		er.login().click();
		er.newpass().click();
		er.fpass().sendKeys(prop.getProperty("testemail"));
		er.resetpass().click();
		Assert.assertTrue(er.ResetEmailConfirm().isDisplayed());
		Assert.assertEquals("An Email has been sent to you", er.ResetEmailConfirm().getText());

	}

	@Test
	public void GoogleLogIn() throws InterruptedException {
		// Verify if the error message will be displayed if user try to create
		// account with an existing account

		LoginPage el = new LoginPage(driver);
		el.login().click();
		Thread.sleep(2000);
		el.SignUpGoogle().click();

		Set<String> ids = driver.getWindowHandles();
		Iterator<String> pg = ids.iterator();
		//String parentpage = pg.next();
		String childpage = pg.next();
		driver.switchTo().window(childpage);

		Thread.sleep(2000);
		el.GoogleEmail().sendKeys(prop.getProperty("email"));
		Thread.sleep(2000);
		el.Nextid().click();
		Thread.sleep(2000);
		el.GooglePass().sendKeys(prop.getProperty("googlepass"));
		Thread.sleep(2000);
		// el.Nextpass().click();
		// Thread.sleep(4000);

	}

	@Test
	public void LogInandLogOut() throws InterruptedException {
		// Verify if user will be able to logout after he login in the app
		LoginPage el = new LoginPage(driver);
		el.login().click();
		Thread.sleep(2000);
		el.username().sendKeys(prop.getProperty("email"));
		el.password().sendKeys(prop.getProperty("pass"));
		el.submit().click();

		Thread.sleep(2000);
		driver.navigate().back();
		driver.navigate().refresh();
		Thread.sleep(2000);
		el.logout().click();

		Thread.sleep(2000);

	}

	@AfterMethod
	public void cookies() {

		driver.manage().deleteAllCookies();
		driver.close();
		driver = null;

	}

}
