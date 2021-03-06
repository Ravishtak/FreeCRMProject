package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest(){
		super();
		}

	@BeforeMethod
	public void setUp(){
		initiallation();
		testUtil= new TestUtil();
		contactsPage= new ContactsPage();
		 loginPage= new LoginPage();
		 homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));	 
	}
	
	@Test(priority=1)
		public void verifyHomePageTitle(){
		String HomePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(HomePageTitle, "CRMPRO","Home Page title not match");
	}
	@Test(priority=2)
	public void VerifyUserNameTest(){
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyUserName());
		}
	@Test(priority=3)
	public void verifyContactsLinkTest(){
		testUtil.switchToFrame();
		contactsPage=homePage.clickOnContactLink();
		}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
