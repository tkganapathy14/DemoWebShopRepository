package WishList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import genericUtilities.BaseClass;
import genericUtilities.ItestListener;

@Listeners(ItestListener.class)
public class DWS_Wishlist_09_Test extends BaseClass {

	@Test(groups = "IT")
	public void Product_addTo_Wishlist() throws InterruptedException
	{
		homepage.getJewellarymodule().click();
		jewelry.getBlack_Whitediamond().click();
		jewelry.getwishlistBlack_Whitediamond().click();
		Thread.sleep(4000);
			String s=driver.findElement(By.xpath("//p[@class='content']")).getText();
				System.out.println(s);
		String Expmsg="The product has been added to your wishlist";
		assertEquals(driver.findElement(By.xpath("//p[@class='content']")).getText(), Expmsg);
		logger.log(Status.PASS, "Product is added to wishlist");
		homepage.getWishlist().click();
		boolean status=jewelry.getBlack_Whitediamond().isDisplayed();
		assertTrue(status);
		logger.log(Status.PASS,"the product is displayed in Wishlist");

	}
}
