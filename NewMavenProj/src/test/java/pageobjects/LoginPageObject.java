package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.pkg.*;

public class LoginPageObject extends BasePage {

	public LoginPageObject(WebDriver driver) {
		super(driver);
		//objectInit();		
	}
	public By searchbox = By.id("lst-ib");
	public By searchbtn = By.name("btnG");

}
