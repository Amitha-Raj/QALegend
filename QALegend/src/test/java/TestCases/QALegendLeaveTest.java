package TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
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
import Utilities.RetryAnalyser;

public class QALegendLeaveTest extends BaseClass{
	WebDriver driver;
	QALegendLoginPage loginPage;
	QALegendHomePage homePage;
	QALegendLeavePage leavePage;
	Properties prop;
	FileInputStream fis;
	
	@BeforeMethod(groups = {"regression","Sanity","Smoke"})
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
	
	@Test (priority = 1,groups = {"regression"},retryAnalyzer = RetryAnalyser.class)
	public void assignLeave() {
		
		loginPage.loginToQALegend(prop.getProperty("username"),prop.getProperty("password"));
		homePage.clickonLeaveMenu();
		leavePage.clickonAssignLeave();
		leavePage.assignLeave(prop.getProperty("leavereason"));
		leavePage.searchLeavebyName();
		Assert.assertEquals(leavePage.isLeaveAssigned(),true);
	}
	
	@Test (priority = 2,groups= {"Sanity"},retryAnalyzer = RetryAnalyser.class)
	public void applyLeave() {
		loginPage.loginToQALegend(prop.getProperty("username"),prop.getProperty("password"));
		homePage.clickonLeaveMenu();
		leavePage.clickonApplyLeave();
		leavePage.applyLeave(prop.getProperty("leavereason"));
		leavePage.searchPendingLeavesByDate();
		Assert.assertEquals(leavePage.isLeaveAssigned(),true);
		
		
	}
	@Test(priority = 3,groups = {"Sanity"},retryAnalyzer = RetryAnalyser.class)
	public void approveLeave(){
		loginPage.loginToQALegend(prop.getProperty("username"),prop.getProperty("password"));
		homePage.clickonLeaveMenu();
		leavePage.clickonApplyLeave();
		leavePage.applyLeave(prop.getProperty("leavereason"));
		leavePage.searchPendingLeavesByDate();
		leavePage.clickonEditLeave();
		leavePage.approveLeave();
		leavePage.searchallapplicationbyName(prop.getProperty("applicantname"));
		Assert.assertEquals(leavePage.isLeaveApproved(), true);
	}
	@Test(priority = 4,groups = {"Sanity"},retryAnalyzer = RetryAnalyser.class)
	public void rejectLeave(){
		loginPage.loginToQALegend(prop.getProperty("username"),prop.getProperty("password"));
		homePage.clickonLeaveMenu();
		leavePage.clickonApplyLeave();
		leavePage.applyLeave(prop.getProperty("leavereason"));
		leavePage.searchPendingLeavesByDate();
		leavePage.clickonEditLeave();
		leavePage.rejectLeave();
		leavePage.searchallapplicationbyName(prop.getProperty("applicantname"));
		Assert.assertEquals(leavePage.isLeaveRejected(), true);
	}
	
	@Test(priority = 5,groups = {"Smoke"},retryAnalyzer = RetryAnalyser.class)
	public void cancelLeave(){
		loginPage.loginToQALegend(prop.getProperty("username"),prop.getProperty("password"));
		homePage.clickonLeaveMenu();
		leavePage.clickonApplyLeave();
		leavePage.applyLeave(prop.getProperty("leavereason"));
		leavePage.searchPendingLeavesByDate();
		leavePage.clickonEditLeave();
		leavePage.cancelLeave();
		leavePage.searchallapplicationbyName(prop.getProperty("applicantname"));
		Assert.assertEquals(leavePage.isLeaveCancelled(), true);
		
	}
	
	@Test(priority = 6,groups =  {"Smoke"},retryAnalyzer = RetryAnalyser.class)
	public void deleteappliedLeave(){
		loginPage.loginToQALegend(prop.getProperty("username"),prop.getProperty("password"));
		homePage.clickonLeaveMenu();
		leavePage.clickonApplyLeave();
		leavePage.applyLeave(prop.getProperty("leavereason"));
		leavePage.searchPendingLeavesByDate();
		leavePage.clickonDeleteLeave();
		leavePage.deleteLeaveRequest();
		Assert.assertEquals(leavePage.isLeaveDeleted(),"No record found.");
	}

}
