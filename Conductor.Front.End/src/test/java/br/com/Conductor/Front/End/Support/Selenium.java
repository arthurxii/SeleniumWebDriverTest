package br.com.Conductor.Front.End.Support;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium {

	private static WebDriver driver = null;
	
	public static WebDriver getDriver() {
		String browser = Property.BROWSER_NAME;
		if(driver == null) {
			if(Browser.CHROME.equals(browser)) {
				File file = new File(Property.CHROME_DRIVE_PATH);
				System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
				driver = new ChromeDriver();
			} else if (Browser.IE.equals(browser)){
				File file = new File (Property.IE64_DRIVE_PATH);
				System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			} else if (Browser.FIREFOX.equals(browser)){
				driver = new FirefoxDriver();
			}
		}
		return driver;
	}
}
