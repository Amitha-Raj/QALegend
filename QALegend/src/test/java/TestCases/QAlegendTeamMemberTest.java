package TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.PublicKey;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AutomationCore.BaseClass;
import Constants.Constant;
import PageClasses.QALegendHomePage;
import PageClasses.QALegendLoginPage;
import PageClasses.QALegendTeamMemberPage;
import Utilities.ExcelUtility;
import Utilities.Fakerutility;
import Utilities.RetryAnalyser;

public class QAlegendTeamMemberTest extends BaseClass{
	WebDriver driver;
	QALegendLoginPage loginPage;
	QALegendHomePage homePage;
	QALegendTeamMemberPage teamMemberPage;
	Properties prop;
	FileInputStream fis;
	
	@BeforeMethod(groups = {"regression"})
	@Parameters({"Browser"})
	public void Initialization(String browser) throws Exception {
		driver=browserinitialisation(browser);
		driver.get("https://qalegend.com/crm/index.php/signin");
		loginPage =new QALegendLoginPage(driver);
		homePage=new QALegendHomePage(driver);
		teamMemberPage=new QALegendTeamMemberPage(driver);
		String basePath = System.getProperty("user.dir")+"//src//test//resources//TestData//UserDetails.properties";
		prop=new Properties();
		fis=new FileInputStream(basePath);
		prop.load(fis);
	}
	@Test(priority = 1,groups = {"regression"},retryAnalyzer = RetryAnalyser.class)
	public void addTeamMember(){
		loginPage.loginToQALegend(prop.getProperty("username"),prop.getProperty("password"));
		homePage.clickonTeamMemberMenu();
		teamMemberPage.clickonAddMember();
		String firstname=Fakerutility.getFirstFakename();
		String lastname=Fakerutility.getFakeLastName();
		String emailid="teammember"+Fakerutility.randomNumberGenerator()+"@gmail.com";
		teamMemberPage.addMember(firstname, lastname,prop.getProperty("teammemberrole"),emailid ,prop.getProperty("teammemberpassword"));
		teamMemberPage.searchMember(emailid);
		Assert.assertEquals(teamMemberPage.cellvalueFind(), true);
		
	}
	@Test(priority = 2,groups = {"regression"},retryAnalyzer = RetryAnalyser.class	)
	public void deleteTeamMember() throws IOException  {
		loginPage.loginToQALegend(prop.getProperty("username"),prop.getProperty("password"));
		homePage.clickonTeamMemberMenu();
		teamMemberPage.clickonAddMember();
		String firstname=ExcelUtility.readStringData(2, 0, "Teammembers", Constant.EXCELFILEPATH)+Fakerutility.randomNumberGenerator();
		String lastname=ExcelUtility.readStringData(2, 1, "Teammembers", Constant.EXCELFILEPATH)+Fakerutility.randomNumberGenerator();
		String emailid=ExcelUtility.readStringData(2, 2, "Teammembers", Constant.EXCELFILEPATH)+Fakerutility.randomNumberGenerator()+"@gmail.com";
		String jobtitle=ExcelUtility.readStringData(2, 3, "Teammembers", Constant.EXCELFILEPATH);
		String password=ExcelUtility.readStringData(2, 4, "Teammembers", Constant.EXCELFILEPATH);
		teamMemberPage.addMember(firstname, lastname,jobtitle,emailid ,password);
		teamMemberPage.searchMember(emailid);
		teamMemberPage.clickonDelete();
		teamMemberPage.confirmDeletepopup();
		teamMemberPage.searchMember(emailid);
		Assert.assertEquals(teamMemberPage.confirmDeletion(), "No record found.");
		
		
	}
	
	
	
	

}
