package BaseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;

	public  BaseClass() throws IOException{
		prop = new Properties();
			FileInputStream fileinputtream = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\proper.properties");
			prop.load(fileinputtream);
		
	}		
	

	@Test
	public void browser(String url) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	}

	/*
	 * @Parameters("browser") public void browser_initialization(String browser) {
	 * if(browser.equalsIgnoreCase("firefox")) {
	 * System.setProperty("webdriver.firefox.marionette", ""); driver = new
	 * FirefoxDriver(); } else if(browser.equalsIgnoreCase("chrome")){ //set path to
	 * chromedriver.exe
	 * System.setProperty("webdriver.chrome.driver",".\\chromedriver.exe"); //create
	 * chrome instance driver = new ChromeDriver(); } //Check if parameter passed as
	 * 'Edge' else if(browser.equalsIgnoreCase("Edge")){ //set path to Edge.exe
	 * System.setProperty("webdriver.edge.driver",".\\MicrosoftWebDriver.exe");
	 * //create Edge instance driver = new EdgeDriver(); } else{ //If no browser
	 * passed throw exception throw new Exception("Browser is not correct"); } }
	 */

}
