package TestUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilsClass {
	
	public void clickElement(By element, WebDriver driver) {
	new WebDriverWait(driver, 60, 500).until(ExpectedConditions.presenceOfElementLocated(element));
		driver.findElement(element).click();
		System.out.println(element);
		
	}
	
	public void inputText(By element , String text , WebDriver driver) {
		
		
		
	}
	
	
	
}
