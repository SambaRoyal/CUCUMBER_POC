package BaseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;

	public BaseClass() throws IOException {
		/*
		 * String directory=System.getProperty("user.dir");
		 * System.out.println(directory);
		 */
		prop = new Properties();
		FileInputStream fileinputtream = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\proper.properties");
		prop.load(fileinputtream);

	}

	/*
	 * public void browser(String url) {
	 * System.setProperty("webdriver.chrome.driver",
	 * System.getProperty("user.dir") + "\\drivers\\chromedriver.exe"); driver =
	 * new ChromeDriver(); driver.get(url); driver.manage().window().maximize();
	 * driver.manage().deleteAllCookies();
	 * driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS); }
	 */

	@Test
	public void browser_initialization(String browser, String url) {
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.marionette",
					System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			// set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
			// create chrome instance
			driver = new ChromeDriver();
		}
		// Check if parameter passed a 'Edge'
		else if (browser.equalsIgnoreCase("Edge")) { // set path to Edge.exe

			System.setProperty("webdriver.edge.driver", "\\drivers\\IEDriverServer.exe");
			// create Edge instance
			driver = new EdgeDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

	}
}
