/**
 * 
 */
package testcases;

import org.testng.Assert; 
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;






import actionDriver.Action;
import base.BaseClass;
import pageObjects.HomePage;
import pageObjects.IndexPage;
import pageObjects.LoginPage;

/**
 * @author DurgaBhavaniRavilala
 *
 */
public class HomePageTest extends BaseClass {
	IndexPage indexPage;
	 LoginPage loginPage;
	 HomePage home;
	 Action a=new Action(); 
	@BeforeMethod
	public void setup() {
		launchApp(); 
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void wishListTest() throws Throwable {
		//Log.startTestCase("wishListTest");
		indexPage= new IndexPage();
		new HomePageTest();
		home=new HomePage();
		loginPage=indexPage.clickOnSignIn();
		home=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		home= new HomePage();
		boolean result1=home.validateMyWishList();
		Assert.assertTrue(result1);
		
	}
	
	
	
	@Test
	public void orderHistoryandDetailsTest() throws Throwable {
		
		indexPage= new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		home=loginPage.login(null, null);
		boolean result=home.validateOrderHistory();
		Assert.assertFalse(result);
		
	}
	
}

