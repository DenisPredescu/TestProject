package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;

	}

	By login = By.xpath("//div[@id='menuTopWrapper']//ul[@class='menuTop menuTopRight pull-right']/li[3]/a");
	By Logout = By.xpath("//*[@id='menuTopWrapper']/div[2]/ul/li[3]/a");
	By username = By.xpath("//input[@id='username']");
	By password = By.xpath("//input[@id='password']");
	By fpass = By.xpath("//input[@id='username_frm_password']");
	By ResetEmailConfirm = By.xpath("//b[contains(text(),'An Email has been sent to you')]");
	By submit = By.xpath("//span[@class='text-uppercase']");
	By error = By.xpath("//span[@id='advice-required-username']");
	By seconderror = By.xpath("//span[@id='advice-required-password']");
	By error2 = By.xpath("//span[@id='advice-validate-email-username']");
	By seconderror2 = By.xpath("//span[@id='advice-minLength-password']");
	By error3 = By.xpath("//span[@id='advice--password']");
	By uncheck = By.xpath("//span[@class='ui_checkbox marginBottom marginTop']");
	By check = By.xpath("//span[@class='ui_checkbox marginBottom marginTop checked']");
	By checkbox = By.xpath("//span[@class='ui_check_outer']");
	By icon = By.xpath("//div[@id='user_photo_nav']");
	By logout = By.xpath("//i[@class='icon-logout']");
	By newpass = By.xpath("//a[@id='new-password-link']");
	By resetpass = By.xpath("//a[@href='#'][contains(text(),'Reset Password')]");
	// Google Log In Elements
	By SignUpGoogle = By.xpath("//a[@id='login-with-google']");
	By GoogleEmail = By.name("identifier");
	By GooglePass = By.xpath("//*[@id='password']/div[1]/div/div[1]/input");
	By Nextid = By.id("identifierNext");
	By Nextpass = By.xpath("//*[@id='passwordNext']/content/span");
	// logout button

	public WebElement username() {

		return driver.findElement(username);
	}

	public WebElement password() {

		return driver.findElement(password);

	}

	public WebElement submit() {

		return driver.findElement(submit);

	}

	public WebElement login() {

		return driver.findElement(login);
	}

	public WebElement error() {

		return driver.findElement(error);
	}

	public WebElement seconderror() {

		return driver.findElement(seconderror);
	}

	public WebElement error2() {

		return driver.findElement(error2);
	}

	public WebElement seconderror2() {

		return driver.findElement(seconderror2);
	}

	public WebElement error3() {

		return driver.findElement(error3);
	}

	public WebElement checkbox() {

		return driver.findElement(checkbox);
	}

	public WebElement check() {

		return driver.findElement(check);
	}

	public WebElement uncheck() {
		return driver.findElement(uncheck);
	}

	public WebElement icon() {
		return driver.findElement(icon);
	}

	public WebElement logout() {
		return driver.findElement(logout);
	}

	public WebElement newpass() {
		return driver.findElement(newpass);
	}

	public WebElement resetpass() {
		return driver.findElement(resetpass);
	}

	public WebElement fpass() {
		return driver.findElement(fpass);
	}

	public WebElement ResetEmailConfirm() {
		return driver.findElement(ResetEmailConfirm);
	}

	public WebElement SignUpGoogle() {
		return driver.findElement(SignUpGoogle);
	}

	public WebElement GoogleEmail() {
		return driver.findElement(GoogleEmail);
	}

	public WebElement GooglePass() {
		return driver.findElement(GooglePass);
	}

	public WebElement Nextid() {
		return driver.findElement(Nextid);
	}

	public WebElement Nextpass() {
		return driver.findElement(Nextpass);
	}

}
