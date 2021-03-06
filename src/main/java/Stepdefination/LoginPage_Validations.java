package Stepdefination;

import java.io.IOException;

import org.openqa.selenium.By;

import BaseTest.BaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pagelocators.StringUtil;
import testUtil.Utils;

public class LoginPage_Validations extends BaseClass {

	public LoginPage_Validations() throws IOException {
		super();
	}

	Utils util;

	@Given("^verify main header$")
	public void verify_main_header() throws Throwable {
		util = new Utils();
		// browser(prop.getProperty("url"));
		browser_initialization("Chrome", prop.getProperty("url"));
		util.clickElement(By.xpath("//button[@id='main-popupclose']"), driver);
		util.clickElement(By.xpath("//a[@id='login-btn']"), driver);
		util.inputText(By.xpath("//*[@id='j_username']"), prop.getProperty("username"), driver);
		util.inputText(By.xpath("//*[@id='j_password']"), prop.getProperty("password"), driver);
		util.clickElement(By.xpath("//*[@id='login']"), driver);

	}

	@When("^verify application image$")
	public void verify_application_image() {
		util.clickElement(By.xpath("/html/body/section/div/div[1]/div/div[8]/div/div/div/div/div/a"), driver);

		util.clickElement(By.xpath("//button[@id='main-popupclose']"), driver);

		util.textValidations(By.xpath("//*[@id='content']/div[2]/span"), driver, StringUtil.Offer_text);

		driver.findElement(By.xpath("//div[@class='features-icons-item']")).isDisplayed();
	}

	@Then("^verify source image and address$")
	public void verify_source_image_and_address() {
		util.textValidations(By.xpath("//*[@id='content']/section[2]/div/div[2]/div[1]/p[1]"), driver,
				StringUtil.Team_Up_with_LetMeCall);
		util.textValidations(By.xpath("//*[@id='content']/section[2]/div/div[2]/div[2]/p[1]"), driver,
				StringUtil.Deliver_with_LetMeCall);
		util.textValidations(By.xpath("//*[@id='wrapper']/footer/div/div/div[1]/p[1]"), driver, StringUtil.About_us);
		util.textValidations(By.xpath("//*[@id='wrapper']/footer/div/div/div[2]/div/p[1]"), driver,
				StringUtil.Contact_us);

	}

	@Then("^verify menu options$")
	public void verify_menu_options() {
		util.imageValidation(By.xpath("//img[@class='img-fluid mb-3'][1]"), driver);
	}

}
