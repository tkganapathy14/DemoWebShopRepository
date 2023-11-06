package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishlistPage {
public WishlistPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(name = "removefromcart")
private WebElement removefromwishlistCheckbox;
//@FindBy(name="updatecart")
@FindBy(xpath = "//input[@value='Update wishlist']")
private WebElement updatecartwishlist;
public WebElement getRemovefromwishlist() {
	return removefromwishlistCheckbox;
}
public WebElement getUpdatecartwishlist() {
	return updatecartwishlist;
}
}
