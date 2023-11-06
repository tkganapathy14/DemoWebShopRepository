package FilterPrice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtilities.BaseClass;
import genericUtilities.ItestListener;

@Listeners(ItestListener.class)
public class DWS_Jewellary_07_Test extends BaseClass {

	@Test(groups = "ST")
	public void JewelryfilterPriceRange()
	{
		homepage.getJewellarymodule().click();
		jewelry.getPriceRange0to500().click();
		List<WebElement> allprices = driver.findElements(By.xpath("//div[@class='prices']"));;
		for(WebElement price:allprices)
		{
			String p = price.getText();
			String e = p.substring(0,p.length()-3);
			//System.out.println(p);
		System.out.println(e);
			int pr=Integer.parseInt(e);
			if(pr>=0 && pr<=500)
			{
				logger.log(Status.PASS,"this test case is passed");
				System.out.println("the price range is between 0-500 : "+pr);
			}
			else
			{
				System.out.println("the price range is not between 0-500 : "+pr);
				logger.log(Status.FAIL,"this test case is failed");
				
			}
		}
	}
}
