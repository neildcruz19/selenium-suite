package com.selenium.test.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.selenium.test.util.DriverUtils;


public class BaseTestCase {
	
	private WebDriver driver = null;
	
	@Test(description="Initialize the Driver")
	public void initDriver() {
		this.driver = new FirefoxDriver();
	}
	
	@Test(description="Launch the page to be tested" , dependsOnMethods="initDriver")
	public void launchPage() {
		driver.get("http://www.google.com");
	}
	
	@Test(description="Sample Google Test case", dependsOnMethods="launchPage")
	public void googleTest() throws InterruptedException {
		driver.findElement(By.id("lst-ib")).clear();
	    driver.findElement(By.id("lst-ib")).sendKeys("neil dcruz");
	    DriverUtils.clickAndWaitUntilPresent(driver, By.name("btnG"),By.linkText("Neil Dcruz Profiles | Facebook"));
	    DriverUtils.clickAndWaitUntilPresent(driver, By.linkText("Neil Dcruz Profiles | Facebook"),By.linkText("Neil Dcruz"));
	    DriverUtils.clickAndWaitUntilPresent(driver, By.linkText("Neil Dcruz"),By.cssSelector("img.profilePic.img"));
	    driver.findElement(By.cssSelector("img.profilePic.img")).click();
	}
	
	@AfterClass(alwaysRun=true)
	public void closeBrowser() {
		driver.close();
	}

}
