package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class TestBase {
	public WebDriver driver;

	public WebDriver WebDriverManager() throws IOException {
		if (driver == null) {
			
			FileInputStream fis = new FileInputStream(
			System.getProperty("user.dir") + "\\src\\test\\resources\\global.properties");
			Properties prop = new Properties();
			
			prop.load(fis);
			String mvn_BrowserName = prop.getProperty("browser").toLowerCase();
			String cli_BrowserName = System.getProperty("browser");
			
			mvn_BrowserName = (cli_BrowserName!=null) ? cli_BrowserName : mvn_BrowserName;
			
			switch (mvn_BrowserName) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriver"));
				driver = new ChromeDriver();
				break;
			case "firefox":
				break;
			case "edge":	
				System.setProperty("webdriver.edge.driver",  prop.getProperty("edgeDriver"));
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--remote-allow-origins=*");
			//	EdgeDriver driver = new EdgeOptions(options);
				
				driver = new EdgeDriver(options);
				break;
			case "safari":
				break;
			case "ie":
				break;
			default:
				System.out.println("Invalid browser = " + mvn_BrowserName);
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(prop.getProperty("URL"));
		}
		return driver;
	}
}
