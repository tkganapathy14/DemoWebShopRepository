package WishList;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtilities.BaseClass;
import genericUtilities.ItestListener;

@Listeners(ItestListener.class)
public class DWS_Wishlist_10_Test extends BaseClass {

	@Test(groups = "ST")
	public void removewishlist()
	{
		homepage.getJewellarymodule().click();;
		jewelry.getBlack_Whitediamond().click();
		jewelry.getwishlistBlack_Whitediamond().click();
		homepage.getWishlist().click();
		wishlistpage.getRemovefromwishlist().click();
		wishlistpage.getUpdatecartwishlist().click();
		String Wishlistmsg="The wishlist is empty!";
		if(driver.findElement(By.xpath("//div[@class='wishlist-content']")).getText().equals(Wishlistmsg))
		{
			System.out.println("test case is passed");
			logger.log(Status.PASS, "the test case passed");
		}
		else
		{
			System.out.println("test case is failed");
			logger.log(Status.FAIL, "the test case is failed");
		}

	}

}
