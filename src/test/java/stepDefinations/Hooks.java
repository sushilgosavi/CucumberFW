package stepDefinations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriverException;

import io.cucumber.java.*;
//import io.cucumber.java.AfterStep;
//import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {
	
	TestContextSetup testContextSetup;
	
	
	
	public Hooks(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}
	
	@After
	public void AfterScenario() throws IOException {
		
		testContextSetup.testBase.WebDriverManager().quit();
	}
	
	@AfterStep
	public void takeScreenshot(Scenario scen) throws WebDriverException, IOException {
		if(scen.isFailed()) {
			System.out.println("Step is failed getName = " + scen.getName());
			System.out.println("Step is failed getLine = " + scen.getLine());
			File sourcePath =((TakesScreenshot)testContextSetup.testBase.WebDriverManager()).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scen.attach(fileContent, "image/jpeg", "image");
		}
	}
}
