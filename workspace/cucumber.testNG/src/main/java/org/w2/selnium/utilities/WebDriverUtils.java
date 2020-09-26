package org.w2.selnium.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverUtils {
	
	private WebDriverUtils() {
		
	}
	
	
	private static WebDriver driver = null;
	
	public static WebDriver getWebDriver() {
		
		String browser = "chrome";
	if(driver == null) {	
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new ChromeDriver();
//			driver.get("https://www.facebook.com/");
//			driver.get("https://www.google.co.in/?gfe_rd=cr&ei=KxAzV8-KEJPT8gfT0IWYAw");
		} else {
			driver = new FirefoxDriver();
		}
		
		return driver;
		
	} else {
		return driver;
	
	}
	

}
}