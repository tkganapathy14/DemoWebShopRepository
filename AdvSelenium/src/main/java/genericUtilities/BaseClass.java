package genericUtilities;

import java.sql.DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.BookModule;
import objectRepository.ComputerPage;
import objectRepository.HomePage;
import objectRepository.JewellaryPage;
import objectRepository.Loginpage;
import objectRepository.RegisterPage;
import objectRepository.ShoppingCart;
import objectRepository.WishlistPage;

public class BaseClass implements Iautoconstants {
	public static WebDriver driver;
	public static TakesScreenshotUtility screenshot;
	public static webdriverutility webdriverutility;
	public static ExtentTest logger;
	public static Loginpage loginpage;
	public static RegisterPage registerpage;
	public static HomePage homepage;
	public static BookModule bookpage;
	public static ShoppingCart shoppingcart;
	public static ComputerPage computer;
	public static JewellaryPage jewelry;
	public static WishlistPage wishlistpage;
	propertyUtility property;
	databaseUtility dbutility;
	javaUtility javaUtility;
	ExcelUtility excelUtility;
	//	public static TakesScreenshotUtility utility;
	//	@BeforeMethod
	//	public static void demo() {
	//		WebDriverManager.chromedriver().setup();
	//		ChromeOptions options=new ChromeOptions();
	//		options.addArguments("--remote-allow-origins=*");
	//
	//		driver=new ChromeDriver(options);
	//		driver.manage().window().maximize();
	//		utility=new TakesScreenshotUtility(driver);
	//	}
	/**
	 * this method is used to launching browser given by users
	 */
	@BeforeClass(alwaysRun = true)
	public void LaunchingbrowsertoApplication() 
	{
		property=new propertyUtility();
		
		
		if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");

			driver=new ChromeDriver(options);
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();

		}
		driver.manage().window().maximize();
		driver.get(property.getdatafromPropertyfile("Url"));
		screenshot=new TakesScreenshotUtility(driver);
		webdriverutility=new webdriverutility(driver);
		dbutility=new databaseUtility();
		javaUtility=new javaUtility();
		excelUtility=new ExcelUtility();
				
	}
	/**
	 * this method is used to navigate login into application
	 */
	@BeforeMethod(alwaysRun = true)
	public void navigateLogainapp()
	{
		loginpage=new Loginpage(driver);
		registerpage=new RegisterPage(driver);
		homepage=new HomePage(driver);
		bookpage=new BookModule(driver);
		shoppingcart=new ShoppingCart(driver);
		jewelry=new JewellaryPage(driver);
		wishlistpage=new WishlistPage(driver);
		computer=new ComputerPage(driver);
		System.out.println("Logged in to application");
	}
	/**
	 * this method is used to logout an application
	 */
	@AfterMethod(alwaysRun = true)
	public void Logoutapp()
	{
		System.out.println("Logged out from application");
	}
	/**
	 * this method is used to close the application
	 */
	@AfterClass(alwaysRun = true)
	public void Teardownapp()
	{
		
		driver.quit();
	}

}
