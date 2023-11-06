package AddToCart;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtilities.BaseClass;
import genericUtilities.ItestListener;
@Listeners(ItestListener.class)
public class DWS_Books_04_Test extends BaseClass {

	@Test(groups = "IT")
	public void Add_Books_Product_to_add_the_cart()
	{
		loginpage.getLoginlink().click();
		logger.log(Status.INFO,"user click on login link");
		loginpage.getEmailTF().sendKeys("tkganapathy16@gmail.com");
		logger.log(Status.INFO, "user entered email address");
		loginpage.getPasswordTF().sendKeys("123456");
		logger.log(Status.INFO,"user entered password ");
		loginpage.getLoginButton().click();
		webdriverutility.returnAlertreference().accept();
		bookpage.getBookmodulelink().click();
		logger.log(Status.INFO,"the book module is clicked");
		bookpage.getFictionBook().click();
		logger.log(Status.INFO,"the book is clicked");
	
		String productpage="Demo Web Shop. Fiction";
		assertEquals(driver.getTitle(), productpage);
		logger.log(Status.PASS,"the product page is Displayed");
		bookpage.getFictionCart().click();
		shoppingcart.getShoppingcartbutton().click();
		logger.log(Status.INFO,"the product is added to Cart");
		boolean status=bookpage.getFictionBook().isDisplayed();
		assertTrue(status);
		logger.log(Status.PASS,"the product is displayed in cart");
	}

}
