package com.web.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver d;

	@FindBy(name = "url")//@findby(locator="value")
	private WebElement drop_down; // private return_type refname
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement value;
	
	@FindBy(xpath="//div[@class='autocomplete-results-container']/child::div")
	private List<WebElement> element;

	public HomePage(WebDriver d) {
		this.d = d;
		PageFactory.initElements(d, this);
	}


	public WebElement getDropDown() {
		return drop_down;
	}
	
	public WebElement search_Toys() {
		return value;
	}
	
	public List<WebElement> suggestions() {
		return element;
	}

}
