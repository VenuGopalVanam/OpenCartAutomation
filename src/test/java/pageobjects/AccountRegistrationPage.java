package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
@FindBy(xpath = "//input[@id='input-firstname']")
private WebElement txtfirstname;
@FindBy(xpath = "//input[@id='input-lastname']")
private WebElement txtlastname;
@FindBy(xpath = "//input[@id='input-email']")
private WebElement txtemail;
@FindBy(xpath = "//input[@id='input-telephone']")
private WebElement txttelephone;
@FindBy(xpath = "//input[@id='input-password']")
private WebElement txtpassword;
@FindBy(xpath = "//input[@id='input-confirm']")
private WebElement txtconfpassword;
@FindBy(xpath = "//input[@type='checkbox']")
private WebElement chkprivacy;
@FindBy(xpath = "//input[@type='submit']")
private WebElement btncontinue;
@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgConfirmation;

public void enterFirstName(String fname) {
	txtfirstname.sendKeys(fname);
}
public void enterLastName(String lname) {
	txtlastname.sendKeys(lname);
}
public void enterEmail(String email) {
	txtemail.sendKeys(email);
}
public void enterTelephone(String num) {
	txttelephone.sendKeys(num);
}
public void enterPassword(String pass) {
	txtpassword.sendKeys(pass);
}
public void enterconfPassword(String cpass) {
	txtconfpassword.sendKeys(cpass);
}
public void clickChecbox() {
	chkprivacy.click();
}
public void clickSubmit() {
	btncontinue.click();
}
public String getConfirmationMsg() {
	try {
		return (msgConfirmation.getText());
	} catch (Exception e) {
		return (e.getMessage());

	}
}
}
