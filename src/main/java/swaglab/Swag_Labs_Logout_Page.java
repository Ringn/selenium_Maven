package swaglab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Swag_Labs_Logout_Page 
{
	
	@FindBy(xpath="//a[text()='Logout']")private WebElement LogOut;
	
	public Swag_Labs_Logout_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clickLogOutPageLogOutButton() 
	{
		LogOut.click();
		
	}
	
}
