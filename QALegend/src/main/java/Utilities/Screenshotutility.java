package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

import org.apache.commons.compress.harmony.pack200.NewAttribute;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Screenshotutility {
	
	public void captureFailureScreenshot(WebDriver driver,String name) throws IOException {
		//TakesScreenshot is an interface to make the driver 
		TakesScreenshot scrshot= (TakesScreenshot)driver;
		File screenshot=scrshot.getScreenshotAs(OutputType.FILE);
		File f1=new File(System.getProperty("user.dir")+"//outputscreenshots");
		if(!f1.exists()) {
			f1.mkdirs();//create a directory (java)
		}
			String timestamp=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
			File finalDestinationFile= new File(System.getProperty("user.dir")+"//outputscreenshots//"+name+"_"+timestamp+".png");
		
			//copy from virtual space to destination
			org.openqa.selenium.io.FileHandler.copy(screenshot, finalDestinationFile);
	}

}
