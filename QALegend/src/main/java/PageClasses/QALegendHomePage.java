package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QALegendHomePage {
	WebDriver driver;
	@FindBy(xpath = "//span[text()='Team members']")
	WebElement teamMemberoption;
	@FindBy(xpath = "//span[text()='Leave']")
	WebElement leaveoption;
	@FindBy(xpath = "//span[text()='Clients']")
	WebElement clientoption;
	
	public QALegendHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickonTeamMemberMenu() {
		PageUtilities.clickonanElement(teamMemberoption);
	}
	public void clickonLeaveMenu() {
		PageUtilities.clickonanElement(leaveoption);
	}
	public void clickonClientMenu() {
		PageUtilities.clickonanElement(clientoption);
	}

}
