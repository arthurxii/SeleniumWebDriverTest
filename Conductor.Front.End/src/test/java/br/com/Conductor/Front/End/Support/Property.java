package br.com.Conductor.Front.End.Support;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public abstract class Property {

	public static String CHROME_DRIVE_PATH;
	public static String IE64_DRIVE_PATH;
	public static String FIREFOX_DRIVE_PATH;
	public static final String BROWSER_NAME;
	public static final String SITE_ADDRESS;
	
	private static final String PROPERTIES_FILE = "com/org/config/config.properties";
	static{
		CHROME_DRIVE_PATH = new File("").getAbsolutePath() + "/src/main/resources/chromedriver.exe";
		IE64_DRIVE_PATH = new File("").getAbsolutePath() + "/src/main/resources/IEDriverServer.exe";
		FIREFOX_DRIVE_PATH = new File("").getAbsolutePath() + "/src/main/resources/geckodriver.exe";
		BROWSER_NAME = get("browser.name");
		SITE_ADDRESS = get("site.address");
	}
	
	private static String get(String name) {
		Properties properties = new Properties();
		String value = null;
		try{
			properties.load(Property.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE));
			value = properties.getProperty(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
}
