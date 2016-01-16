package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.pkg.*;

public class VerificationPageObject extends BasePage {

	public VerificationPageObject(WebDriver driver) {
		super(driver);
	}
	public By results = By.id("resultStats");

}
