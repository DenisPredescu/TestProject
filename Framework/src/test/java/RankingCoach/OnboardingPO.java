package RankingCoach;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import Resources.Helper;
import extentReport.report.ExtentReport;
import extentReport.testBase.TestEnvironment;

public class OnboardingPO extends TestEnvironment {

	private WebDriver driver;

	// ======= =======

	@FindBy(css = ".video_player")
	WebElement VideoPlayer;

	public WebElement VideoPlayer() {

		return VideoPlayer;

	}

	@FindBy(css = ".rankingcoach > a:nth-of-type(1)")
	WebElement CloseIcon;

	public WebElement CloseIcon() {

		return CloseIcon;

	}

	@FindBy(css = "#dashboard-video-tutorials-toggler")
	WebElement TutorialToggle;

	public WebElement TutorialToggle() {

		return TutorialToggle;
	}

	// =======Domain Name =======

	@FindBy(xpath = "//input[@id='new_domainname']")
	WebElement DomainField;

	@FindBy(css = "#btn-next")
	WebElement CheckWebsite;

	@FindBy(css = "#thumb")
	WebElement Thumb;

	@FindBy(xpath = "//a[@id='btn-next2']")
	WebElement Next;

	// ========Details Page=========================================================

	@FindBy(xpath = "//div[@class='serpBlockYourCompany transition-cubic-bezier']")
	WebElement DetailsImage;

	@FindBy(css = "[tabindex='1']")
	WebElement CompanyName;

	@FindBy(xpath = "//input[@id='site[streetno]']")
	WebElement StreetNo;

	@FindBy(xpath = "//input[@id='site[street]']")
	WebElement Street;

	@FindBy(xpath = "//input[@id='site[city]']")
	WebElement City;

	@FindBy(xpath = "//input[@id='site[postalcode]']")
	WebElement PostalCode;

	@FindBy(css = "select[id='site[country_id]']")
	WebElement DropDown;

	@FindBy(xpath = "//div[@id='country_countainer']")
	WebElement DropDownField;

	@FindBy(css = "[tabindex='2']")
	WebElement PhoneNumber;

	@FindBy(css = "#domain_details_next")
	WebElement DomainNext;

	// ========Sector Page
	// ============================================================

	@FindBy(xpath = "//div[@id='site[categories]_wrapper']")
	WebElement SectorsField;

	@FindBy(xpath = "//div[@id='ui_selectable_list']/ul/li[4]")
	WebElement EducationSector;

	@FindBy(css = "li[rel='132']")
	WebElement ContinuingEducation;

	@FindBy(xpath = "//a[@id='btn-next-platform']")
	WebElement SectorNext;

	// ============Customers
	// Location===================================================

	@FindBy(css = "#frm_operation_radius_sliderContainer")
	WebElement LocationSlider;

	@FindBy(xpath = "/html//div[@id='ui_slider_point_max']")
	WebElement SliderMaxPoint;

	@FindBy(css = "#frm_operation_radius_input_cities_wrapper")
	WebElement LocationField;

	@FindBy(linkText = "WEITER")
	WebElement NextLocation;

	// ============Business Listing==================================

	@FindBy(css = "#business_listing_header")
	WebElement Header;

	@FindBy(xpath = "//span[@class='strong']")
	WebElement InfoText;

	// =============Platform ===================================

	@FindBy(css = "#cms_id")
	WebElement PlatformDropDown;

	@FindBy(css = "#cms_sprite_drupal_grey")
	WebElement DrupalLogo;

	@FindBy(linkText = "WEITER")
	WebElement PlatformNext;

	// ==============Keywords=======================================

	@FindBy(css = "#input_keywords_wrapper")
	WebElement KeyWordsField;

	@FindBy(css = "#btn-next-keywords-input")
	WebElement KeywordsNext;

	// ==============Select/Save KEYWORDS==========================

	@FindBy(css = ".icon-cloud-download")
	WebElement SaveKeywords;

	@FindBy(tagName = "marketing")
	WebElement MarketingKey;

	@FindBy(css = "#keywords_container")
	WebElement KeywordsContainer;

	@FindBy(css = "div[class*='selected']")
	WebElement SelectedKeys;

