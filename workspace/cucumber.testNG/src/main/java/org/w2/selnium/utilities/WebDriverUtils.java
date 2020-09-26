package org.w2.selnium.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverUtils {
	
	
	static WebDriver driver;
	
	public static WebDriver getWebDriver() {
		
		String browser = "chrome";
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		
		return driver;
		
	}
	
	

}
