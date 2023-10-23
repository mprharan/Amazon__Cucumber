package com.stepdefinition;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.AmazonMaven.BaseClass;
import com.AmazonMaven.DataDriven1;
import com.runnerclass.Amazon_Runner_Class;
import com.web.pom.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Amazon_Step_Definition extends BaseClass {
	public static WebDriver d = Amazon_Runner_Class.d;
	HomePage home = new HomePage(d);

	String s;

	@Given("^User Launch The Application$")
	public void user_Launch_The_Application() throws Throwable {

		launchUrl("https://www.amazon.in/");
		implicitlyWait();

	}

	@When("^User Select From Dropdown$")
	public void user_Select_From_Dropdown() throws Throwable {

		String expected = DataDriven1.singleDataValue("Sheet1", 4, 0);
		List<WebElement> options = dropDownOptions(home.getDropDown());// Get the dropdown value
		for (int i = 0; i < options.size(); i++) {
			String actual = options.get(i).getText();
			if (expected.equalsIgnoreCase(actual)) {
				dropDownSelect("text", home.getDropDown(), actual);
			} else {
				continue;
			}
		}
	}

	@When("^Search Toys$")
	public void search_Toys() throws Throwable {

		s = DataDriven1.singleDataValue("Sheet1", 4, 1);
		userInput(home.search_Toys(), s);
		System.out.println(s);
		sleep();
	}

	@Then("^Click Search$")
	public void click_Search() throws Throwable {

		List<WebElement> suggestionsContainer = home.suggestions();
		sleep();
		for (WebElement web : suggestionsContainer) {

			System.out.println(getText(web));
		}
		sleep();
		for (WebElement web : suggestionsContainer) {
			if (s.equalsIgnoreCase(web.getText())) {
				clickOnElement(web);
				break;
			}

		}
	}
}
