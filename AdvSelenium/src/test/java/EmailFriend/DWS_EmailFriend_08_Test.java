package EmailFriend;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtilities.BaseClass;
import genericUtilities.ItestListener;

@Listeners(ItestListener.class)
public class DWS_EmailFriend_08_Test extends BaseClass {

	@Test(groups = "FT")
	public void EmailFriend()
	{
		bookpage.getBookmodulelink().click();
		bookpage.getFictionBook().click();
		bookpage.getEmailfriend().click();
		bookpage.getFriendemail().sendKeys("gana@gmail.com");
		bookpage.getMyemail().sendKeys("tkganapathy16@gmail.com");
		bookpage.getSendmail().click();

		String Errmsg="Only registered customers can use email a friend feature";
		assertEquals(driver.findElement(By.xpath("//div[@class='validation-summary-errors']")).getText(), Errmsg);
		logger.log(Status.PASS, "the test case is passed");
	}
}
