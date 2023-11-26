package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {

	WebDriver driver;
	public OffersPage(WebDriver driver) {
		this.driver = driver;	
	}
	
	public By search = By.xpath("//input[@type='search']");
	public By firstProductName = By.xpath("//table/tbody/tr/td");
	
	public void searchItem(String shortName) {
		driver.findElement(search).sendKeys(shortName);
	}

	public String getFirstProductName() {
		return driver.findElement(firstProductName).getText();		
	}
}
