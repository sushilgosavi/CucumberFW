package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver = driver;	
	}
	public By topDeals = By.linkText("Top Deals");
	public By search = By.xpath("//input[@type='search']");
	public By productName = By.xpath("//h4[@class='product-name']");
	public By increase = By.xpath("//a[@class='increment']");
	public By addToCart = By.xpath("//div[@class='product']/div/button");
	
	public void searchItem(String shortName) {
		driver.findElement(search).sendKeys(shortName);
	}
	
	public String getProductName() {
		return driver.findElement(productName).getText();		
	}
	
	
	public void clickTopDeals () {
		driver.findElement(topDeals).click();			
	}
	
	public String getTitle() {
		return driver.getTitle();		
	}
	
	public void increaseQuantity(int Quantity) {
		while(Quantity-1>0) {
			driver.findElement(increase).click();
			Quantity--;
		}
	}
	
	public void clickAddToCart () {
		driver.findElement(addToCart).click();			
	}
}
