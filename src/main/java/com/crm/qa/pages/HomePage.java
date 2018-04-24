package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'User: Naveen K')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	//to initialize the objects
	public HomePage(){
		PageFactory.initElements(driver, this);		
	}
	//Actions
	
	public String verifyHomePageTitle(){
		return 	driver.getTitle();		
	}
	public boolean verifyUserName(){
		return userNameLabel.isDisplayed();
	}
	public ContactsPage clickOnContactLink(){
		contactsLink.click();
		return new ContactsPage();
	}
	public DealsPage clickOnDealsLink(){
		dealsLink.click();
		return new DealsPage();
	}
	public TasksPage clickOnTasksLink(){
		tasksLink.click();
		return new TasksPage();
	}
	
}
