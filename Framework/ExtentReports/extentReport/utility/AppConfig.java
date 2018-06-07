package extentReport.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppConfig 
{
	static File appFile = new File("C:\\Users\\Bogdan\\Framework\\src\\main\\java\\Resources\\data.properties");
	static FileInputStream fis;
	static Properties prop = new Properties();
	
	public static String getURL() throws IOException
	{
		try
		{
			fis = new FileInputStream(appFile);
			prop = new Properties();
			prop.load(fis);
			
			return prop.getProperty("urlDE");
		}
		catch(Exception e){ e.printStackTrace();}
		return null;
	}
	
	public static String getBrowser() throws IOException
	{
		try
		{
			fis = new FileInputStream(appFile);
			prop = new Properties();
			prop.load(fis);
			
			return prop.getProperty("browser");
		}
		catch(Exception e){ e.printStackTrace();}
		return null;
	}
	
	public static String getExcelPath() throws IOException
	{
		try
		{
			fis = new FileInputStream(appFile);
			prop = new Properties();
			prop.load(fis);
			
			return prop.getProperty("DataSheetLocation");
		}
		catch(Exception e){ e.printStackTrace();}
		return null;
	}
	
	public static String getReportPath() throws IOException
	{
		try
		{
			fis = new FileInputStream(appFile);
			prop = new Properties();
			prop.load(fis);
			
			return prop.getProperty("ReportsLocation");
		}
		catch(Exception e){ e.printStackTrace();}
		return null;
	}
	
	public static String getScreenShotPath() throws IOException
	{
		try
		{
			fis = new FileInputStream(appFile);
			prop = new Properties();
			prop.load(fis);
			
			return prop.getProperty("ScreenLocation");
		}
		catch(Exception e){ e.printStackTrace();}
		return null;
	}

	public static String getExtent_ConfigXML() throws IOException
{
	try
	{
		fis = new FileInputStream(appFile);
		prop = new Properties();
		prop.load(fis);
		
		return prop.getProperty("ExtentConfigXML");
	}
	catch(Exception e){ e.printStackTrace();}
	return null;
}

	public static String getMacyURL() throws IOException
	{
		try
		{
			fis = new FileInputStream(appFile);
			prop = new Properties();
			prop.load(fis);
			
			return prop.getProperty("MacyURL");
		}
		catch(Exception e){ e.printStackTrace();}
		return null;
	}
	
	public static String getMacyData() throws IOException
	{
		try
		{
			fis = new FileInputStream(appFile);
			prop = new Properties();
			prop.load(fis);
			
			return prop.getProperty("MacyProfileSheet");
		}
		catch(Exception e){ e.printStackTrace();}
		return null;
	}
	

}