/**
 * 
 */
package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.Action;
import base.BaseClass;

/**
 * @author DurgaBhavaniRavilala
 *
 */
public class LoginPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(id="email")
	private WebElement userName;
	
	@FindBy(id="passwd")
	private WebElement password;

	@FindBy(id="SubmitLogin")
	private WebElement signInBtn;
	
	@FindBy(name="email_create")
	private WebElement emailForNewAccount;
	
	@FindBy(name="SubmitCreate")
	private WebElement createNewAccountBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String uname, String pswd) throws Throwable {
		
		action.scrollByVisibilityOfElement(driver, userName);
		action.type(userName, uname);
		action.type(password, pswd);
		action.JSClick(driver, signInBtn);
		Thread.sleep(2000);
		
		return new HomePage();
	}
	
	public AddressPage login1(String uname,String pswd,AddressPage addresPage) throws Throwable {
		
		action.scrollByVisibilityOfElement(driver, userName);
		action.type(userName, uname);
		action.type(password, pswd);
		action.click(driver, signInBtn);
		Thread.sleep(2000);
		
		
		return new AddressPage(); 
	}
	
	public AccountCreationPage createNewAccount(String newEmail) throws Throwable {
		action.type(emailForNewAccount, newEmail);
		action.click(driver, createNewAccountBtn);
		return new AccountCreationPage();
	}
	
}