	@FindBy(xpath = "//div[@class='keyword_bubble_wrapper loaded']")
	WebElement UnselectedKeys;

	@FindBy(xpath = "//div[@class='keyword_bubble_wrapper loaded selected'][2]")
	WebElement SelectedKeys2;

	@FindBy(xpath = "//div[@class='keyword_bubble_wrapper loaded selected']")
	WebElement SelectedKeys3;

	// ==================Keywords priority==============================

	@FindBy(css = "#own_keywords")
	WebElement SelectedKeywords;

	@FindBy(xpath = "//ul[@id='own_keywords']/li[1]/table//tr/td[3]")
	WebElement position1;

	@FindBy(css = "#own_keywords .keyword:nth-of-type(3)")
	WebElement Position3;

	@FindBy(linkText = "WEITER")
	WebElement KeyNext;

	// ======================Competitors ================================

	@FindBy(css = "#competitors-proposed-container")
	WebElement CompetitorsContainer;

	@FindBy(css = "#competitors-selected-container")
	WebElement SelectedCompetitors;

	@FindBy(css = ".display-inline-block .icon-cloud-download")
	WebElement SaveCompetitors;

	// =====================Analysis Page=================================

	@FindBy(css = "/html/body/div[1]//div[@class='text-center']")
	WebElement AnalysisMessage;

	@FindBy(css = "#img-display-container")
	WebElement DisplayContainer;

	@FindBy(xpath = "//div[@id='ui_ajax_container_analysis']/div[4]/div[@class='card']/div")
	WebElement PageContentAnalysis;

	@FindBy(css = ".quickanalysis-visibility-main")
	WebElement QuickAnalysis;

	@FindBy(xpath = "//div[@id='ui_ajax_container_analysis']/div[3]/div[@class='card']/div")
	WebElement OnlineDirectories;

	@FindBy(css = ".analysis-offpage .card-block")
	WebElement WebSiteLinks;

	@FindBy(css = ".analysis-mobile .card-block")
	WebElement MobileAnalysis;

	@FindBy(css = ".card.no-margin-bottom .card-block")
	WebElement SocialMedia;

	@FindBy(css = ".background-triangle .quickanalysis-btn-cta")
	WebElement OptimizeSiteNow;

	// =================Subscription==========

	@FindBy(css = ".img-avatar")
	WebElement AvatarImg;

	@FindBy(css = ".icon-rss")
	WebElement Contract;

	@FindBy(css = "#tab_content .card-section:nth-of-type(4) tr:nth-of-type(2) td:nth-of-type(1)")
	WebElement Subscription;

	@FindBy(css = "#tab_content .card-section:nth-of-type(4) tr:nth-of-type(2) td:nth-of-type(2)")
	WebElement SubsPrice;

	@FindBy(css = "#tab_content .card-section:nth-of-type(4) tr:nth-of-type(2) td:nth-of-type(3)")
	WebElement SubsStatus;

	@FindBy(css = ".icon-home_line")
	WebElement Overview;

	// =================360==========================

	@FindBy(css = ".bg-gray .card-block")
	WebElement Container360;

	@FindBy(css = ".bg-gray .btn-primary")
	WebElement StartButton;

	@FindBy(css = ".form-control")
	WebElement Price360;

	@FindBy(css = "button")
	WebElement upgradeButton;

	public OnboardingPO(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void addDomainAndPressCheck(String domain) throws InterruptedException {

		DomainField.clear();
		DomainField.sendKeys(domain);
		Thread.sleep(1000);
		CheckWebsite.click();

	}

	public void checkThumbandPressNext() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(Thumb));
		// Helper.highLightElement(driver, Thumb);
		String Domain = DomainField.getAttribute("value");

