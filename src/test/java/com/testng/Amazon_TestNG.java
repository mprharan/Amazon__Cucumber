package com.testng;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.AmazonMaven.BaseClass;
import com.AmazonMaven.DataDriven1;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_TestNG extends BaseClass {
	String s;
	long startTime;
	long endTime;
	long totalTime;
	public static WebDriver d = null;

	@BeforeSuite
	public void LaunchBrowser() {
		 startTime = System.currentTimeMillis();
		WebDriverManager.chromedriver().setup();
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://www.amazon.in/");
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

//	@Test(priority = -1)
//	private void launchBrowser() {
//		WebDriverManager.chromedriver().setup();
//		d = new ChromeDriver();
//		d.manage().window().maximize();
//		d.get("https://www.amazon.in/");
//		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	}

	@Test(priority = 0)
	private void user_Select_From_Dropdown() throws IOException {
		WebElement drop_Down = d.findElement(By.name("url"));
		String expected = DataDriven1.singleDataValue("Sheet1", 4, 0);
//		Select drop = new Select(drop_Down);
		List<WebElement> options = dropDownOptions(drop_Down);// Get the dropdown value
		// dropDownOptions(drop_Down);
		for (int i = 0; i < options.size(); i++) {
			String actual = options.get(i).getText();
			if (expected.equalsIgnoreCase(actual)) {
				// drop.selectByVisibleText(actual);
				dropDownSelect("text", drop_Down, actual);
			} else {
				continue;
			}
		}
	}

	@Test(priority = 1)
	private void search_Toys() throws IOException, InterruptedException {
		WebElement f = d.findElement(By.id("twotabsearchtextbox"));
		s = DataDriven1.singleDataValue("Sheet1", 4, 1);
		userInput(f, s);
		System.out.println(s);
		sleep();
	}

	@Test(priority = 2)
	private void click_Search() throws InterruptedException {
		List<WebElement> element = d
				.findElements(By.xpath("//div[@class='autocomplete-results-container']/child::div"));
		sleep();
		for (WebElement web : element) {

			System.out.println(getText(web));
		}
		sleep();
		for (WebElement web : element) {
			if (s.equalsIgnoreCase(web.getText())) {
				clickOnElement(web);
				break;
			}
		}
	}

	@AfterSuite
	public void CloseBrowser() {
		d.close();
		 endTime = System.currentTimeMillis();
		totalTime=endTime-startTime;
		System.out.println(totalTime);
	}
}