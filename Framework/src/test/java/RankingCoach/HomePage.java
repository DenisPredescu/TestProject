package RankingCoach;

import java.io.IOException;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.Base;
import pageObjects.LoginPage;

public class HomePage extends Base {

	@Test(dataProvider = "getData")
	public HomePage(String Username, String Password, String text) throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		LoginPage action = new LoginPage(driver);
		action.login().click();
		action.username().sendKeys(Username);
		action.password().sendKeys(Password);
		System.out.println(text);
		action.submit().click();
		driver.close();

	}

	@DataProvider
	public Object[][] getData() {
		// Row stands for how many different data types test should run
		// Column stands for how many values per each test
		// Array size is 5=
		// = 0,1,2,3,4
		Object[][] data = new Object[3][3];
		// 0th row
		data[0][0] = "Restricted@yahoo.com";
		data[0][1] = "123456";
		data[0][2] = "Restricted";
		// 1st row
		data[1][0] = "d.predescu@rankingcoach.com";
		data[1][1] = "2109";
		data[1][2] = "Non Restricted";

		data[2][0] = "d.pr1edescu@rankingcoach.com";
		data[2][1] = "21019";
		data[2][2] = "Test";

		return data;
	}
}
