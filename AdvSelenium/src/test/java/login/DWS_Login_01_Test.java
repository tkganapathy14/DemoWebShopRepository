package login;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtilities.BaseClass;
import genericUtilities.ExcelUtility;
import genericUtilities.ItestListener;
@Listeners(ItestListener.class)
public class DWS_Login_01_Test extends BaseClass {

	@Test(groups = "FT",dataProvider = "data",dataProviderClass = ExcelUtility.class)
	public void login_to_Application_with_valid_credentials(String email,String password)
	{
		loginpage.getLoginlink().click();
		logger.log(Status.INFO,"user click on login link");
		loginpage.getEmailTF().sendKeys(email);
		logger.log(Status.INFO, "user entered email address");
		loginpage.getPasswordTF().sendKeys(password);
		logger.log(Status.INFO,"user entered password ");
		loginpage.getLoginButton().click();
		webdriverutility.returnAlertreference().accept();
	}
	
}
