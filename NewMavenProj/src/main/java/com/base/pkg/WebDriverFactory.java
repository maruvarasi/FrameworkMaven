package com.base.pkg;

import org.apache.bcel.generic.SWITCH;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory {
	public WebDriver driver;
	
	public WebDriver initializeWebDriver(String browser){
		System.out.println("Launching browser : " + browser);
		
	switch(browser){
	case "firefox":
		DesiredCapabilities dc = DesiredCapabilities.firefox();
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		profile.setAcceptUntrustedCertificates(true);
		dc.setCapability(FirefoxDriver.PROFILE, profile);
		driver =  new FirefoxDriver(dc);
		
		driver.manage().window().maximize();
		break;
	case "chrome":
		break;
	default:
		break;
	}
	return driver;
	}
	}

