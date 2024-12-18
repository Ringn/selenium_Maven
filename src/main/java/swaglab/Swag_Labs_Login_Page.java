package swaglab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Swag_Labs_Login_Page {
	
	@FindBy(xpath="//input[@id='user-name']") private WebElement UN;
	@FindBy(xpath="//input[@id='password']")private WebElement PW;
	@FindBy(xpath="//input[@name='login-button']")private WebElement Login;
	
	public Swag_Labs_Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void inputLoginPageEnterUN(String username) 
	{
		UN.sendKeys(username);
		
	}
	
	public void inputLoginPageEnterPW(String password) 
	{
		
		PW.sendKeys(password);
		
	}
	
	public void clickLoginPageLoginButton() 
	{
		
		Login.click();
		
	}

}
