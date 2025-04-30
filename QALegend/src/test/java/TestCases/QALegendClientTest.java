package TestCases;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AutomationCore.BaseClass;
import PageClasses.QALegendClientPage;
import PageClasses.QALegendHomePage;
import PageClasses.QALegendLeavePage;
import PageClasses.QALegendLoginPage;
import Utilities.Fakerutility;

public class QALegendClientTest extends BaseClass{
	WebDriver driver;
	QALegendLoginPage loginPage;
	QALegendHomePage homePage;
	QALegendClientPage clientPage;
	Properties prop;
	FileInputStream fis;
	
	@BeforeMethod
	@Parameters({"Browser"})
	public void Initialization(String browser) throws Exception {
		driver=browserinitialisation(browser);
		driver.get("https://qalegend.com/crm/index.php/signin");
	    loginPage =new QALegendLoginPage(driver);
		homePage=new QALegendHomePage(driver);
		clientPage=new QALegendClientPage(driver);
		String basePath = System.getProperty("user.dir")+"//src//test//resources//TestData//UserDetails.properties";
		prop=new Properties();
		fis=new FileInputStream(basePath);
		prop.load(fis);
	}
	@Test
	public void addClient() {
		loginPage.loginToQALegend(prop.getProperty("username"),prop.getProperty("password"));
		homePage.clickonClientMenu();
		clientPage.clickonAddClient();
		String companyname=Fakerutility.getFirstFakename();
		String addressString=Fakerutility.getFakeAddress();
		String city=Fakerutility.getFakecityname();
		String zipcode=Fakerutility.getFakeZipcode();
		String phonenumber=Fakerutility.generatePhoneNumber();
		clientPage.addClient(companyname);
		clientPage.searchCLient(companyname);
		
	}

}
