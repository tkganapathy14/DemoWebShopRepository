package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webdriverutility {
	//this class is used to perform javascript,action class,select class,iframe,popup methods
	//new method
	WebDriver driver;
	JavascriptExecutor js;
	TakesScreenshot ss;
	public webdriverutility(WebDriver driver)
	{
		this.driver=driver;
		js=(JavascriptExecutor) driver;
		ss=(TakesScreenshot) driver;
	}
	/**
	 * this method is used to click on element by using Javascript executor
	 * @param element
	 * 
	 */
	public void clickonElement(WebElement element)
	{
		js.executeScript("arguments[0].click();",element);		
	}
	/**
	 * this method is used to enter the data by using Javascript executor
	 * @param element
	 * @param data which has to enter to element
	 */
	public void enteringvalue(WebElement element,String data)
	{
		js.executeScript("arguments[0].value='"+data+"'", element);
	}
	//old method
	//	public void clickonElement(WebDriver driver,WebElement element)
	//	{
	//		JavascriptExecutor js=(JavascriptExecutor) driver;
	//		js.executeScript("arguments[0].click();",element);
	//	}

	public WebDriverWait explicitlywait(int time)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time));
		return wait;
	}
	/**
	 * this method is used to perform action class methods
	 * @return
	 */
	public Actions ActionReference()
	{
		Actions action=new Actions(driver);
		return action;
	}
	/**
	 * this method is used to handle the dropdown single or multi select
	 * @param dropdown
	 * @param value
	 */
	public void handlingDropdown(WebElement dropdown,String value)
	{
		Select select=new Select(dropdown);
		try {
			select.selectByVisibleText(value);
		}
		catch(Exception e){
			try
			{
				select.selectByValue(value);
			}
			catch(Exception e1) {
				select.selectByIndex(Integer.parseInt(value));
			}
		}
	}
	/**
	 * this method is used to perform scroll by the action
	 * @param x
	 * @param y
	 */
	public void scrollToAction(int x,int y)
	{
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	/**
	 * this method is used to perform scrollTo the action
	 * @param x
	 * @param y
	 */
	public void scrollByAction(int x,int y)
	{
		js.executeScript("window.scrollTo("+x+","+y+")");
	}
	/**
	 * this method is used to scroll to the element to increase the element value
	 * if the status is true the window will scroll until the element reaches Top page
	 * if the status is false the window will scroll until the element reaches bottom page
	 * @param element
	 * @param status
	 */
	public void scrollintoView(WebElement element,boolean status)
	{
		js.executeScript("arguments[0].scrollIntoView("+status+")",element);
	}
	/**
	 * this method is used to switch driver control from window to frame with help of index
	 * @param index
	 */
	public void switchingtoFrame(int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * this method is used to switch driver control from window to frame with help of Name
	 * @param index
	 */
	public void switchingtoFrame(String name)
	{
		driver.switchTo().frame(name);
	}
	/**
	 * this method is used to switch driver control from window to frame with help of element
	 * @param index
	 */
	public void switchingtoFrame(WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * this method is used to switch driver control from frame to main window
	 */
	public void switchingbacktomainFrame()
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * this method is used to handle the popup
	 * @return
	 */
	public Alert returnAlertreference()
	{
		return driver.switchTo().alert();
	}
	/**
	 * this method is used to switch the driver control from parent to child window
	 * @param allid
	 * @param exptitle
	 * @param parentId
	 */
	public void switchtowindow(Set<String>allid,String exptitle,String parentId)
	{
		allid.remove(parentId);
		for(String id:allid)
		{
			driver.switchTo().window(id);
			if(exptitle.equalsIgnoreCase(driver.getTitle()))
			{
				break;
			}
		}
	}
	/**
	 * this method is used to switch the driver control back to parent window
	 * @param parentid
	 */
	public void switchbacktomainwindow(String parentid)
	{
		driver.switchTo().window(parentid);
		driver.manage().window().minimize();
	}
	/**
	 * this method is used to take screenshot
	 */
	public void captureshots()
	{
		File src = ss.getScreenshotAs(OutputType.FILE);
		File file=new File("./target/Errorshots/demo1.png");
		try {
			FileUtils.copyFile(src, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