		if (Thumb.isDisplayed()) {

			System.out.println(Domain);
			ExtentReport.test.log(LogStatus.INFO, "The name of the added Domain is: " + Domain);
			Thread.sleep(5000);
			System.out.println(Thumb.getAttribute("src"));
			String ThumbContent = Thumb.getAttribute("src");
			System.out.println("Https://www.rankingcoach.com/thumbs/" + Domain + "/576x377/1/0/");
			// ThumbContent.equals("Https://www.rankingcoach.com/thumbs/" + Domain +
			// "/576x377/1/0/");

			if (ThumbContent.contentEquals("https://www.rankingcoach.com/thumbs/" + Domain + "/576x377/1/0/")) {

				action.click(Next).perform();
				ExtentReport.test.log(LogStatus.INFO, "If Thumb contente equals: Https://www.rankingcoach.com/thumbs/"
						+ Domain + "/576x377/1/0/ press Next Button");

			} else {

				ExtentReport.test.log(LogStatus.ERROR, "Thumb Content is not the right One");

			}

		} else {

			ExtentReport.test.log(LogStatus.ERROR, "Thumb is not displayed ");

		}

	}

	public void CompleteDomainDetails() throws InterruptedException {

		wait.until(ExpectedConditions.invisibilityOf(DetailsImage));
		ExtentReport.test.log(LogStatus.INFO, "Wait until the details images will disappear");

		Thread.sleep(3000);
		Select sel = new Select(DropDown);

		sel.selectByValue("1");
		ExtentReport.test.log(LogStatus.PASS, "Selecte Germany as Country ");

		wait.until(ExpectedConditions.elementToBeClickable(Street));
		Thread.sleep(2000);
		Street.clear();
		action.moveToElement(Street).click().sendKeys("Brugelmann").perform();
		ExtentReport.test.log(LogStatus.PASS, "Type 'Brugelmann' in Street Field");

		Thread.sleep(2000);
		action.sendKeys(Keys.ARROW_DOWN).pause(1000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		// action.sendKeys(Keys.ARROW_DOWN).pause(1000).sendKeys(Keys.ARROW_DOWN).pause(1000).sendKeys(Keys.ARROW_DOWN)
		// .pause(1000).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		ExtentReport.test.log(LogStatus.PASS,
				"Use keys to select your address:'Brügelmannstraße Cologne, Deutschland'");

		// action.moveToElement(StreetNo).click().perform();
		StreetNo.clear();
		action.sendKeys("3").perform();
		ExtentReport.test.log(LogStatus.PASS, "Street No. is:'3'");
		Thread.sleep(2000);

		// action.moveToElement(PostalCode).click().perform();
		PostalCode.clear();
		action.sendKeys("50679");
		ExtentReport.test.log(LogStatus.PASS, "Postal code is:'50679'");
		Thread.sleep(2000);

		action.moveToElement(CompanyName).click().perform();
		action.sendKeys("Test CO.").perform();
		ExtentReport.test.log(LogStatus.PASS, "Company Name is: 'Test CO.'");
		Thread.sleep(2000);

		action.moveToElement(PhoneNumber).click().perform();
		action.sendKeys("+4977272029").perform();
		ExtentReport.test.log(LogStatus.PASS, "Phone Number is: '+4977272029'");
		Thread.sleep(2000);

		action.moveToElement(DomainNext).click().perform();
		ExtentReport.test.log(LogStatus.PASS, "Click on Next Button'");

		/*
		 * String StreetNoValue = StreetNo.getAttribute("value");
		 * if(StreetNoValue==null) {
		 * 
		 * action.click(StreetNo).sendKeys("222").perform();
		 * 
		 * }else {
		 * 
		 * ExtentReport.test.log(LogStatus.PASS,
		 * "StreetNo field contains value:"+StreetNoValue);
		 * 
		 * }
		 */

	}

	public void CompleteSectorPage() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(EducationSector));
		Thread.sleep(2000);
		EducationSector.click();
		ExtentReport.test.log(LogStatus.PASS, "Click on Education Sector");
		Thread.sleep(1000);
		action.moveToElement(ContinuingEducation).doubleClick().perform();
		ExtentReport.test.log(LogStatus.PASS, "Select Continuing Education");
		Thread.sleep(1000);

		action.moveToElement(SectorsField).click().perform();
		action.sendKeys("seo");
		Thread.sleep(1000);
		action.sendKeys(Keys.ARROW_DOWN).pause(1000).sendKeys(Keys.ARROW_DOWN).pause(1000).sendKeys(Keys.ENTER).build()
				.perform();
		ExtentReport.test.log(LogStatus.PASS, "Type Seo in Sector field and select 2nd Sector");

		Thread.sleep(1000);
		action.moveToElement(SectorsField).click().perform();
		action.sendKeys("MARK");
		Thread.sleep(1000);
		action.sendKeys(Keys.ARROW_DOWN).pause(1000).sendKeys(Keys.ENTER).build().perform();
		ExtentReport.test.log(LogStatus.PASS, "Type 'MARK'  in Sector field and select first Sector");

		Thread.sleep(2000);
		SectorNext.click();
		ExtentReport.test.log(LogStatus.PASS, "Click on NEXT button");

	}

	public void CustomersLocation() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(LocationSlider));
		Thread.sleep(1000);
		action.moveToElement(SliderMaxPoint).click(SliderMaxPoint).perform();
		Thread.sleep(2000);
		action.click(LocationField).perform();
		Thread.sleep(2000);
		action.sendKeys("Koln").pause(1000).sendKeys(Keys.ARROW_DOWN).pause(1000).sendKeys(Keys.ARROW_DOWN).pause(1000)
				.sendKeys(Keys.ENTER).perform();
		ExtentReport.test.log(LogStatus.PASS, "Set Are to 200km and Add a new Location in Location Field");

		Thread.sleep(2000);
		NextLocation.click();
		ExtentReport.test.log(LogStatus.PASS, "Click on NEXT button");

	}

	public void BusinessListing() throws InterruptedException {

		wait.until(ExpectedConditions.urlToBe(
				"https://www.rankingcoach.com/customer/onboarding?upgradeTo=seo&showBaseOnboarding=true#business_listing"));
        
		
		Thread.sleep(4000);
		
		action.moveToElement(InfoText).click().perform();
		ExtentReport.test.log(LogStatus.PASS, "Scroll Down and Open Info Text by clicking on it");

		Thread.sleep(2000);
		action.moveToElement(NextLocation).perform();
		Helper.highLightElement(driver, NextLocation);
		action.click().perform();
		ExtentReport.test.log(LogStatus.PASS, "Click on NEXT button");

	}

	public void Platform() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(PlatformDropDown));

		for (int i = 0; i < PlatformDropDown.findElements(By.tagName("option")).size(); i++) {

			System.out.println(PlatformDropDown.findElements(By.tagName("option")).get(i).getText());
			ExtentReport.test.log(LogStatus.PASS,
					"Available CMS: " + PlatformDropDown.findElements(By.tagName("option")).get(i).getText());

			if (PlatformDropDown.findElements(By.tagName("option")).get(i).getText().contains("Drupal")) {

				PlatformDropDown.findElements(By.tagName("option")).get(i).click();
				ExtentReport.test.log(LogStatus.PASS, "Select Drupat as you CSM Platform");
				break;

			}

		}

		if (DrupalLogo.isDisplayed()) {

			Helper.highLightElement(driver, DrupalLogo);
			PlatformNext.click();
			ExtentReport.test.log(LogStatus.PASS, "Click on Next button if Drupal Logo is visible");

		} else {

			ExtentReport.test.log(LogStatus.ERROR, "Something is wrong with the LOGO");

		}

	}

	public void KeyWords() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(VideoPlayer()));
		if (VideoPlayer().isDisplayed()) {

			Thread.sleep(2000);
			action.moveToElement(CloseIcon()).click().perform();

		} else {

			System.out.println("Error");

		}

		Thread.sleep(4000);
		/*
		 * action.moveToElement(KeyWordsField).sendKeys("SEO").perform();
		 * action.sendKeys(Keys.ENTER).perform(); Thread.sleep(1000);
		 * action.moveToElement(KeyWordsField).sendKeys("Marketing").perform();
		 * action.sendKeys(Keys.ENTER).perform(); Thread.sleep(1000);
		 * action.moveToElement(KeyWordsField).sendKeys("Dogital Marketing").perform();
		 * action.sendKeys(Keys.ENTER).perform();
		 */

		action.moveToElement(KeyWordsField).click().pause(1000).sendKeys("SEO").build().perform();
		action.sendKeys(Keys.ENTER).perform();
		ExtentReport.test.log(LogStatus.PASS, "Type 'SEO' in Keywords field and press Enter");
		Thread.sleep(1000);

		action.moveToElement(KeyWordsField).click().pause(1000).sendKeys("marketing").build().perform();
		action.sendKeys(Keys.ENTER).perform();
		ExtentReport.test.log(LogStatus.PASS, "Type 'marketing' in Keywords field and press Enter");
		Thread.sleep(1000);

		action.moveToElement(KeyWordsField).click().pause(1000).sendKeys("Dogital Marketing").build().perform();
		action.sendKeys(Keys.ENTER).perform();
		ExtentReport.test.log(LogStatus.PASS, "Type 'Dogital Marketing' in Keywords field and press Enter");
		Thread.sleep(1000);

		KeywordsNext.click();
		ExtentReport.test.log(LogStatus.PASS, "Click on NEXT button");

	}

	public void SelectKeywords() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(SaveKeywords));

		Thread.sleep(4000);

		// System.out.println(MarketingKey.getText());

		int selectedKeys = KeywordsContainer.findElements(By.cssSelector("div[class*='selected']")).size();

		int unselectedKeys = KeywordsContainer.findElements(By.xpath("//div[@class='keyword_bubble_wrapper loaded']"))
				.size();

		System.out.println(selectedKeys);
		ExtentReport.test.log(LogStatus.PASS, "The number of selected Keys is: " + selectedKeys);

		System.out.println(unselectedKeys);
		ExtentReport.test.log(LogStatus.PASS, "The number of unselected Keys is: " + unselectedKeys);

		int a = 25;

		ExtentReport.test.log(LogStatus.PASS,
				"if the number of selected keywords is less then " + a + " then add them");

		try {

			while (selectedKeys < a) {

				Thread.sleep(500);
				UnselectedKeys.click();
				selectedKeys++;

			}
		} catch (Exception e) {

			System.out.println("There are less then 25 keys");

		}

		System.out.println("The Number of selected Keys is: " + selectedKeys);
		ExtentReport.test.log(LogStatus.PASS, "After you add them the number of selected keys is: " + selectedKeys);

		if (selectedKeys <= a) {

			SaveKeywords.click();
			ExtentReport.test.log(LogStatus.PASS,
					"If The number of selected keys is equal or lower then " + a + " click on Next button");
		} else {

			ExtentReport.test.log(LogStatus.FAIL, "Something is wrong with the number of selected keywords");
		}

	}

	public void KeywordsPriority() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(SelectedKeywords));
		ExtentReport.test.log(LogStatus.PASS, "User is redirected to this page: " + driver.getCurrentUrl());
		int KeyCount = SelectedKeywords.findElements(By.xpath("//ul[@id='own_keywords']/li/table//tr/td[3]")).size();

		System.out.println(KeyCount);

		ExtentReport.test.log(LogStatus.PASS, "The Number of keywords displayed is: " + KeyCount);

		for (int i = 0; i < KeyCount; i++) {

			System.out.println(SelectedKeywords.findElements(By.xpath("//ul[@id='own_keywords']/li/table//tr/td[3]"))
					.get(i).getText());

			ExtentReport.test.log(LogStatus.PASS, "Keyword Name: " + SelectedKeywords
					.findElements(By.xpath("//ul[@id='own_keywords']/li/table//tr/td[3]")).get(i).getText());
		}

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		Thread.sleep(1000);
		js.executeScript("scroll(0,400)");

		if (KeyCount == 25) {

			KeyNext.click();
			ExtentReport.test.log(LogStatus.PASS, "If the Number of Keywords is equal with 25 Press NEXT button");
		}

	}

	public void SelectCompetitors() throws InterruptedException {

		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("/html/body/div[1]//h1[@class='no-margin-bottom']")));
		ExtentReport.test.log(LogStatus.PASS, "User is redirected to this page: " + driver.getCurrentUrl());
		Thread.sleep(5000);

		int proposedCompetitors = CompetitorsContainer.findElements(By.xpath("//div[@id='competitors_proposed']/div"))
				.size();
		System.out.println(proposedCompetitors);
		ExtentReport.test.log(LogStatus.INFO, "The Number of proposed Competitors is: " + proposedCompetitors);

		for (int i = 0; i < SelectedCompetitors.findElements(By.xpath("//div[@id='competitors_proposed']/div"))
				.size(); i++) {

			String CompetitorsName = SelectedCompetitors.findElements(By.xpath("//div[@id='competitors_proposed']/div"))
					.get(i).getText();

			System.out.println(CompetitorsName);

			ExtentReport.test.log(LogStatus.INFO, "Competitor Name " + CompetitorsName);

			if (SelectedCompetitors.findElements(By.xpath("//div[@id='competitors_proposed']/div")).get(i).getText()
					.contains("marketinginstitut.biz")) {

				SelectedCompetitors.findElements(By.xpath("//div[@id='competitors_proposed']/div")).get(i).click();
				System.out.println("Click on the selected item");
				ExtentReport.test.log(LogStatus.PASS, "Select Competitor: marketinginstitut.biz");

			}
			if (SelectedCompetitors.findElements(By.xpath("//div[@id='competitors_proposed']/div")).get(i).getText()
					.contains("die-marketing-academy.de")) {

				SelectedCompetitors.findElements(By.xpath("//div[@id='competitors_proposed']/div")).get(i).click();
				System.out.println("Click on the selected item");
				ExtentReport.test.log(LogStatus.PASS, "Select Competitor: die-marketing-academy.de");
			}
			if (SelectedCompetitors.findElements(By.xpath("//div[@id='competitors_proposed']/div")).get(i).getText()
					.contains("programmierung-webdesign-seo.de")) {

				SelectedCompetitors.findElements(By.xpath("//div[@id='competitors_proposed']/div")).get(i).click();
				System.out.println("programmierung-webdesign-seo.de");
				ExtentReport.test.log(LogStatus.PASS, "Select Competitor: die-marketing-academy.de");
			}
			if (SelectedCompetitors.findElements(By.xpath("//div[@id='competitors_proposed']/div")).get(i).getText()
					.contains("seo-berater-rene-dhemant.business.site")) {

				SelectedCompetitors.findElements(By.xpath("//div[@id='competitors_proposed']/div")).get(i).click();
				System.out.println("Click on the selected item");
				ExtentReport.test.log(LogStatus.PASS, "Select Competitor: seo-berater-rene-dhemant.business.sites");
			}

		}

		int competitors = SelectedCompetitors
				.findElements(By.xpath("//div[@id='competitors_own']/div/div[@class='competitor_sub_wrapper']")).size();
		System.out.println(competitors);
		ExtentReport.test.log(LogStatus.INFO, "The Number of selected Competitors is: " + competitors);

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		Thread.sleep(1000);
		js.executeScript("scroll(400,0)");

		if (competitors <= 5) {

			action.moveToElement(SaveCompetitors).click(SaveCompetitors).perform();
			System.out.println("Click o save Competitors");
			ExtentReport.test.log(LogStatus.PASS,
					"If the Number of added competitors is lower or equal with 5 then press 'Save Competitors button'");

		} else {

			System.out.println("There are more then 5 competitors added ");
			ExtentReport.test.log(LogStatus.FAIL, "Something is wrong with the number of selected competitors");
		}
	}

	public void analysisPage() throws InterruptedException {


		// wait.until(ExpectedConditions.invisibilityOf(AnalysisMessage));
		wait.until(ExpectedConditions.visibilityOf(VideoPlayer()));
		if (VideoPlayer().isDisplayed()) {

			Thread.sleep(2000);
			action.moveToElement(CloseIcon()).click().perform();

		} else {

			System.out.println("Error");

		}
		
		wait.until(ExpectedConditions.visibilityOf(DisplayContainer));

		System.out.println("Page is displayed: " + driver.getCurrentUrl());
		ExtentReport.test.log(LogStatus.PASS, "User is redirected to this page: " + driver.getCurrentUrl());

		Thread.sleep(1000);
		action.moveToElement(QuickAnalysis).perform();
		Helper.highLightElement(driver, QuickAnalysis);
		ExtentReport.test.log(LogStatus.PASS, "Quick Analysis graphic is displayed");

		Thread.sleep(1000);
		action.moveToElement(OnlineDirectories).perform();
		Helper.highLightElement(driver, OnlineDirectories);
		ExtentReport.test.log(LogStatus.PASS, "Online Directories graphic is displayed");

		Thread.sleep(1000);
		action.moveToElement(PageContentAnalysis).perform();
		Helper.highLightElement(driver, PageContentAnalysis);
		ExtentReport.test.log(LogStatus.PASS, "Page Content Analysis graphic is displayed");

		Thread.sleep(1000);
		action.moveToElement(WebSiteLinks).perform();
		Helper.highLightElement(driver, WebSiteLinks);
		ExtentReport.test.log(LogStatus.PASS, "WebSite Links graphic is displayed");

		Thread.sleep(1000);
		action.moveToElement(MobileAnalysis).perform();
		Helper.highLightElement(driver, MobileAnalysis);
		ExtentReport.test.log(LogStatus.PASS, "Mobile Analysis graphic is displayed");

		Thread.sleep(1000);
		action.moveToElement(SocialMedia).perform();
		Helper.highLightElement(driver, SocialMedia);
		ExtentReport.test.log(LogStatus.PASS, "Social Media graphic is displayed");

		action.moveToElement(OptimizeSiteNow).click().perform();
		ExtentReport.test.log(LogStatus.PASS, "Click on Optimize Button");

	}

	public void Subscription() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(VideoPlayer()));
		if (VideoPlayer().isDisplayed()) {

			Thread.sleep(2000);
			action.moveToElement(CloseIcon()).click().perform();

		} else {

			System.out.println("Error");

		}

		ExtentReport.test.log(LogStatus.PASS, "User is redirected to this page: " + driver.getCurrentUrl());
		wait.until(ExpectedConditions.visibilityOf(AvatarImg));

		action.moveToElement(AvatarImg).pause(1000).build().perform();
		action.click(Contract).perform();
		ExtentReport.test.log(LogStatus.PASS, "Hover over Avatar Img and Click on " + Contract.getText());

		wait.until(ExpectedConditions.visibilityOf(Subscription));
		String SubscriptionName = Subscription.getText();
		String Price = SubsPrice.getText();
		String Status = SubsStatus.getText();

		System.out.println(SubscriptionName);
		ExtentReport.test.log(LogStatus.PASS, "Actual subscription: " + SubscriptionName);
		System.out.println(Price);
		ExtentReport.test.log(LogStatus.PASS, "Actual subscription price: " + Price);
		System.out.println(Status);
		ExtentReport.test.log(LogStatus.PASS, "Actual subscription price: " + Status);
		String RealPrice = Price.replaceAll("\\r\\n|\\r|\\n", " ");
		System.out.println(RealPrice);

		if (RealPrice.contains(prop.getProperty("SubsPrice")) && Status.contains(prop.getProperty("SubsStatus"))) {

			Helper.highLightElement(driver, Subscription);
			Helper.highLightElement(driver, SubsPrice);

			action.moveToElement(Overview).click().perform();
			ExtentReport.test.log(LogStatus.PASS, "Click on Overview button");
			wait.until(ExpectedConditions.urlToBe("https://www.rankingcoach.com/customer/index/index_lvi"));
			ExtentReport.test.log(LogStatus.PASS,
					"User is redirected to : https://www.rankingcoach.com/customer/index/index_lvi");
			action.moveToElement(StartButton).perform();
			Helper.highLightElement(driver, Container360);
			action.click(StartButton).perform();
			ExtentReport.test.log(LogStatus.PASS, "Scroll to 360 Container and press on Start Button");

		} else {

			System.out.println("Error");
			ExtentReport.test.log(LogStatus.ERROR, "Subsciption or Subscription Status are not Good");

		}

		System.out.println(driver.getCurrentUrl());
		String URL = driver.getCurrentUrl();
		ExtentReport.test.log(LogStatus.PASS, "User is redirected to " + URL );

		if (URL.equals(prop.getProperty("360"))) {

			action.moveToElement(upgradeButton).perform();
			Helper.highLightElement(driver, upgradeButton);
			action.click(upgradeButton).perform();
			ExtentReport.test.log(LogStatus.PASS, "Upgrade account to 360" );
			

		} else {

			System.out.println("360 Error");
		}

	}
}
