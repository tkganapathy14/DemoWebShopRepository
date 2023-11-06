package Signup;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtilities.BaseClass;
import genericUtilities.ItestListener;

@Listeners(ItestListener.class)
public class DWS_Register_02_Test extends BaseClass{

	@Test(groups = "FT")
	public void Register_to_the_application_with_valid_credentials()
	{
		registerpage.getRegisterlink().click();
		logger.log(Status.INFO,"user click on register link");
		registerpage.getGendermale().click();
		logger.log(Status.INFO,"user clicked on radio button");
		registerpage.getFirstname().sendKeys("T K ");
		logger.log(Status.INFO,"user entered firstName");
		registerpage.getLastname().sendKeys("Ganapathy");
		logger.log(Status.INFO,"user entered LastName");
		registerpage.getSignupemail().sendKeys("tkganapathy16@gmail.com");
		logger.log(Status.INFO,"user entered Email Id");
		registerpage.getSignuppassword().sendKeys("123456");
		logger.log(Status.INFO,"user entered password");
		registerpage.getCNFsignuppassword().sendKeys("123456");
		logger.log(Status.INFO,"user entered Confirm password");
		registerpage.getRegisterButton().click();
		logger.log(Status.INFO,"user clicked on register Button");
		String exptitle="Demo Web Shop. Register";
		String title=driver.getTitle();
		System.out.println(title);
	}

}
