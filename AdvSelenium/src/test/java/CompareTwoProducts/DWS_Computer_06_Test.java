package CompareTwoProducts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtilities.BaseClass;
import genericUtilities.ItestListener;
@Listeners(ItestListener.class)
public class DWS_Computer_06_Test extends BaseClass{
	@Test(groups = "ST")
	
	public void RemoveComparelist()
	{

		homepage.getComputermodule().click();
		computer.getDesktopitems().click();
		computer.getCheapcomputer().click();
		computer.getProductcomparelist().click();
		driver.navigate().back();
		driver.navigate().back();
		computer.getOwncomputer().click();
		computer.getProductcomparelist().click();
		List<WebElement> remove = driver.findElements(By.xpath("//input[@value='Remove']"));
		//List<WebElement> remove=(List<WebElement>) computer.getRemovebutton();
		System.out.println(remove.size());
		for(WebElement element:remove)
		{
			try
			{
			element.click();
			}
			catch(StaleElementReferenceException e)	
			{
				element=driver.findElement(By.xpath("//input[@value='Remove']"));
				element.click();
			e.getMessage();	
			}
		}
		String msg="You have no items to compare.";
		if(driver.findElement(By.xpath("//div[@class='page-body']")).equals(msg))
		{
			System.out.println("product is removed from compare list");
			logger.log(Status.PASS, "the testcase is passed");
		}
		else
		{
			System.out.println("product is not removed from compare list");
			logger.log(Status.FAIL, "the testcase is failed");
		}
	}

}
