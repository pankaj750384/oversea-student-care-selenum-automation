package com.osc.automation.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utils {
	static WebDriver driver;
	DriverType[] driverType = DriverType.values();

	public Utils() {
		// TODO Auto-generated constructor stub
	}

	public static WebDriver intializDriver(String browser) {
		System.out.println("Intialize ");
		final Logger LOG = LoggerFactory.getLogger(Utils.class);
		if (browser.equalsIgnoreCase(DriverType.CHROME.value())) {
			LOG.info("Chrome driver intialize started");
			// WebDriverManager.chromedriver().setup();

			try {
				System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
				System.setProperty("webdriver.chrome.silentOutput","true");
				
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--no-sandbox");
				driver = new ChromeDriver();
				

				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				LOG.info("Chrome driver intialize successfully");
			} catch (Exception ex) {

				System.out.println(ex);
			}

		} else if (browser.equalsIgnoreCase(DriverType.FIREFOX.value())) {
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			LOG.info("FirefoxDriver driver intialize successfully");

		} else if (browser.equalsIgnoreCase(DriverType.IE.value())) {
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver = new InternetExplorerDriver();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			LOG.info("Chrome driver intialize successfully");

		} else if (browser.equalsIgnoreCase(DriverType.CHROME.value())) {
			/*
			 * WebDriverManager.seleniumServerStandalone().setup(); driver = new
			 * SafariDriver(); driver.manage().timeouts().implicitlyWait(50,
			 * TimeUnit.SECONDS); LOG.info("Chrome driver intialize successfully");
			 */

		}
		return driver;

	}
	
	
	public static void waitFor(long mils) throws InterruptedException {
		Thread.sleep(mils);	
	}

}
