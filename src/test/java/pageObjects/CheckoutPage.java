package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	
	}
	public By cartBag = By.xpath("//img[@alt='Cart']");
	public By CheckoutButton = By.xpath("//div[contains(@class,'cart')]/div/button");
	public By promoBtn = By.xpath("//button[@class='promoBtn']");
	public By PlaceOrder = By.xpath("//button[contains(text(),'Place Order')]");
	public By ProductName = By.xpath("//p[@class='product-name']");
	
	public void checkoutItems() {
		driver.findElement(cartBag).click();
		driver.findElement(CheckoutButton).click();
	}
	
	public boolean verifyPromoBtn() {
		return driver.findElement(promoBtn).isDisplayed();
	}

	public boolean verifyPlaceOrder() {
		return driver.findElement(PlaceOrder).isDisplayed();
	}
	
	public String getProductName() {
		return driver.findElement(ProductName).getText().split("-")[0].trim();		
	}
}

