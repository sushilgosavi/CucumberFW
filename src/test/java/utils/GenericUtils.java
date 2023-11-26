package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	public WebDriver driver;
	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}
	public void SwitchWindowToChild() {
		Set<String> Wh = driver.getWindowHandles();
		Iterator<String> i1 = Wh.iterator();
		String parentWindow = i1.next();
		String childWindow = i1.next();
		driver.switchTo().window(childWindow);
	}
	
}
