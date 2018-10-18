package com.skilrock.dge.common.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.skilrock.dge.common.utils.CommonFunctionLibrary;

public class BasePage {

	private static Logger logger = LoggerFactory.getLogger(BasePage.class);
	protected static WebDriver driver=null;
	static WebDriverWait wait;
	public static CommonFunctionLibrary functionLibrary;

	public BasePage(WebDriver driver) {
		BasePage.driver = driver;
		functionLibrary = new CommonFunctionLibrary(driver);
	}

	public boolean isElementPresent(By locator, int timeoutInSeconds) {
		try {
			wait = new WebDriverWait(driver, timeoutInSeconds);
			WebElement elem = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			if (elem != null) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			return false;
		}

	}
	
	public boolean isElementVisible(By locator, int timeoutInSeconds) {
		try {
			wait = new WebDriverWait(driver, timeoutInSeconds);
			WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			if (elem != null) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			return false;
		}

	}

	public  WebElement findElement(By locator, int timeoutSeconds) {
		wait = new WebDriverWait(driver, timeoutSeconds);
		WebElement elem = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		if (elem != null) {
			return elem;
		} else {
			return null;
		}
	}

	public WebElement findElement(String locator, int timeoutSeconds) {
		wait = new WebDriverWait(driver, timeoutSeconds);
		WebElement elem = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		if (elem != null) {
			return elem;
		} else {
			return null;
		}
	}

	public List<String> findElements(By locator, int timeoutSeconds) {
		wait = new WebDriverWait(driver, timeoutSeconds);
		List<WebElement> elem = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		List<String> temp = new ArrayList<String>();
		if (elem != null) {
			for (WebElement val : elem) {
				temp.add(val.getText());
			}
			return temp;
		} else {
			return null;
		}
	}

	public List<WebElement> findAllWebElements(By locator, int timeoutSeconds) {
		wait = new WebDriverWait(driver, timeoutSeconds);
		List<WebElement> elem = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		return elem;
	}

	public boolean buttonClick(By locator, int timeoutSeconds) {
		try {
			WebElement element = findElement(locator, timeoutSeconds);
			element.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	
	public void sendKeys(By locator, String str, int timeoutInSeconds) {
		findElement(locator, timeoutInSeconds).clear();
		findElement(locator, timeoutInSeconds).sendKeys(str);
	}
}
