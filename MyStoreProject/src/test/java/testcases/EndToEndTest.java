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
import pageObjects.AddressPage;
import pageObjects.HomePage;
import pageObjects.IndexPage;
import pageObjects.LoginPage;
import pageObjects.OrderConfirmationPage;
import pageObjects.OrderPage;
import pageObjects.OrderSummary;
import pageObjects.PaymentPage;
import pageObjects.SearchResultPage;
import pageObjects.ShippingPage;

/**
 * @author DurgaBhavaniRavilala
 *
 */
public class EndToEndTest extends BaseClass {
	IndexPage index;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	LoginPage loginPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummary odrsmry;
	OrderConfirmationPage odrcfrmPage;
	
	
	@BeforeMethod
	public void setup( ) {
		launchApp(); 
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void endToEndTest() throws Throwable {
		index=new IndexPage();
		searchResultPage=index.searchProduct("t shirts");
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("S");
		addToCartPage.clickOnAddToCart();
		orderPage=addToCartPage.clickOnCheckOut();
		loginPage=orderPage.clickOnCheckOut();
		addressPage=loginPage.login1(prop.getProperty("username"), prop.getProperty("password"), addressPage);
		shippingPage=addressPage.clickOnCheckOut();
		shippingPage.checkTheTerms();
		paymentPage=shippingPage.clickOnProceedToCheckOut();
		odrsmry=paymentPage.clickOnPaymentMethod();
		odrcfrmPage=odrsmry.clickOnconfirmOrderBtn();
		String actualmessage=odrcfrmPage.validateConfirmMessage();
		String expectedMsg="Your order on My Store is Complete.";
	
	Assert.assertEquals(actualmessage, expectedMsg);
	
	}

}
