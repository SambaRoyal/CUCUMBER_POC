package Stepdefination;

import org.openqa.selenium.By;

import BaseTest.BaseClass;
import TestUtil.UtilsClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPage_Validations extends BaseClass {

	@Given("^verify main header$")
	public void verify_main_header() throws Throwable {
		UtilsClass util = new UtilsClass();
		properties();
		browser(prop.getProperty("url"));
		util.clickElement(By.xpath("//button[@id='main-popupclose']"), driver);
		util.clickElement(By.xpath("//a[@id='login-btn']"), driver);
		util.inputText(By.xpath("//*[@id='j_username']"), prop.getProperty("username"), driver);
		util.inputText(By.xpath("//*[@id='j_password']"), prop.getProperty("password"), driver);
		util.clickElement(By.xpath("//*[@id='login']"), driver);
		util.clickElement(By.xpath("/html/body/section/div/div[1]/div/div[8]/div/div/div/div/div/a"), driver);
		 util.clickElement(By.xpath("//button[@id='main-popupclose']"), driver);
		util.textValidations(By.xpath("//*[@id='left-search']/h1"), driver,"Getting food delivered\r\n" + 
				"is always a good idea");
		 String element = driver.findElement(By.xpath("//*[@id='content']/section[1]/h5")).getText();
		System.out.println(element);
		

	}

	@When("^verify application image$")
	public void verify_application_image() {
		/*
		 * Boolean element
		 * =driver.findElement(By.xpath("//*[@id='Navbar_1']/div/div[1]/a[1]/img")).
		 * isSelected(); System.out.println(element.toString().length());
		 */
	}

	@Then("^verify source image and address$")
	public void verify_source_image_and_address() {

	}

	@Then("^verify menu options$")
	public void verify_menu_options() {

	}

}
