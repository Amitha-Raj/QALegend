package PageClasses;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.DateUtility;
import Utilities.PageUtilities;
import Utilities.WaitUtility;
import net.bytebuddy.asm.Advice.Return;
import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class QALegendLeavePage {
	
	WebDriver driver;
	String leaveapplicantname;
	Properties prop;
	
	@FindBy(xpath ="//a[@title=\"Assign leave\"]")
	WebElement assignleavebutton;
	@FindBy(id ="s2id_applicant_id")
	WebElement teammemberdropdown;
	@FindBy(xpath = "(//div[contains(@id,'select2-result-label')])[2]")
	WebElement teammembername;
	@FindBy(id="s2id_leave_type_id")
	WebElement leavetype;
	@FindBy(xpath = "(//div[@class=\"select2-result-label\"])[2]")
	WebElement leavename;
	@FindBy(id="single_date")
	WebElement leavedate;
	@FindBy(xpath = "//td[@class=\"today day\"]")
	WebElement currentDate;
	@FindBy(id = "reason")
	WebElement leavereason;
	@FindBy(xpath = "//span[@class=\"fa fa-check-circle\"]")
	WebElement submitleavebutton;
	@FindBy(xpath = "//a[text()='All applications']")
	WebElement allleaveapplicationtab;
	@FindBy(xpath = "//div[@id=\"all-application-table_filter\"]//descendant::input")
	WebElement leavesearch;
	@FindBy(xpath = "//a[@title='Apply leave']")
	WebElement applyleavebutton;
	@FindBy(xpath = "//a[text()='Pending approval']")
	WebElement pendingapprovaltab;
	@FindBy(xpath = "//div[@id=\"pending-approval-table_filter\"]//descendant::input")
	WebElement pendingapprovalsearch;
	@FindBy(xpath = "//a[@title='Application details']")
	WebElement editleave;
	@FindBy(xpath = "//button[@class='btn btn-success btn-sm update-leave-status']")
	WebElement approveleavebutton;
	@FindBy(xpath = "(//button[@class='btn btn-danger btn-sm update-leave-status'])[2]")
	WebElement rejectleaveButton;
	@FindBy(xpath = "(//button[@class='btn btn-danger btn-sm update-leave-status'])[1]")
	WebElement cancelleaveButton;
	@FindBy(xpath = "//i[@class='fa fa-times fa-fw']")
	WebElement deleteleavElement;
    @FindBy(id = "confirmDeleteButton")
    WebElement confirmDeletebutton;
    @FindBy(xpath="//tr[@class='odd'or @class='even']")
	WebElement leavecellvalue;

	
	
	
	public QALegendLeavePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}


	public void clickonAssignLeave() {
		PageUtilities.clickonanElement(assignleavebutton);
	}
	
	public void assignLeave(String reason)  {
		
	    PageUtilities.clickonanElement(teammemberdropdown);
	    leaveapplicantname =teammembername.getText();
	    System.out.println(leaveapplicantname);
	    PageUtilities.clickonanElement(teammembername);
	    PageUtilities.clickonanElement(leavetype);
	    PageUtilities.clickonanElement(leavename);
	  	PageUtilities.clickonanElement(leavedate);
		PageUtilities.clickonanElement(currentDate);
		PageUtilities.enterText(leavereason,reason);
		PageUtilities.clickonanElement(submitleavebutton);
		
	}
	public void searchLeavebyName() throws InterruptedException {
		//WaitUtility.waitForVisibilityofElement(driver,allleaveapplicationtab);
		Thread.sleep(5000);
		PageUtilities.clickonanElement(allleaveapplicationtab);
		PageUtilities.enterText(leavesearch, leaveapplicantname);
		
	}
   public boolean checkLeaveAssigned(){
	  
	   return(leavecellvalue.isDisplayed());
   }
   public void clickonApplyLeave() {
	   PageUtilities.clickonanElement(applyleavebutton);
   }
   public void applyLeave(String reason) {
	   PageUtilities.clickonanElement(leavetype);
	   PageUtilities.clickonanElement(leavename);
	   PageUtilities.clickonanElement(leavedate);
	   PageUtilities.clickonanElement(currentDate); 
	   PageUtilities.enterText(leavereason,reason);
	   PageUtilities.clickonanElement(submitleavebutton);
	  
   }
   public void searchPendingLeavesByDate() throws InterruptedException {
		//WaitUtility.waitForVisibilityofElement(driver, pendingapprovalsearch);
		Thread.sleep(5000);
		PageUtilities.clickonanElement(pendingapprovaltab); 
		PageUtilities.enterText(pendingapprovalsearch,DateUtility.getCurrentDate());   
		
	}
   public void searchallapplicationbyName(String name) throws InterruptedException {
		//WaitUtility.waitForVisibilityofElement(driver,allleaveapplicationtab);
		Thread.sleep(5000);
		PageUtilities.clickonanElement(allleaveapplicationtab);
		PageUtilities.enterText(leavesearch,name);
       
		
	}
  
   
  public void clickonEditLeave() {
	  PageUtilities.clickonanElement(editleave);
  }
  public void approveLeave() {
	  WaitUtility.waitForVisibilityofElement(driver, approveleavebutton);
	  PageUtilities.clickonanElement(approveleavebutton);
  }

  

  public String dateXpathConstructor(String currentDate) {
	  String datexpath="//tr[@class='odd' or @class='even']//td[text()='"+currentDate+"']";
	  System.out.println(datexpath);
	  return datexpath;
  }
  public boolean isLeaveAssigned() {
	  System.out.println(DateUtility.getCurrentDate());
	  WebElement element=driver.findElement(By.xpath(dateXpathConstructor(DateUtility.getCurrentDate())));
	  return (element.isDisplayed());
  }

  public String dateAndStatusXpathConstructor(String currentDate,String status) {
	  String dateandstatusxapth="//tr[td[text()='"+currentDate+"']and//span[text()='"+status+"']] ";
	  System.out.println(dateandstatusxapth);
	  return dateandstatusxapth;
  }
  public boolean isLeaveApproved() {
	  
	  WebElement element=driver.findElement(By.xpath(dateAndStatusXpathConstructor(DateUtility.getCurrentDate(),"Approved")));
	  return (element.isDisplayed());
  }
 public boolean isLeaveRejected() {
	  
	  WebElement element=driver.findElement(By.xpath(dateAndStatusXpathConstructor(DateUtility.getCurrentDate(),"Rejected")));
	  return (element.isDisplayed());
  }
 public boolean isLeaveCancelled() {
	  
	  WebElement element=driver.findElement(By.xpath(dateAndStatusXpathConstructor(DateUtility.getCurrentDate(),"Canceled")));
	  return (element.isDisplayed());
 }
  public void rejectLeave() {
	  PageUtilities.clickonanElement(rejectleaveButton);
  }
  public void clickonDeleteLeave() {
	  PageUtilities.clickonanElement(deleteleavElement);
  }
  public void deleteLeaveRequest() {
	  PageUtilities.clickonanElement(confirmDeletebutton);
  }
  public String isLeaveDeleted() {
	  WaitUtility.waitForTexttoBePresentinElement(driver, leavecellvalue,"No record found." );
	  return (leavecellvalue.getText());
  }
  public void cancelLeave() {
	  PageUtilities.clickonanElement(cancelleaveButton);
  }
   
}
