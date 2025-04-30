package Utilities;

import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.nio.channels.SelectableChannel;
import java.sql.Driver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
//utilities are created for code maintence,all methods should be static
public class PageUtilities {
  public static void clickonanElement(WebElement element) {
	  element.click();
  }
  public static void enterText(WebElement element,String value) {
	  element.sendKeys(value);
  }
  public static void selectByvalue(WebElement element, String value) {
	  Select dropdown= new Select(element);
	  dropdown.selectByValue(value);
  }
  public static void selectbyVisibleText(WebElement element,String value) {
	  Select dropdown= new Select(element);
	  dropdown.selectByVisibleText(value);
  }
  public static void selectbyIndex(WebElement element, Integer index) {
	  Select dropdown= new Select(element);
	  dropdown.selectByIndex(index);
  }
  public static void dragAnddrop(WebDriver driver,WebElement sourceElement,WebElement destionationElement) {
	  Actions action = new Actions(driver);
	  action.dragAndDrop(sourceElement, destionationElement).build().perform();
  }
  public static void clickUsingJavaScript(WebDriver driver, WebElement element) {
 
	  JavascriptExecutor executor= (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();", element);
  }
  public static void scrolltillElementVisible(WebDriver driver, WebElement element) {
	  
	  JavascriptExecutor executor= (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].scrollIntoView();", element);
  }
  public static void mouseHover(WebDriver driver, WebElement element) {
	  Actions action = new Actions(driver);
	  action.moveToElement(element).build().perform();
  }
  public static void rightClick(WebDriver driver, WebElement element) {
	  Actions action = new Actions(driver);
	  action.contextClick().build().perform();
  }
  public static void doubleClick(WebDriver driver, WebElement element) {
	  Actions action = new Actions(driver);
	  action.doubleClick().build().perform();
  }
  public static void navigateTo(WebDriver driver, String destination) {
	  driver.navigate().to(destination);
  }
  public static void navigateback(WebDriver driver) {
	  driver.navigate().back();
  }
  public static void navigateforward(WebDriver driver) {
	  driver.navigate().forward();
  }
  public static void refresh(WebDriver driver) {
	  driver.navigate().refresh();
  }
  //mousehover
  //doubleclick,right click,page refresh,navigate to,back,
  // To accept an alert box
  public static void acceptAlert(WebDriver driver) {
	  driver.switchTo().alert().accept();
  }
  public static void dismissAlert(WebDriver driver) {
	  driver.switchTo().alert().dismiss();
  }
  public static void enterValuetoAlert(WebDriver driver,String Value) {
	  driver.switchTo().alert().sendKeys(Value);
  }
  public static String getTextFromAlert(WebDriver driver) {
	 return( driver.switchTo().alert().getText());
  }
  
}
