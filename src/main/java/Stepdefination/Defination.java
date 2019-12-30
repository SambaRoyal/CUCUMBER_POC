package Stepdefination;

import org.openqa.selenium.By;

import BaseTest.BaseClass;
import TestUtil.UtilsClass;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defination extends BaseClass {
	@Given("^user already in login page$")
	public void user_already_in_login_page() throws Throwable{ 
		properties();
		browser(prop.getProperty("url"));
	}
	
	@When("^user able to verify title of application$")
	public void user_able_to_verify_title_of_application() throws InterruptedException {
	UtilsClass util=new UtilsClass();
	Thread.sleep(5000);
	util.clickElement(By.xpath("//button[@id='main-popupclose']"), driver);
	}

	@Then("^user enters username$")
	public void user_enters_username()  {
	  
	}

	@Then("^user enters password$")
	public void user_enters_password()  {
	    
	
	}
	@After
	public void teardown() {
		driver.close();
	}
	
}
