package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JewellaryPage {

	public JewellaryPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@href='https://demowebshop.tricentis.com/jewelry?price=0-500']")
	private WebElement priceRange0to500;
	public WebElement getPriceRange0to500() {
		return priceRange0to500;
	}
	@FindBy(xpath = "//div[@class='prices']")
	private WebElement allprices;
	public WebElement getAllprices() {
		return allprices;
	}
	@FindBy(linkText = "Black & White Diamond Heart")
	private WebElement Black_Whitediamond;
	public WebElement getBlack_Whitediamond() {
		return Black_Whitediamond;
	}
	@FindBy(id="add-to-wishlist-button-14")
	private WebElement wishlistBlack_Whitediamond;
	public WebElement getwishlistBlack_Whitediamond() {
		return wishlistBlack_Whitediamond;
	}
}
