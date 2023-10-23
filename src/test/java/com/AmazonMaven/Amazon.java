package com.AmazonMaven;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.web.pom.HomePage;

public class Amazon extends BaseClass {
	public static WebDriver d=null;
	public static void main(String[] args) throws InterruptedException, IOException {
		// WebDriverManager.chromedriver().setup();
//		WebDriver d = new ChromeDriver();
		d=browserLaunch("chrome");
		HomePage home=new HomePage(d);
//Sdp sdp=new Sdp(d);
		// d.get("https://www.amazon.in/");
		launchUrl("https://www.amazon.in/");
		// d.manage().window().maximize();
		// d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		implicitlyWait();
		Thread.sleep(1000);
		//WebElement drop_Down = d.findElement(By.name("url"));
//String expected="Baby";
		// hp.getDropDown();

		String expected = DataDriven1.singleDataValue("Sheet1", 4, 0);
		Select drop = new Select(home.getDropDown());//from homepage
		List<WebElement> options = drop.getOptions();// Get the dropdown value
		for (int i = 0; i < options.size(); i++) {
			String actual = options.get(i).getText();
			if (expected.equalsIgnoreCase(actual)) {
				drop.selectByVisibleText(actual);
			} else {
				continue;
			}
		}
		//WebElement f = d.findElement(By.id("twotabsearchtextbox"));
		String s = DataDriven1.singleDataValue("Sheet1", 4, 1);
		userInput(home.search_Toys(), s);
		// f.sendKeys(s);
		Thread.sleep(6000);
//		List<WebElement> element = d
//				.findElements(By.xpath("//div[@class='autocomplete-results-container']/child::div"));
		// System.out.println(getText(element));
		// Thread.sleep(1000);
		List<WebElement> suggestionsContainer =home.suggestions();
		sleep();
		for (WebElement web : suggestionsContainer) {
			System.out.println(web.getText());
		}
		// Thread.sleep(2000);
		sleep();
		for (WebElement web : suggestionsContainer) {
			if (s.equalsIgnoreCase(web.getText())) {
				// web.click();
				clickOnElement(web);
				break;
			}
			/*
			 * for (WebElement web : element) { if(s.equals(web.getText())) { web.click();
			 * break;
			 * 
			 * }
			 */
		}
	}
}
//	{
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Users\\sony\\eclipse-workspace\\Mini_Project\\Driver\\chromedriver.exe");
//		WebDriver d = new ChromeDriver();
//		d.get("https://www.amazon.in/");
//		d.manage().window().maximize();
//		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//		WebElement drop = d.findElement(By.name("url"));
//		String expect= DataDriven1.singleDataValue("Sheet1", 4, 0);
//		Select s = new Select(drop);
//		Thread.sleep(3000);
//		List<WebElement> options = s.getOptions();
//		for (int i = 0; i < options.size(); i++) {
//			String actual = options.get(i).getText();
//
//			if (expect.equalsIgnoreCase(actual)) {
//				s.selectByVisibleText("Baby");
//			} else {
//				continue;
//			}
//
//		}
//
//		WebElement search = d.findElement(By.xpath("//form[@name='site-search']/child::div[2]/child::div[1]/input"));
//		String s1 =DataDriven1.singleDataValue("Sheet1",4 , 1);
//		search.sendKeys(s1);
//
//		// WebElement findElement =
//		// d.findElement(By.xpath("//div[@id='nav-flyout-iss-anchor']/child::div/child::div[2]/child::div"));
//		Thread.sleep(6000);
//		List<WebElement> sug = d.findElements(By.xpath("//div[@class='autocomplete-results-container']/child::div"));
//		for (WebElement x : sug) {
//			System.out.println(x.getText());
//		}
//
//		for (int i = 0; i < sug.size(); i++) {
//			if (s1.equalsIgnoreCase(sug.get(i).getText())) {
//				sug.get(i).click();
//
//			} else {
//				continue;
//			}
//
//		}
////			}catch(Exception e) {
////				System.out.println("Error");
////			}
////			
//	}
