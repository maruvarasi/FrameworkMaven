package com.base.pkg;

import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;

import com.utilities.pkg.DataBaseConnectivity;
import com.utilities.pkg.Reporter;
import com.utilities.pkg.proputils;

public abstract class BaseTest {
	proputils prop = new proputils();
	WebDriverFactory fact = new WebDriverFactory();
	DataBaseConnectivity dbconn = new DataBaseConnectivity();
	public static HashMap<String, String> hsKey = new HashMap<>();
	public static HashMap<String, String> hsmap = new HashMap<>();
	public static String browser="";
	public WebDriver driver;
	
	public BaseTest() {
		//prop.readProp();
		hsKey = prop.readProp();
		initialzeDriver();
	}	
	
	/*public BaseTest(String table,String testcase){
		try {
			hsmap = dbconn.getDatabase(table,testcase);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}*/
	public HashMap<String, String> getDBDataFromDB(String table,String testcase){
		try {
			hsmap = dbconn.getDatabase(table,testcase);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hsmap;

	}
	public String getProp(String key) {
		String value = hsKey.get(key);
		return value;
	}
	
	public String getDB(String key){
		String value="";
		if (hsmap.containsKey(key))
		{
			value = hsmap.get(key);
		}
		else
		{
			System.out.println("Invalid column & no data");
		}
		return value;
		
	}
	
	
	
	public void initialzeDriver(){
		browser = getProp("browser");
		driver = fact.initializeWebDriver(browser);
	}
	public WebDriver getDriver(){
		return this.driver;
	}
	
public void startTesting()
{
	System.out.println("testing started....");
	}
public void stopTesting()
{
	Reporter.writeResults();
	System.out.println("testing ended...");
	}
}
