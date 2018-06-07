package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class businessSectorObj {

	private WebDriver driver;

	public businessSectorObj(WebDriver driver) {

		this.driver = driver;
	}
	
	//TabNav
	By tab=By.cssSelector("#details_tab_nav");
	By object=By.xpath("//div[@id='containerChartBusiness']/div");

	// Buttons
	By Next = By.cssSelector("#domain_details_next");
	By NextButton = By.cssSelector("#btn-next-platform");
	// Content
	By sectorFieldContent = By.xpath("//div[@id='site[categories]_wrapper']");
	By headline = By.xpath("//h1[text()='Enter your company sector']");
	By subheadline = By.xpath("//div[@class='tab_content']/div[4]//h4");
	By industry = By.xpath("//div[@id='business-sector-multi-select-wrapper']/div[1]/div[1]");
	By category = By.xpath("//div[@id='business-sector-multi-select-wrapper']/div[1]/div[2]");
	By sector = By.xpath("//div[@id='business-sector-multi-select-wrapper']/div[1]/div[3]");
	By selectCategory = By.xpath("//p[text()='Please select at least one category in order to continue']");
	// IndustryContent
	By industryList = By.cssSelector("#ui_selectable_list");
	By Arts = By.xpath("//li[text()='Arts & Entertainment']");
	By Automotive = By.xpath("//li[text()='Automotive']");
	By Beauty = By.xpath("//li[text()='Beauty & Wellness']");
	By Construction = By.xpath("//li[text()='Construction & Handcraft']");
	By Education = By.xpath("//li[text()='Education']");
	By Pets = By.xpath("//div[@id='ui_selectable_list']/ul/li[12]");
	By Services = By.xpath("//li[text()='Services']");
	By Manufacture = By.xpath("//li[text()='Car Manufacturer']");
	By Media = By.xpath("//li[text()='Media']");
	By Leisure = By.xpath("//li[text()='Leisure & Sport']");
	By House = By.xpath("//li[text()='House & Garden']");
	By Health = By.xpath("//li[text()='Health & Medicine']");
	// CategoryContent
	By categoryList = By.xpath("//div[@id='business-sector-multi-select-wrapper']/div[1]/div[2]/div/div[@class='ui_selectable_list']");
	By agricultural = By.xpath("//li[text()='Agricultural Machinery Dealer']");
	By automotive = By.xpath("//li[text()='Automotive Paint Shop']");
	By vehicle = By.xpath("//li[text()='Vehicle Manufacturing']");
	By carDealer = By.xpath("//li[text()='Car Dealer']");
	// SectorContent
	By newCarDealer = By.xpath("//li[text()='New Car Dealer']");
	// Sector field
	By sectorContent = By.xpath("//div[@id='site[categories]_wrapper']");
	By removeIcon = By.xpath("//a[@class='icon-cross'][1]");
	By sectorText = By.cssSelector("textarea[placeholder='Enter Sectors here']");
	By scrollArrow = By.xpath("/html/body/div[1]");
	By FirstSeo = By.xpath("//span[text()='Services > Marketing & PR > SEO Agency']");
    By ForthIT = By.xpath("//span[text()='Services > Computing Services > IT Hardware Services']");
	By SecondMarketing = By.xpath("//span[text()='Services > Marketing & PR > Online Marketing']");
	By ThirdMarket=By.xpath("//span[text()='Services > Marketing & PR > Market Research']");
	By sectorField = By.xpath("//form[@id='frm_business_sector']");
	
	
	
	
	
	public WebElement NextButton() {
		return driver.findElement(NextButton);
	}
	public WebElement sectorFieldContent() {
		return driver.findElement(sectorFieldContent);
	}
	 public WebElement ThirdMarket() {
			return driver.findElement(ThirdMarket);
		}
	 public WebElement SecondMarketing() {
			return driver.findElement(SecondMarketing);
		}
    public WebElement ForthIT() {
		return driver.findElement(ForthIT);
	}
    public WebElement FirstSeo() {
		return driver.findElement(FirstSeo);
	}
	public WebElement scrollArrow() {
		return driver.findElement(scrollArrow);
	}
	public WebElement sectorText() {
		return driver.findElement(sectorText);
	}
	public WebElement object() {
		return driver.findElement(object);
	}
	public WebElement tab() {
		return driver.findElement(tab);
	}
	
	public WebElement Health() {
		return driver.findElement(Health);
	}
	public WebElement House() {
		return driver.findElement(House);
	}
	public WebElement Leisure() {
		return driver.findElement(Leisure);
	}
	public WebElement Media() {
		return driver.findElement(Media);
	}
	public WebElement removeIcon() {
		return driver.findElement(removeIcon);
	}

	public List<WebElement> sectorContent() {
		return driver.findElements(sectorContent);
	}

	public WebElement newCarDealer() {
		return driver.findElement(newCarDealer);
	}

	public WebElement carDealer() {
		return driver.findElement(carDealer);
	}

	public WebElement Manufacture() {
		return driver.findElement(Manufacture);
	}

	public WebElement Services() {
		return driver.findElement(Services);
	}

	public WebElement vehicle() {
		return driver.findElement(vehicle);
	}

	public WebElement automotive() {
		return driver.findElement(automotive);
	}

	public WebElement agricultural() {
		return driver.findElement(agricultural);
	}

	public WebElement categoryList() {
		return driver.findElement(categoryList);
	}

	public WebElement Pets() {
		return driver.findElement(Pets);
	}

	public WebElement Education() {
		return driver.findElement(Education);
	}

	public WebElement Construction() {
		return driver.findElement(Construction);
	}

	public WebElement Beauty() {
		return driver.findElement(Beauty);
	}

	public WebElement Automotive() {
		return driver.findElement(Automotive);
	}

	public WebElement Arts() {
		return driver.findElement(Arts);
	}

	public WebElement industryList() {
		return driver.findElement(industryList);
	}

	public WebElement sectorField() {
		return driver.findElement(sectorField);
	}

	public WebElement selectCategory() {
		return driver.findElement(selectCategory);
	}

	public WebElement sector() {
		return driver.findElement(sector);
	}

	public WebElement category() {
		return driver.findElement(category);
	}

	public WebElement industry() {
		return driver.findElement(industry);
	}

	public WebElement subheadline() {
		return driver.findElement(subheadline);
	}

	public WebElement Next() {
		return driver.findElement(Next);
	}

	public WebElement headline() {
		return driver.findElement(headline);
	}

}
