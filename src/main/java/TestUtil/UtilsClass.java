package TestUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilsClass {
	
	public void clickElement(By element, WebDriver driver) {
	new WebDriverWait(driver, 60, 500).until(ExpectedConditions.presenceOfElementLocated(element));
		driver.findElement(element).click();
System.out.println("Expected path :"+element);	
	}
	
	public void inputText(By element , String text , WebDriver driver) {
		new WebDriverWait(driver, 60, 500).until(ExpectedConditions.visibilityOfElementLocated(element));	
	WebElement ele=	driver.findElement(element);
		String value="";
	
		do {
			ele.sendKeys(text);
			value=text.toString();
			System.out.println("Actual String value in textbox  :"+value);
		
		}
		while(!(text.toLowerCase()).equals(value.toLowerCase()));
	}
	
	
	
}
