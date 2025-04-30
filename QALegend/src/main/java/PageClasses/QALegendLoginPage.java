package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QALegendLoginPage {
	WebDriver driver;
	
	@FindBy(id="email")
	WebElement usernamefield;
	@FindBy(id="password")
	WebElement passwordfield;
	@FindBy(xpath = "//button[text()='Sign in']")
	WebElement signinbutton;
	
	
	
	
	public QALegendLoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}




	public QALegendLoginPage loginToQALegend(String username, String Password) {
		
		usernamefield.sendKeys(username);
		passwordfield.sendKeys(Password);
		signinbutton.click();
		return this; //chaining of pages
		
	}

}
