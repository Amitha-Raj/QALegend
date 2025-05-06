package PageClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QALegendTeamMemberPage {
	WebDriver driver;
	@FindBy(xpath = "//a[@title='Add member']")
	WebElement addmemberbutton;
	@FindBy(id="first_name")
	WebElement firstnamefield;
	@FindBy(id="last_name")
	WebElement lastnamefield;
	@FindBy(xpath = "//button[@id='form-next']")
	WebElement nextbutton;
	@FindBy(id="job_title")
	WebElement jobtitleField;
	@FindBy(id="email")
	WebElement emailField;
	@FindBy(id="password")
	WebElement passwordFieldElement;
	@FindBy(id="form-submit")
	WebElement savebuttonElement;
	@FindBy(xpath = "//div[@id='team_member-table_filter']//descendant::input")
	WebElement searchbox;
	@FindBy(xpath="//tr[@class='odd'or @class='even']")
	WebElement teammembercellvalue;
	@FindBy(xpath = "//a[@title='Delete team member']")
	WebElement deletebutton;
	@FindBy(id="confirmDeleteButton")
	WebElement confirmdeletebutton;
	@FindBy(xpath = "//div[@class='modal-content']")
	WebElement addteammembermodal;
	
	
	public QALegendTeamMemberPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public QALegendTeamMemberPage addMember(String fname,String lname,String jobtitle,String email,String password) {
		PageUtilities.enterText(firstnamefield, fname);
		PageUtilities.enterText(lastnamefield, lname);
		PageUtilities.clickonanElement(nextbutton);
		PageUtilities.enterText(jobtitleField, jobtitle);
		PageUtilities.clickonanElement(nextbutton);
        PageUtilities.enterText(emailField, email);
        PageUtilities.enterText(passwordFieldElement, password);
        PageUtilities.clickonanElement(savebuttonElement);
        return this;
	}
	
	

    public QALegendTeamMemberPage clickonAddMember() {
    	PageUtilities.clickonanElement(addmemberbutton);
    	return this;
    }

	public QALegendTeamMemberPage searchMember(String membername) {
		WaitUtility.waitForInVisibilityofElement(driver, addteammembermodal);
		PageUtilities.enterText(searchbox, membername);
		return this;
	}
	public boolean cellvalueFind() {
		
		return(teammembercellvalue.isDisplayed());
		
	}
	public QALegendTeamMemberPage clickonDelete() {
		PageUtilities.clickonanElement(deletebutton);
		return this;
	}
	public QALegendTeamMemberPage confirmDeletepopup() {
		PageUtilities.clickonanElement(confirmdeletebutton);
		return this;
	}
	
	public String confirmDeletion() {
		return (teammembercellvalue.getText());
	}

}
