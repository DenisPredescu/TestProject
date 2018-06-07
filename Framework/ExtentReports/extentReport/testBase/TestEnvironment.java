package extentReport.testBase;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


import com.relevantcodes.extentreports.LogStatus;

import RankingCoach.OnboardingPO;
import RankingCoach.domain_name;
import extentReport.report.ExtentReport;
import extentReport.utility.AppConfig;
import pageObjects.CreateAccountObj;
import pageObjects.LoginPage;
import pageObjects.WebsitePO;
import pageObjects.business_listingObj;
import pageObjects.domainnameobj;

public class TestEnvironment extends TestBase
{	
	public static Actions action;
	public static WebDriverWait wait;
	public static business_listingObj element;
	public static CreateAccountObj el;
	public static domainnameobj domain;
	//public static domain_name domainpage;
	public static LoginPage login;
	public static WebsitePO website;
	public static OnboardingPO onboarding;
	
	@BeforeClass(alwaysRun=true)
	public void setUp() throws InterruptedException, NullPointerException, IOException
	{
		System.out.println("*****************************************************");
		System.out.println("launching Browser");
		TestBase.getBrowser(AppConfig.getBrowser());
		//WaitHelper.setImplicitWait(50);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//WaitHelper.setPageLoadTimeout(50);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	}
	
	@BeforeTest
	public void testStart() throws IOException
	{		
		
		ExtentReport.extent.addSystemInfo("Project Name","Denis Project");
		ExtentReport.extent.addSystemInfo("Time Zone", System.getProperty("user.timezone"));
		ExtentReport.extent.addSystemInfo("User Location", System.getProperty("user.country"));
		ExtentReport.extent.addSystemInfo("OS version", System.getProperty("os.version"));
		ExtentReport.extent.addSystemInfo("Java Version", System.getProperty("java.version"));
		
		ExtentReport.extent.loadConfig(new File(AppConfig.getExtent_ConfigXML()));
	}
	
	@BeforeMethod
	public static void beforeMethod(Method result)
	{
		element = new business_listingObj(driver);
		action = new Actions(driver);
		wait = new WebDriverWait(driver, 40);
		//domainpage = new domain_name(driver);
		el = new CreateAccountObj(driver);
		login = new LoginPage(driver);
		domain = new domainnameobj(driver);
		website = new WebsitePO(driver);
		onboarding = new OnboardingPO(driver);
		
		
		ExtentReport.test=ExtentReport.extent.startTest(result.getName());
		ExtentReport.test.log(LogStatus.INFO,result.getName()+" Test has Started");
	}
	
	@AfterMethod
	public static void afterMethod(ITestResult result) throws IOException
	{
		ExtentReport report = new ExtentReport();
		report.getResult(result);
		

	}
	
	@AfterTest
	public void testResult()
	{
		ExtentReport.extent.endTest(ExtentReport.test);
		ExtentReport.extent.flush();
		
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDown() throws Exception
	{
		if(TestBase.driver!= null)
				{
					System.out.println("Closing the Browser");
					System.out.println("*****************************************************");
					TestBase.driver.close();
					TestBase.driver.quit();
				}
	}
}
