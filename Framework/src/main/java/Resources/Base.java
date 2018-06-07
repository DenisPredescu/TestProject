package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class Base

{
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static FileInputStream file;
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports report;
	public static ExtentTest test;

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Bogdan\\Framework\\src\\main\\java\\Resources\\data.properties");

		prop.load(fis);
		String BrowserName = prop.getProperty("browser");

		if (BrowserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "C:\\DriverCh\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (BrowserName.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\DriverMO\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (BrowserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\DriverIE\\MicrosoftWebDriver.exe");
			driver = new InternetExplorerDriver();

		}
		// Wait time will be available for all browsers
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	/*public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C://test//" + result + "screenshot.png"));
	}*/

	public static String getCellData(int rownum, int col) throws IOException {
		file = new FileInputStream("C:\\Files\\Content.xlsx");
		wb = new XSSFWorkbook(file);
		sheet = wb.getSheet("Content");
		row = sheet.getRow(0);
		cell = row.getCell(2);
		return cell.getStringCellValue();

	}
}
