package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class detailsPageObj {

	private WebDriver driver;

	public detailsPageObj(WebDriver driver) {

		this.driver = driver;
	}

	By detailsImage = By.xpath("//div[@class='serpBlockYourCompany transition-cubic-bezier']");
	By PageContent = By.xpath("//div[@id='onboarding-content']");
	// PageText
	By headLine = By.xpath("//h1[@class='text-center card-title']");
	By subHeadLine = By.xpath("//h4[contains(text(),'Tell us a bit about your company. This will help u')]");
	// Map
	By detailsMap = By.xpath("//div[@id='main-details-map']");
	// Tabs
	By domainTab = By.xpath("//a[@id='domain_name_tab_nav']");
	// Fields
	// By companyName= By.xpath("//div[@class='input-group'][1]");
	By companyName = By.cssSelector("[tabindex='1']");
	By streetNo = By.xpath("//input[@id='site[streetno]']");
	By street = By.xpath("//input[@id='site[street]']");
	By city = By.xpath("//input[@id='site[city]']");
	By postalCode = By.xpath("//input[@id='site[postalcode]']");
	// Errors
	By fieldRequired = By.cssSelector(".tooltip_content");
	By incorectStreet = By.cssSelector(".validation-advice");
	// Buttons
	By Next = By.xpath("//a[@id='domain_details_next']");
	// Country DropDown
	By dropDown = By.cssSelector("select[id='site[country_id]']");
	By dropDownField = By.xpath("//div[@id='country_countainer']");

	
	
	
	public WebElement dropDownField() {
		return driver.findElement(dropDownField);
	}

	public WebElement dropDown() {
		return driver.findElement(dropDown);
	}

	public WebElement postalCode() {
		return driver.findElement(postalCode);
	}

	public WebElement Next() {
		return driver.findElement(Next);
	}

	public WebElement incorectStreet() {
		return driver.findElement(incorectStreet);
	}

	public WebElement fieldRequired() {
		return driver.findElement(fieldRequired);
	}

	public WebElement city() {
		return driver.findElement(city);
	}

	public WebElement street() {
		return driver.findElement(street);
	}

	public WebElement streetNo() {
		return driver.findElement(streetNo);
	}

	public WebElement companyName() {
		return driver.findElement(companyName);
	}

	public WebElement domainTab() {
		return driver.findElement(domainTab);
	}

	public WebElement detailsMap() {
		return driver.findElement(detailsMap);
	}

	public WebElement detailsImage() {
		return driver.findElement(detailsImage);
	}

	public WebElement PageContent() {
		return driver.findElement(PageContent);
	}

	public WebElement headLine() {
		return driver.findElement(headLine);
	}

	public WebElement subHeadLine() {
		return driver.findElement(subHeadLine);
	}

}
