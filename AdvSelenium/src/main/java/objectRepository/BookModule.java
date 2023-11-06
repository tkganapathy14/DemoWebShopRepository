package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookModule {
	public BookModule(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(linkText = "Books")
	private WebElement bookmodulelink;
	@FindBy(linkText = "Fiction")
	private WebElement FictionBook;
	@FindBy(id = "add-to-cart-button-45")
	private WebElement fictionCart;
	public WebElement getFictionCart() {
		return fictionCart;
	}
	public WebElement getBookmodulelink() {
		return bookmodulelink;
	}
	public WebElement getFictionBook() {
		return FictionBook;
	}
	@FindBy(xpath = "//input[@value='Email a friend']")
	private WebElement emailfriend;
	public WebElement getEmailfriend() {
		return emailfriend;
	}
	@FindBy(id = "FriendEmail")
	private WebElement friendemail;
	public WebElement getFriendemail() {
		return friendemail;
	}
	public WebElement getMyemail() {
		return myemail;
	}
	@FindBy(id = "YourEmailAddress")
	private WebElement myemail;
	@FindBy(name = "send-email")
	private WebElement sendmail;
	public WebElement getSendmail() {
		return sendmail;
	}
}
