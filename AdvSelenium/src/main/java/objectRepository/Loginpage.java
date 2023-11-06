package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	public Loginpage(WebDriver driver) {

		PageFactory.initElements(driver,this);
	}
	public WebElement getLoginlink() {
		return loginlink;
	}
	public WebElement getEmailTF() {
		return emailTF;
	}
	public WebElement getPasswordTF() {
		return passwordTF;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}

	@FindBy(linkText = "Log in")
	private WebElement loginlink;
	@FindBy(id = "Email")
	private WebElement emailTF;
	@FindBy(id = "Password")
	private WebElement passwordTF;
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement loginButton;
		
}
