package com.base.pkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public  WebDriver driver;
	
	//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("someid")));
	public BasePage(WebDriver driver) {
		this.driver = driver;		
	}

	public void launchbaseurl(String url) {
		driver.get(url);
	}

}
