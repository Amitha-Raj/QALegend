package Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constants.Constant;

public class WaitUtility {
	
	public static void waitForClickingonanElement(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.EXPLICITWAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static void waitForTexttoBePresentinElement(WebDriver driver,WebElement element,String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.EXPLICITWAIT));
		wait.until(ExpectedConditions.textToBePresentInElement(element, value));
	}
	public static void waitForElementTobeSelected(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.EXPLICITWAIT));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	public static void waitForVisibilityofElement(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.EXPLICITWAIT));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	

}


