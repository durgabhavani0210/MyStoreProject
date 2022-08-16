/**
 * 
 */
package testcases;


import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.IndexPage;

/**
 * @author DurgaBhavaniRavilala
 *
 */
public class IndexPageText extends BaseClass {
	IndexPage indexPage;

	
	@BeforeMethod
	public void setup() {
		launchApp(); 
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	@Test
	
	public void VerifyLogo() throws Throwable {
		indexPage  = new IndexPage();
		boolean resul=indexPage.validateLogo();
		Assert.assertTrue(resul);
	}
	@Test
	
	public void VerifyTitle() {
		String actTitle=indexPage.getMyStoreTitle();
		Assert.assertEquals(actTitle, "My Store");	
		}
	}






