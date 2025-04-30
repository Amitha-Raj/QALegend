package AutomationCore;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BaseClass {
	
public WebDriver driver; // we create an instance for the interface WebDriver called driver
	
	public WebDriver browserinitialisation(String browsername) throws Exception {
		
		
		if(browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		/*else if (browsername.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}*/
		else if (browsername.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		}
		else {
			throw new Exception("Invalid browser name exception");
		}
		//set implict wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

}
