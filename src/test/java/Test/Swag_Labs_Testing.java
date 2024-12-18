package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import swaglab.SwagLabsBaseClass;
import swaglab.SwagLabsHomePage;
import swaglab.Swag_Labs_Login_Page;
import swaglab.Swag_Labs_Logout_Page;
import swaglab.Utility_Class;



public class Swag_Labs_Testing extends SwagLabsBaseClass
{
	
	Swag_Labs_Login_Page login;
	SwagLabsHomePage home;
	Swag_Labs_Logout_Page logout;
	int tcid;
	
	@BeforeClass
	public void Tc1() 
	{
	   OpenBrowser();
	   login=new Swag_Labs_Login_Page(driver);
	   home=new SwagLabsHomePage(driver);
	   logout=new Swag_Labs_Logout_Page(driver);
	}
	
	@BeforeMethod
	public void LogintoApplication() throws EncryptedDocumentException, IOException, InterruptedException 
	{
		login.inputLoginPageEnterUN(Utility_Class.getPF_Data("UN"));
		login.inputLoginPageEnterPW(Utility_Class.getPF_Data("PW"));
		login.clickLoginPageLoginButton();
		Thread.sleep(2000);
		
	}
	
	@Test
	public void verify_logo() throws EncryptedDocumentException, IOException 
	{
		tcid=101;
		String actLogoText=home.getHomePageLogo();
		String expLogoText=Utility_Class.FetcExcelData(0,2);
		Assert.assertEquals(actLogoText,expLogoText,"failed:both result are diff");
		
		
		
	}
	
	@AfterMethod
	public void LogoutFromApp(ITestResult s1) throws IOException, InterruptedException 
	{
		if(s1.getStatus()==ITestResult.FAILURE)
		{
			Utility_Class.captureSS(driver, tcid);
		}
		
		home.clickHomePagePopUp();
		Thread.sleep(2000);
		logout.clickLogOutPageLogOutButton();
		Thread.sleep(2000);
		
	}
	
	
	@AfterClass
	public void closeBrowser() 
	{
		driver.quit();
		
	}
	
	
	
	
	
	
}
