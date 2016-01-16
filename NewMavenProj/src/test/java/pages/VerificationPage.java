package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.BasicConfigurator;


import org.apache.log4j.Level;

import com.utilities.pkg.Reporter;

import pageobjects.VerificationPageObject;

public class VerificationPage extends VerificationPageObject {
	public WebDriver driver;

	/*By searchbox = By.id("lst-ib");
	By searchbtn = By.name("btnG");*/
	//static final Logger logger = Logger.getLogger(VerificationPage.class);

	
	public VerificationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void verifyRetult()  {
		//BasicConfigurator.configure();
		//logger.setLevel(Level.INFO);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(results));
		System.out.println(driver.findElement(results).getText());
		//logger.info("Results fetched successfully");
		Reporter.report("test", "test");
	}

	

}
