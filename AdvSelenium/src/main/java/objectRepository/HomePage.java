package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
	PageFactory.initElements(driver,this);
	}
	@FindBy(linkText = "14.1-inch Laptop")
	private WebElement Laptop;
	public WebElement getLaptop() {
		return Laptop;
	}
	
	@FindBy(id = "add-to-cart-button-31")
	private WebElement LaptopAddToCart;
	public WebElement getLaptopAddToCart() {
		return LaptopAddToCart;
	}
	@FindBy(id = "small-searchterms")
	private WebElement searchboxTF;
	public WebElement getSearchboxTF() {
		return searchboxTF;
	}
	@FindBy(linkText = "Computers")
	private WebElement computermodule;
	public WebElement getComputermodule() {
		return computermodule;
	}
	@FindBy(linkText = "Jewelry")
	private WebElement jewellarymodule;
	public WebElement getJewellarymodule() {
		return jewellarymodule;
	}
	@FindBy(linkText = "Wishlist")
	private WebElement wishlist;
	public WebElement getWishlist() {
		return wishlist;
	}
}
