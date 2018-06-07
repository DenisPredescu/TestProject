package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class domainnameobj {

	private WebDriver driver;

	public domainnameobj(WebDriver driver) {

		this.driver = driver;

	}

	By CheckWebsite = By.xpath("//a[@id='btn-next']");
	By Next = By.xpath("//a[@id='btn-next2']");
	By DomainField = By.xpath("//input[@id='new_domainname']");
	By SettingsButton = By.cssSelector("i[class='icon-settings_line no-margin-right']");
	// Tooltips
	By addNewSite = By.xpath("//a[@title='Create new Site']");
	By settingstooltip = By.cssSelector("a[title='Manage sites']");
	// Error
	By EmptyField = By.xpath("//span[@id='advice-required-new_domainname']");
	By InvalidDomain = By.xpath("//span[@id='advice--new_domainname']");
	By CharactersEr = By.xpath("//span[@id='advice-minLength-new_domainname']");
	// Stab
	By detailstab = By.className("progress-bar-steps-step textBold icon-business_line disabled");
	// Thumb Elements
	By domainthumb = By.id("thumb");
	By thumbcontent = By.xpath("//*[@src='/thumbs/www.rankingcoach.com/576x377/1/0/']");
	// Manage Projects
	By addedSite = By.cssSelector("img[src='/thumbs/www.rankingcoach.com/430x330/1/0/@2x']");
	By addedSecondSite = By
			.xpath("//img[@src='/thumbs/subdomain/ZHByZWRlc2N1Mi53aXhzaXRlLmNvbS9ya3Rlc3Q=/@@430x330@@1@@0@2x']");
	By addedThirdSite = By.xpath("//img[@src='/thumbs/www.test.com/430x330/1/0/@2x']");
	By deleteSite = By.cssSelector(".competitor_wrapper:nth-of-type(2) .container-icons [href=\"\\#\"]:nth-of-type(2)");
	By deletesiteYes = By.xpath("//button[@class='btn btn-delete btn-outline-danger']");
	By deletesiteNo = By.xpath("//button[@class='btn-primary btn btn-delete margin-left']");
	By addSiteYes = By.xpath("//button[@class='btn-primary btn']");
	By addSiteNo = By.xpath("//button[@class='btn btn-outline-danger margin-left']");
	By AddNewSite = By.xpath("//a[@class='competitor text-center text-neutral add_big']");
	By addWindow = By.xpath("//div[@class='overlay_window modal no-padding text-center fixed center open']");
	By addWindowContent = By.xpath("//div[@class='card-section-small']/p[1]");
	By addWindowContent2 = By.xpath("//html//div[@class='overlay_content card-block']/div[2]");
	By cancelButton = By.xpath("//a[@href='/customer/agency/cancel_add_site']");
	By addSitebuttonYes = By.xpath("//button[@class='btn-primary btn']");
	// Select sites Drop down
	By selectSites = By.id("site_select");
	By dropDownFirstSite = By.xpath("//option[text()='www.rankingcoach.com']");
	By dropDownSecondSite = By.xpath("//option[text()='dpredescu2.wixsite.com/rktest']");

	
	
	public WebElement addedThirdSite() {
		return driver.findElement(addedThirdSite);
	}

	public WebElement addSiteNo() {
		return driver.findElement(addSiteNo);
	}

	public WebElement addSiteYes() {
		return driver.findElement(addSiteYes);
	}

	public WebElement dropDownSecondSite() {
		return driver.findElement(dropDownSecondSite);
	}

	public WebElement dropDownFirstSite() {
		return driver.findElement(dropDownFirstSite);
	}

	public WebElement addedSecondSite() {
		return driver.findElement(addedSecondSite);
	}

	public WebElement selectSites() {
		return driver.findElement(selectSites);
	}

	public WebElement addSitebuttonYes() {
		return driver.findElement(addSitebuttonYes);
	}

	public WebElement cancelButton() {
		return driver.findElement(cancelButton);
	}

	public WebElement addWindowContent2() {
		return driver.findElement(addWindowContent2);
	}

	public WebElement addWindowContent() {
		return driver.findElement(addWindowContent);
	}

	public WebElement addWindow() {
		return driver.findElement(addWindow);
	}

	public WebElement AddNewSite() {
		return driver.findElement(AddNewSite);
	}

	public WebElement deletesiteNo() {
		return driver.findElement(deletesiteNo);
	}

	public WebElement deletesiteYes() {
		return driver.findElement(deletesiteYes);
	}

	public WebElement deleteSite() {
		return driver.findElement(deleteSite);
	}

	public WebElement CheckWebsite() {
		return driver.findElement(CheckWebsite);
	}

	public WebElement Next() {
		return driver.findElement(Next);
	}

	public WebElement DomainField() {
		return driver.findElement(DomainField);
	}

	public WebElement EmptyField() {
		return driver.findElement(EmptyField);
	}

	public WebElement InvalidDomain() {
		return driver.findElement(InvalidDomain);
	}

	public WebElement CharactersEr() {
		return driver.findElement(CharactersEr);
	}

	public WebElement detailstab() {
		return driver.findElement(detailstab);
	}

	public WebElement domainthumb() {
		return driver.findElement(domainthumb);
	}

	public WebElement thumbcontent() {
		return driver.findElement(thumbcontent);
	}

	public WebElement SettingsButton() {
		return driver.findElement(SettingsButton);
	}

	public WebElement settingstooltip() {
		return driver.findElement(settingstooltip);
	}

	public WebElement addedSite() {
		return driver.findElement(addedSite);
	}
}
