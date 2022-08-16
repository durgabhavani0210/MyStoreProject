package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import base.BaseClass;
import pageObjects.HomePage;
import pageObjects.IndexPage;
import pageObjects.LoginPage;

public class SearchResultPageTest extends BaseClass {
	IndexPage index;
	LoginPage loginPage;
	HomePage home;
	Object search;


	
	@BeforeMethod
	public void setup() {
		launchApp(); 
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	public void productAvailability() throws Throwable {
		SearchResultPageTest ads=new SearchResultPageTest();
		index=new IndexPage();
		search=index.searchProduct("t shirt");
		boolean result=((pageObjects.SearchResultPage) search).isProductAvailable();
		Assert.assertTrue(result);
	}
}