package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class operationRadiusObj {

	private WebDriver Driver;

	public operationRadiusObj(WebDriver Driver) {

		this.Driver = Driver;

	}

	// Content
	By headline = By.cssSelector(".card-title");
	By lOperating = By.cssSelector(".row .relative div:nth-of-type(1) .form-control-radio-text");
	By nationWide = By.cssSelector(".row div:nth-of-type(2) .form-control-radio-text");
	By slider = By.xpath("//div[@id='frm_operation_radius_sliderContainer']/div");
	By sliderText = By.xpath("//div[@id='frm_operation_radius_sliderContainer']/p");
	By maxLocations = By.xpath("//p[@class='text-center']");
	By field = By.cssSelector("#frm_operation_radius_input_cities_wrapper");
	By tooltip = By.cssSelector(".ui_taginput_legend");
	By map = By.xpath("//div[@id='map_operation_radius']");
	// Radio Buttons
	By Button1 = By.xpath("//form[@id='frm_operation_radius']//div[@class='relative']/div[1]/label/div[1]");
	By Button2 = By.xpath("/html//form[@id='frm_operation_radius']/div[@class='card-section']//div[@class='relative']/div[2]/label/div[@class='form-control-radio-check']");
	// FadedElement
	By fade = By.cssSelector(".disabled-overlay-faded");
	// slider
	By sliderPoint1 = By.xpath("/html//div[@id='ui_slider_point_min']");
	By sliderPoint2 = By.xpath("/html//div[@id='ui_slider_point_max']");
	By sliderKnob = By.cssSelector("#ui_slider_knob");
	//field
	By sf = By.xpath("//span[text()='san francisco']");
	By closeIcon = By.cssSelector(".icon-cross");
	By fieldContent = By.xpath("//div[@id='frm_operation_radius_input_cities_wrapper']//textarea[@class='taginput']");
	//errorMessage
	By error = By.xpath("//div[@class='overlay_window transparent notification fixed top open']");
	//Next
	By next = By.linkText("NEXT");

	
	
	
	
	public WebElement next() {
		return Driver.findElement(next);

	}
	public WebElement error() {
		return Driver.findElement(error);

	}
	public WebElement fieldContent() {
		return Driver.findElement(fieldContent);

	}
	public WebElement closeIcon() {
		return Driver.findElement(closeIcon);

	}
	public WebElement sf() {
		return Driver.findElement(sf);

	}
	public WebElement sliderKnob() {
		return Driver.findElement(sliderKnob);

	}
	public WebElement sliderPoint2() {
		return Driver.findElement(sliderPoint2);

	}
	public WebElement sliderPoint1() {
		return Driver.findElement(sliderPoint1);

	}
	public WebElement fade() {
		return Driver.findElement(fade);

	}

	public WebElement Button1() {
		return Driver.findElement(Button1);

	}

	public WebElement Button2() {
		return Driver.findElement(Button2);

	}

	public WebElement map() {
		return Driver.findElement(map);

	}

	public WebElement tooltip() {
		return Driver.findElement(tooltip);

	}

	public WebElement field() {
		return Driver.findElement(field);

	}

	public WebElement maxLocations() {
		return Driver.findElement(maxLocations);

	}

	public WebElement sliderText() {
		return Driver.findElement(sliderText);

	}

	public WebElement slider() {
		return Driver.findElement(slider);

	}

	public WebElement nationWide() {
		return Driver.findElement(nationWide);

	}

	public WebElement lOperating() {
		return Driver.findElement(lOperating);

	}

	public WebElement headline() {
		return Driver.findElement(headline);

	}

}
