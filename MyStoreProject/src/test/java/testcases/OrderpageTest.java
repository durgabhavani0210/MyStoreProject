/**
 * 
 */
package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.AddToCartPage;
import pageObjects.HomePage;
import pageObjects.IndexPage;
import pageObjects.LoginPage;
import pageObjects.OrderPage;
import pageObjects.SearchResultPage;

/**
 * @author DurgaBhavaniRavilala
 *
 */
public class OrderpageTest extends BaseClass {
	IndexPage index;
	SearchResultPage srp;
	AddToCartPage addtocart;
	OrderPage orderpage;

	@BeforeMethod
	public void setup( ) {
		launchApp(); 
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void VerifyTotalPrice() throws Throwable {
		index=new IndexPage();
		srp=index.searchProduct("t shirts");
		
		addtocart=srp.clickOnProduct();
		addtocart.enterQuantity("2");
		addtocart.selectSize("S");
		addtocart.clickOnAddToCart();
		boolean res=addtocart.validateAddtoCart();
		Assert.assertTrue(res);
		orderpage=addtocart.clickOnCheckOut();
		Double TotalPrice=orderpage.getTotalPrice();
		Double unitPrice =orderpage.getUnitPrice();
		Double totalExpectedPrice=(unitPrice*2)+2;
		Assert.assertEquals(TotalPrice, totalExpectedPrice);
	}
		
		
	}
