package TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AutomationCore.BaseClass;
import PageClasses.QALegendHomePage;
import PageClasses.QALegendLeavePage;
import PageClasses.QALegendLoginPage;
import PageClasses.QALegendTeamMemberPage;

public class QALegendLeaveTest extends BaseClass{
	WebDriver driver;
	QALegendLoginPage loginPage;
	QALegendHomePage homePage;
	QALegendLeavePage leavePage;
	Properties prop;
	FileInputStream fis;
	
	@BeforeMethod
	@Parameters({"Browser"})
	public void Initialization(String browser) throws Exception {
		driver=browserinitialisation(browser);
		driver.get("https://qalegend.com/crm/index.php/signin");
		loginPage =new QALegendLoginPage(driver);
		homePage=new QALegendHomePage(driver);
		leavePage=new QALegendLeavePage(driver);
		
		String basePath = System.getProperty("user.dir")+"//src//test//resources//TestData//UserDetails.properties";
		prop=new Properties();
		fis=new FileInputStream(basePath);
		prop.load(fis);
	}
	
	@Test
	public void assignLeave() throws InterruptedException  {
		
		loginPage.loginToQALegend(prop.getProperty("username"),prop.getProperty("password"));
		homePage.clickonLeaveMenu();
		leavePage.clickonAssignLeave();
		leavePage.assignLeave(prop.getProperty("leavereason"));
		leavePage.searchLeavebyName();
		AssertJUnit.assertEquals(leavePage.isLeaveAssigned(),true);
	}
	
	@Test
	public void applyLeave() throws InterruptedException {
		loginPage.loginToQALegend(prop.getProperty("username"),prop.getProperty("password"));
		homePage.clickonLeaveMenu();
		leavePage.clickonApplyLeave();
		leavePage.applyLeave(prop.getProperty("leavereason"));
		leavePage.searchPendingLeavesByDate();
		AssertJUnit.assertEquals(leavePage.isLeaveAssigned(),true);
		
		
	}
	@Test
	public void approveLeave() throws InterruptedException {
		loginPage.loginToQALegend(prop.getProperty("username"),prop.getProperty("password"));
		homePage.clickonLeaveMenu();
		leavePage.clickonApplyLeave();
		leavePage.applyLeave(prop.getProperty("leavereason"));
		leavePage.searchPendingLeavesByDate();
		leavePage.clickonEditLeave();
		leavePage.approveLeave();
		leavePage.searchallapplicationbyName(prop.getProperty("applicantname"));
		AssertJUnit.assertEquals(leavePage.isLeaveApproved(), true);
	}
	@Test
	public void rejectLeave() throws InterruptedException {
		loginPage.loginToQALegend(prop.getProperty("username"),prop.getProperty("password"));
		homePage.clickonLeaveMenu();
		leavePage.clickonApplyLeave();
		leavePage.applyLeave(prop.getProperty("leavereason"));
		leavePage.searchPendingLeavesByDate();
		leavePage.clickonEditLeave();
		leavePage.rejectLeave();
		leavePage.searchallapplicationbyName(prop.getProperty("applicantname"));
		AssertJUnit.assertEquals(leavePage.isLeaveRejected(), true);
	}
	
	@Test
	public void cancelLeave() throws InterruptedException {
		loginPage.loginToQALegend(prop.getProperty("username"),prop.getProperty("password"));
		homePage.clickonLeaveMenu();
		leavePage.clickonApplyLeave();
		leavePage.applyLeave(prop.getProperty("leavereason"));
		leavePage.searchPendingLeavesByDate();
		leavePage.clickonEditLeave();
		leavePage.cancelLeave();
		leavePage.searchallapplicationbyName(prop.getProperty("applicantname"));
		AssertJUnit.assertEquals(leavePage.isLeaveCancelled(), true);
		
	}
	
	@Test
	public void deleteappliedLeave() throws InterruptedException {
		loginPage.loginToQALegend(prop.getProperty("username"),prop.getProperty("password"));
		homePage.clickonLeaveMenu();
		leavePage.clickonApplyLeave();
		leavePage.applyLeave(prop.getProperty("leavereason"));
		leavePage.searchPendingLeavesByDate();
		leavePage.clickonDeleteLeave();
		leavePage.deleteLeaveRequest();
		AssertJUnit.assertEquals(leavePage.isLeaveDeleted(),"No record found.");
	}

}
