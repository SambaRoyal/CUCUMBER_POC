package Stepdefination;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;

import BaseTest.BaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pagelocators.StringUtil;
import testUtil.Utils;


public class LoginDefination extends BaseClass {

	
	public LoginDefination() throws IOException {
		super();
	}
	public Utils util;

	@Given("^user already in login page$")
	public void user_already_in_login_page() throws Throwable {
		browser(prop.getProperty("url"));
	}

	@When("^user able to verify title of application$")
	public void user_able_to_verify_title_of_application() throws InterruptedException {
		util = new Utils();
		util.clickElement(By.xpath("//button[@id='main-popupclose']"), driver);
		util.clickElement(By.xpath("//a[@id='login-btn']"), driver);
	}

	@Then("^user enters username$")
	public void user_enters_username() {
		util.inputText(By.xpath("//*[@id='j_username']"), prop.getProperty("username"), driver);
	}

	@Then("^user enters password$")
	public void user_enters_password() {
		util.inputText(By.xpath("//*[@id='j_password']"), prop.getProperty("password"), driver);
		util.clickElement(By.xpath("//*[@id='login']"), driver);
		String title = driver.getTitle();
		if (title.contains("LetMeCall")) {
			assertEquals(StringUtil.login_title, title);
		} else {
			System.out.println("in-correct title    :" + title);
		}
	}

	/*
	 * @Given("^user already in login page$") public void
	 * user_already_in_login_page() { browser(prop.getProperty("url")); }
	 * 
	 * @When("^user able to verify title of application$") public void
	 * user_able_to_verify_title_of_application() { util = new Utils();
	 * util.clickElement(By.xpath("//button[@id='main-popupclose']"), driver);
	 * util.clickElement(By.xpath("//a[@id='login-btn']"), driver); }
	 * 
	 * @Then("^user enters username$") public void user_enters_username() {
	 * util.inputText(By.xpath("//*[@id='j_username']"),
	 * prop.getProperty("username"), driver); }
	 * 
	 * @Then("^user enters password$") public void user_enters_password() {
	 * util.inputText(By.xpath("//*[@id='j_password']"),
	 * prop.getProperty("password"), driver);
	 * util.clickElement(By.xpath("//*[@id='login']"), driver); String title =
	 * driver.getTitle(); if (title.contains("LetMeCall")) {
	 * assertEquals(StringUtil.login_title, title); } else {
	 * System.out.println("in-correct title    :" + title); } }
	 * 
	 * @After public void teardown() { driver.close(); }
	 */
}
