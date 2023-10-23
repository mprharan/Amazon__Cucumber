package com.AmazonMaven;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtable {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.worldometers.info/coronavirus/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//		List<WebElement> table = driver.findElements(By.xpath("//table[@id='main_table_countries_today']"));
//		for (WebElement all : table) {
//			System.out.println(all.getText());
////		}
//		System.out.println("************ALL HEADER*************");
//		List<WebElement> allheader = driver.findElements(By.xpath("//table/thead/tr/th"));
//		for (WebElement AllHeader : allheader) {
//			System.out.print(AllHeader.getText() + " ");
//		}
//		System.out.println();
//
////		System.out.println("***********ALL DATA**************");
////		List<WebElement> allData = driver.findElements(By.xpath("//table/tbody/tr/td"));
////		for (WebElement AllData : allData) {
////			System.out.println(AllData.getText());
////		}
////		System.out.println();
//
//		System.out.println("**********PARTICULAR DATA*************");
//		List<WebElement> particularData = driver.findElements(By.xpath("//table/tbody/tr[5]/td[5]"));
//		for (WebElement ParticularData : particularData) {
//			System.out.print(ParticularData.getText() + " ");
//		}
//		System.out.println();
//
//		System.out.println("************ROW WISE*************");
//		List<WebElement> rowWise = driver.findElements(By.xpath("//table/tbody/tr[5]/td"));
//		for (WebElement RowWise : rowWise) {
//			System.out.print(RowWise.getText() + " ");
//		}
//		System.out.println();
//
//		System.out.println("************COLUMN WISE*************");
//		List<WebElement> columnWise = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
//		for (WebElement ColumnWise : columnWise) {
//			System.out.print(ColumnWise.getText() + " ");
//		}
//		System.out.println();

		allHeader();
		particularData("india");
		rowWise("india");
		columnWise();
	}

	static List<WebElement> allColumns;
	static List<WebElement> allRows;
	static List<WebElement> allHeader;
	static String allRowsXpath = "//table[@id='main_table_countries_today']/tbody[not(@class)]/tr";
	static String allHeaderXpath = "//table[@id='main_table_countries_today']/thead/tr/th";
	static int indexOfPopulation;
	static int indexOfCountry;

	private static void allHeader() {
		Map<Integer, String> headerMap = new LinkedHashMap<Integer, String>();
		allHeader = driver.findElements(By.xpath(allHeaderXpath));
		for (int i = 0; i < allHeader.size(); i++) {
			String header = allHeader.get(i).getText().replace("\n", "");
			headerMap.put(i, header);
			if (header.equals("Population")) {
				indexOfPopulation = i;
			} else if (header.contains("Country")) {
				indexOfCountry = i;
			}
		}
		System.out.println(headerMap);
	}

	private static void particularData(String countryName) {

		allRows = driver.findElements(By.xpath(allRowsXpath));
		for (int i = 0; i < allRows.size(); i++) {
			allColumns = allRows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < allColumns.size(); j++) {
				if (allColumns.get(indexOfCountry).getText().equalsIgnoreCase(countryName)) {
					String population = allColumns.get(indexOfPopulation).getText();
					System.out.println(countryName + " population is: " + population);
					break;
				}
			}
		}
	}

	private static void rowWise(String countryName) {
		allRows = driver.findElements(By.xpath(allRowsXpath));
		for (int i = 0; i < allRows.size(); i++) {
			allColumns = allRows.get(i).findElements(By.tagName("td"));
			// System.out.println(allRows.get(i).getText());
			for (int j = 0; j < allColumns.size(); j++) {
				if (allColumns.get(indexOfCountry).getText().equalsIgnoreCase(countryName)) {
					System.out.println(allRows.get(i).getText());
					break;
				}
			}

		}
	}

	private static void columnWise() {
		allRows = driver.findElements(By.xpath(allRowsXpath));
		for (int i = 0; i < allRows.size(); i++) {
			allColumns = allRows.get(i).findElements(By.tagName("td"));
			// System.out.println(allRows.get(i).getText());
			for (int j = 0; j < allColumns.size();) {
				String countryList = allColumns.get(indexOfCountry).getText();
				System.out.println(countryList);
				break;

			}

		}
	}
}
