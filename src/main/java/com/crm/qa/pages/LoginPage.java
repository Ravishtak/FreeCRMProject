package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	
	//Page Factory -OR
	@FindBy(name ="username")
	WebElement username ;
	
	@FindBy(name="password")
	WebElement password ;
	
	@FindBy(css="input.btn.btn-small")
	WebElement submitBtn;

	@FindBy(xpath="//button[contains(text(),'Sign-Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	//Intialisazation the page objects
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	//Actions
	public String validateloginpagetitle(){
		return driver.getTitle();
	}
	
	public boolean validatelogoimage(){
		return crmLogo.isDisplayed();
	}
	public HomePage login(String un, String pwd){
		
		//WebDriverWait d=new WebDriverWait(driver, 9000);
		username.sendKeys(un);
		password.sendKeys(pwd);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		//d.until(ExpectedConditions.elementToBeClickable(submitBtn));
		submitBtn.click();
		
		return new HomePage();
	}
}
