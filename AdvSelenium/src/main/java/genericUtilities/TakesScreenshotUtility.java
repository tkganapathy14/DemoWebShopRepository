package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakesScreenshotUtility {
	
	WebDriver driver;
	TakesScreenshot ss;
	public TakesScreenshotUtility(WebDriver driver) {
		this.driver=driver;
		ss=(TakesScreenshot)this. driver;
	}
	/**
	 * this method is used to takesscreenshot
	 */
	public void capturingscreenshot()
	{
		File src = ss.getScreenshotAs(OutputType.FILE);
		File destination=new File("./target/Errorshots/demo.png");
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * this method is used to concatenate date and time of photo.
	 * @param screenshotname
	 */
	public void capturess(String screenshotname)
	{
		File src = ss.getScreenshotAs(OutputType.FILE);
		String time = LocalDateTime.now().toString().replace(":","-");
		File file=new File("./target/Errorshots/"+screenshotname+" "+ time +".png");
		try {
			FileUtils.copyFile(src, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	/**
	 * this method is used to take screenshot. it will be stored in directory of file
	 * whenever we use extent reports we need directory of photo,then only we get report
	 * @param screenshotname
	 * @return 
	 */
	public String capturescreenshot(String screenshotname)
	{
		File src = ss.getScreenshotAs(OutputType.FILE);
		String time = LocalDateTime.now().toString().replace(":","-");
		String directory = System.getProperty("user.dir");
		String path="("+directory+"./target/Errorshots/"+screenshotname+" "+time+".png)";
		File destination=new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
}
