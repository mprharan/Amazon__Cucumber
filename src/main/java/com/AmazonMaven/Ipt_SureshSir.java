package com.AmazonMaven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ipt_SureshSir {
	public static WebDriver d=null;
	
	public static void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		d = new ChromeDriver();
		d.get("https://www.myntra.com/men-tshirts");
		d.manage().window().maximize();
		
	}
	
	public static void productsCount() {

		List<WebElement> allProducts = d.findElements(By.xpath("//li[@class='product-base']"));
		int totalNumberOfProducts = allProducts.size();
		System.out.println("The total count of prouct is : "+totalNumberOfProducts);
		
		for (WebElement product : allProducts) {
			//System.out.println(product.getText());
		}
		
	}
	public static void minimumPriceOfAllProducts() {

		List<Integer> priceList = new ArrayList<Integer>();
		List<WebElement> allPrices = d.findElements(By.xpath("//li[@class='product-base']//descendant::div[@class='product-price']/span/span[@class='product-discountedPrice']"));
		for (WebElement price : allPrices) {
			String priceText = price.getText().replaceAll("Rs. ", "");
			System.out.println(priceText);
			Integer priceValue = Integer.parseInt(priceText);
			priceList.add(priceValue);
		}
		Integer  minPrice = Collections.min(priceList);
		System.out.println("MINIMUM PRICE PRODUCT : "+minPrice);

	}
	public static void nameOfTheProuct() {
		WebElement nameOfMinPriceProduct = d.findElement(By.xpath("//li[@class='product-base']//descendant::div[@class='product-price']/span/span[text()='174']//ancestor::div[@class='product-productMetaInfo']//child::h3"));
		System.out.println("NAME OF THE PRODUCT :"+nameOfMinPriceProduct.getText());
	}
	public static void main(String[] args) {
		
		browserLaunch();
		productsCount();
		minimumPriceOfAllProducts();
		nameOfTheProuct();
		
		}
}
