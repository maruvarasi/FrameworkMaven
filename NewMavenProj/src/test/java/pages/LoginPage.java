package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageobjects.LoginPageObject;

public class LoginPage extends LoginPageObject {
	public WebDriver driver;

	/*By searchbox = By.id("lst-ib");
	By searchbtn = By.name("btnG");*/

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void launchURL(String url) {
		launchbaseurl(url);
	}

	public void searchtext(String text) {
		driver.findElement(searchbox).sendKeys(text);
	}

	public void clickSearchBtn() {
		driver.findElement(searchbox).sendKeys(Keys.ENTER);
		//driver.findElement(searchbtn).click();
	}

}
