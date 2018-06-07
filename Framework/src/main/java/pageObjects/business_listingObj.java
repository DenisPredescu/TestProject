package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class business_listingObj {

	WebDriver driver;

	public business_listingObj(WebDriver driver) {

		this.driver = driver;

	}

	// GreenBat
	By GreenBar = By.cssSelector("#abl_progress .green");
	// Content
	By Header = By.cssSelector("#business_listing_header");
	By number = By.cssSelector("b");
	By subHeader = By.cssSelector("#business_listing_subheader");
	// Email
	By name = By.cssSelector("[name=\"identifier\"]");
	By pass = By.xpath("/html//div[@id='password']//input[@name='password']");
	By icon = By.xpath("//a[@class='WaidBe']");
	By email = By.xpath("//span[@class='bog'][6]");
	By confirmationButton = By.linkText("Klicke hier, um fortzufahren");
	By city = By.cssSelector("#street");
	By confirm = By.xpath("//a[@id='address-save']");
	By card = By.cssSelector("[onselect=\"showPayment\\(\\'cc\\'\\)\"]");
	By cardfield = By.cssSelector("[data-stripe='number']");
	By month = By.cssSelector("[data-stripe='exp_month']");
	By year = By.cssSelector("[data-stripe='exp_year']");
	By cvc = By.cssSelector("[data-stripe='cvc']");
	By confrmcard = By.linkText("ANMELDEN");
	// Confirm
	By confirmText = By.cssSelector("#change_email_text");
	By startTest = By.cssSelector(".new-user-link");
	// FaceBook
	By FB_BUTTON = By.xpath("//a[@id='login-with-facebook']");
	By FB_USER = By.cssSelector("#email");
	By FB_SUBMIT = By.xpath("//button[@type='submit']");
	By FB_ErrorAE =  By.cssSelector(".public.invert-style > div:nth-child(1)");
	By FB_Error_Feature= By.cssSelector(".middle-align");
	// PageContent
	By features = By.cssSelector("#menuTopWrapper .univers_47.press");
	By Test_for_free1 = By .cssSelector(".standard .btn-white");
	By Test_for_free2 = By .xpath("/html//div[@id='parallaxWrapper']//ul[@class='features']/li[@class='standard']/ul[@class='features_accordion']//a[@title='Gratis testen']");
    By Sign_up1 = By.cssSelector(".agency .btn-white");
	By Sign_up2 = By.cssSelector(".btn-primary");
	//PersonalData
	By dataicon = By.cssSelector("#user_photo_nav [src]");
	By personaldata = By.cssSelector(".icon-triangle-up li:nth-of-type(1) .main-menu-nav-link");
	By subscription = By.xpath("//a[@id='subscriptions_tab']");
    By subsContent = By.cssSelector("#tab_content .card-section:nth-of-type(4) tr:nth-of-type(2) td:nth-of-type(1)");
	By subsPrice = By.cssSelector("#tab_content .card-section:nth-of-type(4) tr:nth-of-type(2) td:nth-of-type(2)");
	By subsStatus = By.cssSelector("#tab_content .card-section:nth-of-type(4) tr:nth-of-type(2) td:nth-of-type(3)");
	By subsAction = By .cssSelector("#tab_content tr:nth-of-type(2) td:nth-of-type(5)");
	By subsCancelPopUp = By.cssSelector(".rankingcoach > div:nth-of-type(1)");
	By PopUpContent = By.xpath("//form[@id='form_cancellation_infos']//h3[@class='text-danger']");
	By CancelButton = By.cssSelector(".btn-primary.margin-left");
	//Google
	By GoogleAllow =By.xpath("//span[text()='ALLOW']");	
	By GoogleError = By.cssSelector(".public > div:nth-of-type(1)");
	By LoginGoogle =By.cssSelector("#login-with-google");
	
	
	
	
	public WebElement LoginGoogle() {

		return driver.findElement(LoginGoogle);
	}
	public WebElement GoogleError() {

		return driver.findElement(GoogleError);
	}
	public WebElement GoogleAllow() {

		return driver.findElement(GoogleAllow);
	}
	public WebElement CancelButton() {

		return driver.findElement(CancelButton);
	}
	public WebElement PopUpContent() {

		return driver.findElement(PopUpContent);
	}
	public WebElement subsCancelPopUp() {

		return driver.findElement(subsCancelPopUp);
	}
	public WebElement subsAction() {

		return driver.findElement(subsAction);
	}
	public WebElement subsStatus() {

		return driver.findElement(subsStatus);
	}
	public WebElement subsPrice() {

		return driver.findElement(subsPrice);
	}
	public WebElement subsContent() {

		return driver.findElement(subsContent);
	}
	public WebElement subscription() {

		return driver.findElement(subscription);
	}
	public WebElement personaldata() {

		return driver.findElement(personaldata);
	}
	public WebElement dataicon() {

		return driver.findElement(dataicon);
	}
	public WebElement Sign_up2() {

		return driver.findElement(Sign_up2);
	}
	public WebElement Sign_up1() {

		return driver.findElement(Sign_up1);
	}
	public WebElement FB_Error_Feature() {

		return driver.findElement(FB_Error_Feature);
	}
	public WebElement Test_for_free2() {

		return driver.findElement(Test_for_free2);
	}
	public WebElement Test_for_free1() {

		return driver.findElement(Test_for_free1);
	}
	public WebElement features() {

		return driver.findElement(features);
	}
	public WebElement FB_ErrorAE() {

		return driver.findElement(FB_ErrorAE);
	}
	public WebElement FB_SUBMIT() {

		return driver.findElement(FB_SUBMIT);
	}

	public WebElement FB_USER() {

		return driver.findElement(FB_USER);
	}

	public WebElement FB_BUTTON() {

		return driver.findElement(FB_BUTTON);
	}

	public WebElement startTest() {

		return driver.findElement(startTest);
	}

	public WebElement confirmText() {

		return driver.findElement(confirmText);
	}

	public WebElement confrmcard() {

		return driver.findElement(confrmcard);
	}

	public WebElement cvc() {

		return driver.findElement(cvc);
	}

	public WebElement year() {

		return driver.findElement(year);
	}

	public WebElement month() {

		return driver.findElement(month);
	}

	public WebElement cardfield() {

		return driver.findElement(cardfield);
	}

	public WebElement card() {

		return driver.findElement(card);
	}

	public WebElement confirm() {

		return driver.findElement(confirm);
	}

	public WebElement city() {

		return driver.findElement(city);
	}

	public WebElement confirmationButton() {

		return driver.findElement(confirmationButton);
	}

	public WebElement email() {

		return driver.findElement(email);
	}

	public WebElement icon() {

		return driver.findElement(icon);
	}

	public WebElement pass() {

		return driver.findElement(pass);
	}

	public WebElement name() {

		return driver.findElement(name);
	}

	public WebElement subHeader() {

		return driver.findElement(subHeader);
	}

	public WebElement number() {

		return driver.findElement(number);
	}

	public WebElement Header() {

		return driver.findElement(Header);
	}

	public WebElement GreenBar() {

		return driver.findElement(GreenBar);
	}

}
