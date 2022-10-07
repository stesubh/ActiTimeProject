package myhybridframeworkv1.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement usernameTF;
	
	@FindBy(name = "pwd")
	private WebElement passwordTF;
	
	@FindBy(id="keepLoggedInCheckBoxContainer")
	private WebElement keepLoginCB;
	
	@FindBy(id="loginButtonContainer")
	private WebElement loginButton;
	
	public WebElement getUsernameTF() {
		return usernameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getKeepLoginCB() {
		return keepLoginCB;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public void loggingIN(String username, String password) {
		getUsernameTF().sendKeys(username);
		getPasswordTF().sendKeys(password);
		getKeepLoginCB().click();
		getLoginButton().click();
	}
}