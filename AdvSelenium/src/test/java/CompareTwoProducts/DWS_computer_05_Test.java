package CompareTwoProducts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import genericUtilities.BaseClass;
import genericUtilities.ItestListener;

@Listeners(ItestListener.class)
public class DWS_computer_05_Test extends BaseClass {
	@Test(groups ="IT")
	public void Comparetwoproducts()
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
		int count=remove.size();
		if(count==2)
		{
			logger.log(Status.PASS,"test case is passed");
		}
		else
		{
			logger.log(Status.FAIL,"the test case is failed");
		}
	}
}
