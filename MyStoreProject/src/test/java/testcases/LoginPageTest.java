/**
 * 
 */
package testcases;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.HomePage;
import pageObjects.IndexPage;
import pageObjects.LoginPage;
import utility.Log;

/**
 * @author DurgaBhavaniRavilala
 *
 */
public class LoginPageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage home;

	@BeforeMethod
	public void setup() {
		launchApp(); 
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}	
	@Test
	public void loginTest() throws Throwable {
		Log.startTestCase("loginTest");
		indexPage= new IndexPage();
		
		loginPage=indexPage.clickOnSignIn();
	
		home=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//home=loginPage.login(uname,pswd);
		String actualURL=home.getCurrURL();
		String expectedURL="http://automationpractice.com/index.php?controller=my-account";

		Assert.assertEquals(actualURL, expectedURL);

	}
}

