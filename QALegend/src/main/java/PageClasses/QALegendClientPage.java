package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;
import net.bytebuddy.asm.Advice.Return;
import net.bytebuddy.asm.MemberSubstitution.FieldValue;

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
	@FindBy(xpath = "//tr[@class='odd' or @class='even']")
	WebElement clientcellvalue;
	@FindBy(xpath = "//a[@title='Edit client']")
	WebElement editbutton;
	@FindBy(xpath = "//a[@title='Delete client']")
	WebElement deletebutton;
	@FindBy(id="confirmDeleteButton")
	WebElement confirmDeleteButton;
	@FindBy(xpath = "//div[@class='modal-content']")
	WebElement clientmodal;
	
	
	public QALegendClientPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public QALegendClientPage clickonAddClient() {
		PageUtilities.clickonanElement(addclientElement);
		return this;
	}
	public QALegendClientPage editClient(String address,String city,String zipcode,String phonenumber) {
		
		PageUtilities.enterText(addressfield, address);
		PageUtilities.enterText(cityfield, city);
		PageUtilities.enterText(zipcodefield, zipcode);
		PageUtilities.enterText(phonenumberfield, phonenumber);
		PageUtilities.scrolltillElementVisible(driver, savebutton);
		PageUtilities.clickonanElement(savebutton);
		return this;
		
		
	}
	public QALegendClientPage addClient(String companyname) {
		PageUtilities.enterText(comapanyNamefield, companyname);
		PageUtilities.scrolltillElementVisible(driver, savebutton);
		PageUtilities.clickonanElement(savebutton);
		return this;
		
	}
	public QALegendClientPage searchCLient(String name){
		WaitUtility.waitForInVisibilityofElement(driver, clientmodal);
		PageUtilities.enterText(searchdfield, name);
		return this;
	}
	public boolean isClientexist() {
		return clientcellvalue.isDisplayed();
	}
	public QALegendClientPage clickonEditClient() {
		WaitUtility.waitForVisibilityofElement(driver,editbutton);
		PageUtilities.clickonanElement(editbutton);
		return this;
	}
	public boolean isclientEditSuccess(String address,String city,String zipcode,String phonenumber){
	
		String addressvalue=addressfield.getText();
		System.out.println(addressvalue);
		String cityvalue= cityfield.getDomAttribute("value");
		System.out.println(cityvalue);
		String zipcodevalue=zipcodefield.getDomAttribute("value");
		System.out.println(zipcodevalue);
		String phonenumbervalue=phonenumberfield.getDomAttribute("value");
		System.out.println(phonenumbervalue);
		if((address.equalsIgnoreCase(addressvalue))&& city.equalsIgnoreCase(cityvalue)&& zipcode.equalsIgnoreCase(zipcodevalue)&& phonenumber.equalsIgnoreCase(phonenumbervalue))
			return true;
		else {
			return false;
		}		
		
	}
	public QALegendClientPage clickonDelete() {
		PageUtilities.clickonanElement(deletebutton);
		return this;
	}
	public QALegendClientPage clickonDeleteConfirmation() {
		PageUtilities.clickonanElement(confirmDeleteButton);
		return this;
	}
	public String isClientDeleted() {
		WaitUtility.waitForTexttoBePresentinElement(driver, clientcellvalue, "No record found");
		return(clientcellvalue.getText());
	}

}
