package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement txtUsername;
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement txtPassword;
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement btnlogin;

   public void setUsername(String user) {
	   txtUsername.sendKeys(user);
   }
   public void setPassword(String pass) {
	   txtPassword.sendKeys(pass);
   }
   public void clicklogin() {
	   btnlogin.click();
   }

}
