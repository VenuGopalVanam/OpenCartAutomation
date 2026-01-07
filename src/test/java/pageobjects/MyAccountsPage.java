package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountsPage  extends BasePage{

	public MyAccountsPage(WebDriver driver) {
		super(driver);
	}
@FindBy(xpath = "//h2[text()='My Account']")
private WebElement msgHeading;
@FindBy(linkText = "Logout")
private WebElement linklogout;


public boolean ismyaccountpageExists() {
	try {
		return (msgHeading.isDisplayed());
	}
	catch(Exception e) {
		return false;
	}
	
}
public void clickLogout() {
	linklogout.click();
}
}
