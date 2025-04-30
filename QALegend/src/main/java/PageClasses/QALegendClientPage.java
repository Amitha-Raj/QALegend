package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QALegendClientPage {
	WebDriver driver;

	@FindBy(xpath = "//a[@title='Add client']")
	WebElement addclientElement;
	@FindBy(id="company_name")
	WebElement comapanyNamefield;
	@FindBy(id="address")
	WebElement addressfield;
	@FindBy(id="city")
	WebElement cityfield;
	@FindBy(id="zip")
	WebElement zipcodefield;
	@FindBy(id="phone")
	WebElement phonenumberfield;
	@FindBy(xpath = "//span[@class='fa fa-check-circle']")
	WebElement savebutton;
	@FindBy(xpath = "//div[@id='client-table_filter']//descendant::input")
	WebElement searchdfield;
	
	
	public QALegendClientPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickonAddClient() {
		PageUtilities.clickonanElement(addclientElement);
	}
	public void addClient(String companyname,String address,String city,String zipcode,String phonenumber) {
		PageUtilities.enterText(comapanyNamefield, companyname);
		PageUtilities.enterText(addressfield, address);
		PageUtilities.enterText(cityfield, city);
		PageUtilities.enterText(zipcodefield, zipcode);
		PageUtilities.enterText(phonenumberfield, phonenumber);
		PageUtilities.scrolltillElementVisible(driver, savebutton);
		PageUtilities.clickonanElement(savebutton);
		
		
	}
	public void addClient(String companyname) {
		PageUtilities.enterText(comapanyNamefield, companyname);
		PageUtilities.scrolltillElementVisible(driver, savebutton);
		PageUtilities.clickonanElement(savebutton);
		
	}
	public void searchCLient(String name) {
		WaitUtility.waitForClickingonanElement(driver, searchdfield);
		PageUtilities.enterText(searchdfield, name);
	}
	

}
