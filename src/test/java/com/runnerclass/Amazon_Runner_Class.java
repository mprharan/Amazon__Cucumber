package com.runnerclass;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.AmazonMaven.BaseClass;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src//test//java//com//feature//Amazon.feature", glue = "com.stepdefinition", monochrome = true, plugin = {
		"pretty", "html:Report/fb_htmlreport.html", "json:Report/fb_jsonreport.json",
		"junit:Report/fb_junitreport.xml" })
public class Amazon_Runner_Class extends BaseClass {

	@BeforeClass
	public static void setUp() {
		browserLaunch("chrome");
	}

	@AfterClass
	public static void tearDown() {
		close();
	}
}
