package com.web.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Sdp {
	public HomePage home;
public WebDriver d;
//	public HomePage;
	
	private HomePage getHomePage() {
		if(home==null) {
			home=new HomePage(d);
		}
		return home;
	}

	public Sdp(WebDriver d) {
		this.d=d;
		PageFactory.initElements(d, this);
	}

}
