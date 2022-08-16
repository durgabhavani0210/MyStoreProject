package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.AddToCartPage;
import pageObjects.IndexPage;
import pageObjects.SearchResultPage;

public class AddToCart extends BaseClass{

    IndexPage index;
    SearchResultPage searchResultPage;
    AddToCartPage addToCartPage;

    @Parameters("browser")
    @BeforeMethod
    public void setup() {
        launchApp(); 
    }

    @AfterMethod
    public void tearDown() {
    	driver.quit();
    }

    @Test
    public void addToCartTest() throws Throwable {
     //   Log.startTestCase("addToCartTest");
        index= new IndexPage();
        searchResultPage=index.searchProduct("t-shirt");
        addToCartPage=searchResultPage.clickOnProduct();
        addToCartPage.enterQuantity("2");
        addToCartPage.selectSize("M");
        addToCartPage.clickOnAddToCart();
        boolean result=addToCartPage.validateAddtoCart();
        Assert.assertTrue(result);
        //Log.endTestCase("addToCartTest");

    }

}