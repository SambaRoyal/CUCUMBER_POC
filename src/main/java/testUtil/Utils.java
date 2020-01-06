package testUtil;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

	public void clickElement(By element, WebDriver driver) {
		new WebDriverWait(driver, 60, 500).until(ExpectedConditions.presenceOfElementLocated(element));
		driver.findElement(element).click();
		System.out.println("expected path :" + element);
	}

	public void inputText(By element, String text, WebDriver driver) {
		new WebDriverWait(driver, 60, 500).until(ExpectedConditions.visibilityOfElementLocated(element));
		WebElement ele = driver.findElement(element);
		String value = "";

		do {
			ele.clear();
			ele.sendKeys(text);
			value = text.toString();
			System.out.println("ACTUAL STRING VALUE IN TEXTBOX  :" + value);

		} while (!(text.toLowerCase()).equals(value.toLowerCase()));
	}

	public void verifyingToolTip(By element, WebDriver driver) {
		new WebDriverWait(driver, 60, 500).until(ExpectedConditions.visibilityOfElementLocated(element));
		WebElement elem = driver.findElement(element);

		Actions action = new Actions(driver);
		action.clickAndHold(elem).build().perform();
	}

	public void textValidations(By element , WebDriver driver,String value) {
		new WebDriverWait(driver, 50, 500).until(ExpectedConditions.visibilityOfElementLocated(element));
		  String text=driver.findElement(element).getText();
		  System.out.println("Validation String text  :"+text);
		  assertEquals(text,value);
	}
	public void imageValidation(By element, WebDriver driver) {
		WebElement image=driver.findElement(element);
		Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", image);
	        if (ImagePresent)
	        {
	             System.out.println("Expected Image is displayed.");
	        }
	        else
	        {
	            System.out.println("Image unable to displayed.");
	        }
	}
	
	
	
}
