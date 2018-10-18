package com.skilrock.dge.common.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cucumber.api.Scenario;

public class CommonFunctionLibrary {
	

    WebDriver driver;
    WebDriverWait wait;
    
    private static Logger logger = LoggerFactory.getLogger(CommonFunctionLibrary.class);

    public CommonFunctionLibrary(WebDriver driver) {
        this.driver = driver;
    }

    public boolean switchFrame(String frameId) {
        try {
            driver.switchTo().defaultContent();
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
            logger.info(driver.getWindowHandle());
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void switchToAlertOk() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public WebElement findElement(By locator, int timeoutSeconds) {
        wait = new WebDriverWait(driver, timeoutSeconds);
        WebElement elem = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        if (elem != null) {
            return elem;
        } else {
            return null;
        }
    }

    public void mouseHover(By elem) {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(elem);
        action.moveToElement(element).build().perform();

    }

    public List<String> dropdownList(By listid, String tagelem) {
        List<String> optionlist = new ArrayList<String>();
        WebElement items = driver.findElement(listid);
        List<WebElement> options = items.findElements(By.tagName(tagelem));
        System.out.println(options.size());

        for (WebElement data : options) {
            if (!data.getText().contains("Please Select")) {
                optionlist.add(data.getText());
            }

        }

        return optionlist;

    }

    public void selectdropdownByIndex(By listitem, int Index) {
        Select dropdownitem = new Select(findElement(listitem, 5));
        dropdownitem.selectByIndex(Index);

    }

    public void selectdropdownByValue(By listvalue, String Value) {
        Select dropdownitem = new Select(findElement(listvalue, 5));
        dropdownitem.selectByValue(Value);
    }

    public void selectdropdownByvisibleTxt(By listvalue, String Value) {
        Select dropdownitem = new Select(findElement(listvalue, 5));
        dropdownitem.selectByVisibleText(Value);
    }

    public boolean isAlertPresent() {

        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException ex) {
            return false;
        }

    }

    public String getAlertText() {
        try {
            Alert alert = driver.switchTo().alert();
            return alert.getText();
        } catch (NoAlertPresentException ex) {
            ex.printStackTrace();
        }
        return null;
    }



}
