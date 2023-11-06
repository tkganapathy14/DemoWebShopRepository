package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.webdriverutility;

public class ComputerPage {

	public ComputerPage(WebDriver driver) {
	
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getDesktopitems() {
		return desktopitems;
	}
	public WebElement getCheapcomputer() {
		return cheapcomputer;
	}
	public WebElement getOwncomputer() {
		return owncomputer;
	}
	public WebElement getProductcomparelist() {
		return productcomparelist;
	}
	public WebElement getRemovebutton() {
		return removebutton;
	}

	@FindBy(linkText = "Desktops")
	private WebElement desktopitems;
	@FindBy(linkText = "Build your own cheap computer")
	private WebElement cheapcomputer;
	@FindBy(linkText = "Build your own computer")
	private WebElement owncomputer;
	@FindBy(xpath = "//input[@value='Add to compare list']")
	private WebElement productcomparelist;
	@FindBy(xpath = "//input[@value='Remove']")
	private WebElement removebutton;
}
