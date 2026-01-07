package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	
	

public HomePage(WebDriver driver) {
		super(driver);
	}
@FindBy(xpath = "//span[text()='My Account']")
private WebElement myaccount;
@FindBy(xpath = "//a[text()='Register']")
private WebElement register;
@FindBy(linkText = "Login")
private WebElement linklogin;


public void clickmyaccount() {
	myaccount.click();
	
}
public void clickregister() {
	register.click();
}
public void clicklogin() {
	linklogin.click();
}
}

