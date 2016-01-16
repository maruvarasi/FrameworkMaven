package com.utilities.pkg;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Reporter {
	
	private static List<Result> details=new ArrayList<Result>();
	private static final String resultPlaceholder = "<!-- INSERT_RESULTS -->";
	private static final String templatePath = "D:\\Selenium\\report_template.html";
	private static final Boolean includeScreenshots = true;
	private static final String screenshotPath = "D:\\Selenium\\Run_Results\\screenshots\\";
			
	public Reporter() {
	}
	
	public static void initialize() {
		details = new ArrayList<Result>();
	}
	
	public static void report(WebDriver driver, String actualValue,String expectedValue) {
		if(actualValue.equals(expectedValue)) {
			Result r = new Result("Pass","Actual value '" + actualValue + "' matches expected value","");
			details.add(r);
		} else {
			
			String screenshotPath = "";
			
			if(includeScreenshots) {
				screenshotPath = getScreenshot(driver);
			}
			Result r = new Result("Fail","Actual value '" + actualValue + "' does not match expected value '" + expectedValue + "'",screenshotPath);
			details.add(r);
		}
	}

	private static String getScreenshot(WebDriver driver) {

		// generate screenshot as a file object
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String currentDateTime = getCurrentDate();
		String location = screenshotPath + currentDateTime + ".png";
		
		try {
			// copy file object to designated location
			FileUtils.copyFile(scrFile, new File(location));
		} catch (IOException e) {
			System.out.println("Error while generating screenshot:\n" + e.toString());
		}
		
		return location.replace("\\","\\\\");
	}

	private static String getCurrentDate() {
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
		return sdf.format(cal.getTime());
	}

	public static void writeResults() {
		try {
			String reportIn = new String(Files.readAllBytes(Paths.get(templatePath)));
			for (int i = 0; i < details.size();i++) {
				if(details.get(i).getResultScreenshot().equals("")) {
					reportIn = reportIn.replaceFirst(resultPlaceholder,"<tr><td>" + Integer.toString(i+1) + "</td><td>" + details.get(i).getResult() + "</td><td>" + details.get(i).getResultText() + "</td><td></td></tr>" + resultPlaceholder);
				} else {
					reportIn = reportIn.replaceFirst(resultPlaceholder,"<tr><td>" + Integer.toString(i+1) + "</td><td>" + details.get(i).getResult() + "</td><td>" + details.get(i).getResultText() + "</td><td><a href=\"" + new File(details.get(i).getResultScreenshot()).toURI().toURL() + "\">screenshot</a></td></tr>" + resultPlaceholder);
				}
				
			}
			
			String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			String reportPath = "D:\\Selenium\\Run_Results\\report_" + currentDate + ".html";
			Files.write(Paths.get(reportPath),reportIn.getBytes(),StandardOpenOption.CREATE);
			
		} catch (Exception e) {
			System.out.println("Error when writing report file:\n" + e.toString());
		}
	}
}