package com.RankingCoach.LogInCreateAccMethods;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import extentReport.report.ExtentReport;
import extentReport.testBase.TestBase;
import extentReport.testBase.TestEnvironment;
import extentReport.utility.AppConfig;


public class testAllTheLinks extends TestEnvironment {
	
	
	
	@Test
	public void  VerifyLinks() throws IOException, InterruptedException {
		
		TestBase.loadPropertiesFile();
		TestBase.driver.navigate().to(AppConfig.getURL());
		website.clickOnSelectCountry();
		Thread.sleep(3000);
		
		List<WebElement> linksList = clickableLinks(driver);
		for (WebElement link : linksList ) {
			
			String href = link.getAttribute("href");
			
			try {
				 
				System.out.println("URL " + href + " returned " + linkStatus(new URL(href)));
				ExtentReport.test.log(LogStatus.INFO, "URL " + href + " returned " + linkStatus(new URL(href)));
				
			} catch(Exception e) {
				
				System.out.println(e.getMessage());
				
			}
			
			
		}
		
		
	}
	
	public static List<WebElement> clickableLinks(WebDriver driver){
		
		List<WebElement> linksToClick = new ArrayList<WebElement>();
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		elements.addAll(driver.findElements(By.tagName("img")));
		
		for(WebElement e : elements) {
			
			if(e.getAttribute("href") !=null){
				
            	linksToClick.add(e);
				
			}
		}
		
		return linksToClick;	
		
	}
	
	public static String linkStatus(URL url) {
		
		try {
			
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.connect();
			String responseMessage = http.getResponseMessage();
			http.disconnect();
		    return responseMessage;
			
		} catch (Exception e) {
			
			return e.getMessage();
			
		}
			
		
	}
}
