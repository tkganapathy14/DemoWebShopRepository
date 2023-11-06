package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText = "Register")
	private WebElement registerlink;
	@FindBy(id = "gender-male")
	private WebElement gendermale;
	@FindBy(id = "gender-female")
	private WebElement genderfemale;
	@FindBy(id = "FirstName")
	private WebElement firstname;
	@FindBy(id = "LastName")
	private WebElement lastname;
	@FindBy(id = "Email")
	private WebElement signupemail;
	@FindBy(id = "Password")
	private WebElement signuppassword;
	@FindBy(id = "ConfirmPassword")
	private WebElement CNFsignuppassword;
	@FindBy(id = "register-button")
	private WebElement RegisterButton;
	public WebElement getRegisterlink() {
		return registerlink;
	}
	public WebElement getGendermale() {
		return gendermale;
	}
	public WebElement getGenderfemale() {
		return genderfemale;
	}
	public WebElement getFirstname() {
		return firstname;
	}
	public WebElement getLastname() {
		return lastname;
	}
	public WebElement getSignupemail() {
		return signupemail;
	}
	public WebElement getSignuppassword() {
		return signuppassword;
	}
	public WebElement getCNFsignuppassword() {
		return CNFsignuppassword;
	}
	public WebElement getRegisterButton() {
		return RegisterButton;
	}
}
