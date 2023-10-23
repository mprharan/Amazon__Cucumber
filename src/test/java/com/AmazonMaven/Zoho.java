package com.AmazonMaven;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Zoho {
	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sony\\eclipse-workspace\\Mini_Project\\Driver\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.get("https://www.zoho.com/login.html");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement a = d.findElement(By.xpath("//*[text()='Sign Up Now']"));
		a.click();
		
		WebElement b = d.findElement(By.cssSelector("#emailfield"));
		b.sendKeys("xyz.com");
		
		WebElement c = d.findElement(By.cssSelector("#password"));
		c.sendKeys("123456");
		
		Thread.sleep(3000);
		d.findElement(By.cssSelector("#signup-termservice")).click();
		
		
		WebElement e = d.findElement(By.xpath("//*[@type='submit']"));
		e.click();
		
		TakesScreenshot scs=(TakesScreenshot) d;
		File screenshotAs = scs.getScreenshotAs(OutputType.FILE);
		File destination=new File("D:\\Selenium scs\\Zoho.png");
		FileHandler.copy(screenshotAs, destination);
		
		//Thread.sleep(3000);
		//d.quit();
	}
}