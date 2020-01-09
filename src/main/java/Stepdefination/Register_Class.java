package Stepdefination;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;

import BaseTest.BaseClass;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pagelocators.StringUtil;
import testUtil.Utils;

public class Register_Class extends BaseClass {
	public Register_Class() throws IOException {
		super();
	}

	Utils util;

	@Given("^user is ready to enter the details$")
	public void user_is_ready_to_enter_the_details() throws Throwable {
		browser(prop.getProperty("url"));
		util = new Utils();
		util.clickElement(By.xpath("//button[@id='main-popupclose']"), driver);
		util.clickElement(By.xpath("//*[@id='signup-btn']"), driver);
		String ti = driver.getTitle();
		System.out.println("SIGNUP PAGE TITLE   :" + ti);
		assertTrue(ti, true);
	}

	@When("^enter user name and email$")
	public void enter_user_name_and_email() {
		util.inputText(By.xpath("//*[@id='firstName']"), prop.getProperty("firstname"), driver);
		util.inputText(By.xpath("//*[@id='emailAddress']"), prop.getProperty("email"), driver);
		util.inputText(By.xpath("//*[@id='phoneNo']"), prop.getProperty("phoneno"), driver);
	}

	@Then("^enter the password and zipcode$")
	public void enter_the_password_and_zipcode() {
		util.inputText(By.xpath("//*[@id='password']"), prop.getProperty("password"), driver);
		util.inputText(By.xpath("//*[@id='zipcode']"), prop.getProperty("zipcode"), driver);

	}

	@Then("^signup to application$")
	public void signup_to_application() {
		util.clickElement(By.xpath("//*[@id='bt_signup']"), driver);
		util.verifyingToolTip(By.xpath("//*[@id='emailAddress']"), driver);
		String ele = driver.findElement(By.xpath("//*[@class='tooltip fade top in']")).getText();
		System.out.println("TOOLTIP STRING VALUE   :" + ele);
		if (ele.equals(StringUtil.tooltip_value)) {
			util.clickElement(By.xpath("//a[@id='login-btn']"), driver);
			util.inputText(By.xpath("//*[@id='j_username']"), prop.getProperty("username"), driver);
			util.inputText(By.xpath("//*[@id='j_password']"), prop.getProperty("password"), driver);
			util.clickElement(By.xpath("//*[@id='login']"), driver);

		}
	}

	@After
	public void teardown() {
		driver.close();
	}
}
