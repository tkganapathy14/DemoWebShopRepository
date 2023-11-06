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
public class DWS_AddToCart_03_Test extends BaseClass{
	@Test(groups = "IT")
	public void Add_Product_to_AddtoCart() throws InterruptedException {
		webdriverutility.ActionReference().moveToElement(homepage.getLaptop()).perform();
		homepage.getLaptop().click();
		homepage.getLaptopAddToCart().click();
		String Exptitle="Demo Web Shop. 14.1-inch Laptop";
		assertEquals(driver.getTitle(), Exptitle);
		logger.log(Status.PASS,"the product Title page is passed");
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
//		boolean value=driver.findElement(By.linkText("14.1-inch Laptop")).isDisplayed();
//		assertTrue(value);
//		logger.log(Status.INFO,"the product is displayed");
	}



}
