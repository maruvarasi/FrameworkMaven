package regression;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.VerificationPage;

import com.base.pkg.BaseTest;

public class NewTest extends BaseTest{
	//public static WebDriver driver;
	//WebDriver driver = new FirefoxDriver();
	String testcaseName = this.getClass().getSimpleName();
	public NewTest(){
		super();
		getDBDataFromDB("search_tb",testcaseName);
	}
	
	
  @Test
  public void verifyGoogleSearch() {
	  LoginPage loginPage = new LoginPage(getDriver());
	  VerificationPage verificationPage = new VerificationPage(getDriver());
	  
	  /**Begin testcase **/
	  startTesting();
	  loginPage.launchURL(getProp("url"));
	  loginPage.searchtext(getDB("input"));
	  loginPage.clickSearchBtn();
	  verificationPage.verifyRetult(getDB("expected"));
	  stopTesting();
	  
  }
}
