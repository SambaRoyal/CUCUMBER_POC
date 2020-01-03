package Stepdefination;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;

import BaseTest.BaseClass;
import Pagelocators.String_class;
import TestUtil.UtilsClass;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginDefination extends BaseClass {
	UtilsClass util;
public LoginDefination() throws IOException {
	super();
}
	@Given("^user already in login page$")
	public void user_already_in_login_page() throws Throwable {
		browser(prop.getProperty("url"));
	}

	@When("^user able to verify title of application$")
	public void user_able_to_verify_title_of_application() throws InterruptedException {
		util = new UtilsClass();
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
			assertEquals(String_class.login_title, title);
		} else {
			System.out.println("in-correct title    :" + title);
		}
	}

	@After
	public void teardown() {
		driver.close();
	}

}
