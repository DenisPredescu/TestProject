package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccountObj {

	WebDriver driver;

	public CreateAccountObj(WebDriver driver) {

		this.driver = driver;

	}

	// Fields
	By createAccButon = By.id("sign_up_button");
	By firstnamefield = By.id("firstname");
	By lastnamefield = By.id("lastname");
	By emailfield = By.id("email");
	By passfield = By.name("password");
	By register = By.xpath("//a[@id='btn_anmelden_step_1']");
	// Errors
	// Required errors
	By reqname = By.xpath("//span[@id='advice-required-firstname']");
	By reqlastname = By.xpath("//span[@id='advice-required-lastname']");
	By reqemail = By.xpath("//span[@id='advice-required-email']");
	By reqpass = By.xpath("//span[@id='advice-required-input_password']");
	// Incorrect errors
	By incname = By.xpath("//span[@id='advice-minLength-firstname']");
	By inclastname = By.xpath("//span[@id='advice-minLength-lastname']");
	By incemail = By.xpath("//span[@id='advice-validate-email-email']");
	By incpass = By.xpath("//span[@id='advice-minLength-input_password']");
	// Invalid Errors
	By invname = By.xpath("//span[@id='advice-validate-Text-firstname']");
	By invlastname = By.xpath("//span[@id='advice-validate-Text-lastname']");
	// TermnsandConditions and Privacy Policy
	By ToC = By.linkText("Terms and conditions");
	By PP = By.linkText("Privacy Policy");
	// Google Log In Elements
	By SignUpGoogle = By.xpath("//a[@id='login-with-google']");
	By GoogleEmail = By.name("identifier");
	By GooglePass = By.xpath("//*[@id='password']/div[1]/div/div[1]/input");
	By Nextid = By.id("identifierNext");
	By Nextpass = By.xpath("//*[@id='passwordNext']/content/span");
	By AccountExists = By.xpath("//div[@class='overlay_window transparent notification fixed top open']");

	public WebElement createAccButon() {
		return driver.findElement(createAccButon);
	}

	public WebElement register() {
		return driver.findElement(register);
	}

	public WebElement reqname() {
		return driver.findElement(reqname);
	}

	public WebElement reqlastname() {
		return driver.findElement(reqlastname);
	}

	public WebElement reqemail() {
		return driver.findElement(reqemail);
	}

	public WebElement reqpass() {
		return driver.findElement(reqpass);
	}

	public WebElement inclastname() {
		return driver.findElement(inclastname);
	}

	public WebElement incemail() {
		return driver.findElement(incemail);
	}

	public WebElement incpass() {
		return driver.findElement(incpass);
	}

	public WebElement incname() {
		return driver.findElement(incname);
	}

	public WebElement firstnamefield() {
		return driver.findElement(firstnamefield);
	}

	public WebElement lastnamefield() {
		return driver.findElement(lastnamefield);
	}

	public WebElement emailfield() {
		return driver.findElement(emailfield);
	}

	public WebElement passfield() {
		return driver.findElement(passfield);
	}

	public WebElement invname() {
		return driver.findElement(invname);
	}

	public WebElement invlastname() {
		return driver.findElement(invlastname);
	}

	public WebElement ToC() {
		return driver.findElement(ToC);
	}

	public WebElement PP() {
		return driver.findElement(PP);
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

	public WebElement AccountExists() {
		return driver.findElement(AccountExists);
	}
}
