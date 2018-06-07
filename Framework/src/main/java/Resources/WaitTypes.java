package Resources;

//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTypes {
	WebDriver driver;

	public WaitTypes(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getVisibility(WebElement webElement, int timeout) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = (WebElement) wait.until(ExpectedConditions.visibilityOf(webElement));
		return element;

	}

	public void clickElementWhenClickable(WebElement webElement, int timeout) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
		element.click();

	}

}
