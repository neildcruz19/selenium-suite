package com.selenium.test.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/***
 * Static utility class for extending driver functionality
 * for tough to obtain actions with the default WebDriver
 * interface
 * @author neildcruz
 */
public class DriverUtils {

	/**
	 * Static utility method to implement the click and wait
	 * method for selenium drivers
	 * wait.timeout - defined in config.properties
	 * @param <T>
	 * @param driver - the driver reference
	 * @param by - the locator for the element to be clicked
	 */
	public static <T> void clickAndWaitUntilPresent(WebDriver driver, By by,By elementPresenceLocator) {
		driver.findElement(by).click();
		//define a new wait with a time out for the driver element
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(elementPresenceLocator));
	}
	
}
