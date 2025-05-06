package TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AutomationCore.BaseClass;
import PageClasses.QALegendClientPage;
import PageClasses.QALegendHomePage;
import PageClasses.QALegendLeavePage;
import PageClasses.QALegendLoginPage;
import Utilities.Fakerutility;
import Utilities.RetryAnalyser;

public class QALegendClientTest extends BaseClass{
	WebDriver driver;
	QALegendLoginPage loginPage;
	QALegendHomePage homePage;
	QALegendClientPage clientPage;
	Properties prop;
	FileInputStream fis;
	
	@BeforeMethod(groups = {"regression","Sanity","Smoke"})
	@Parameters({"Browser"})
	public void Initialization(String browser) throws Exception {
		driver=browserinitialisation(browser);
		driver.get("https://qalegend.com/crm/index.php/signin");
		driver.manage().window().maximize();
	    loginPage =new QALegendLoginPage(driver);
		homePage=new QALegendHomePage(driver);
		clientPage=new QALegendClientPage(driver);
		String basePath = System.getProperty("user.dir")+"//src//test//resources//TestData//UserDetails.properties";
		prop=new Properties();
		fis=new FileInputStream(basePath);
		prop.load(fis);
	}
	@Test(priority = 1 ,groups = {"regression"},retryAnalyzer = RetryAnalyser.class)
	public void addClient(){
		loginPage.loginToQALegend(prop.getProperty("username"),prop.getProperty("password"));
		homePage.clickonClientMenu();
		clientPage.clickonAddClient();
		String companyname=Fakerutility.getFirstFakename();
		clientPage.addClient(companyname);
		clientPage.searchCLient(companyname);
		Assert.assertEquals(clientPage.isClientexist(), true);
		
	}
	@Test (priority = 2,groups = {"regression"},retryAnalyzer = RetryAnalyser.class)
	public void editClient(){
		loginPage.loginToQALegend(prop.getProperty("username"),prop.getProperty("password"));
		homePage.clickonClientMenu();
		clientPage.clickonAddClient();
		String companyname=Fakerutility.getFirstFakename();		
		clientPage.addClient(companyname);
		clientPage.searchCLient(companyname);
		clientPage.clickonEditClient();
		String address=Fakerutility.getFakeAddress();
		String city=Fakerutility.getFakecityname();
		String zipcode=Fakerutility.getFakeZipcode();
		String phonenumber=Fakerutility.generatePhoneNumber();
		clientPage.editClient(address, city, zipcode, phonenumber);
		clientPage.clickonEditClient();
		Assert.assertEquals(clientPage.isclientEditSuccess(address, city, zipcode, phonenumber), true);
		
		
	}
	@Test(priority = 3,groups = {"regression"},retryAnalyzer = RetryAnalyser.class)
	public void deleteClient(){
		loginPage.loginToQALegend(prop.getProperty("username"),prop.getProperty("password"));
		homePage.clickonClientMenu();
		clientPage.clickonAddClient();
		String companyname=Fakerutility.getFirstFakename();		
		clientPage.addClient(companyname);
		clientPage.searchCLient(companyname);
		clientPage.clickonDelete();
		clientPage.clickonDeleteConfirmation();
		Assert.assertEquals(clientPage.isClientDeleted(),"No record found.");
	}
	

	
}
