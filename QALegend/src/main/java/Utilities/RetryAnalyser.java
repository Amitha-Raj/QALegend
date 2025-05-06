package Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.util.RetryAnalyzerCount;

public class RetryAnalyser implements IRetryAnalyzer {
 private int retrycount=0;
 private static final int MAX_RETRY_COUNT=4;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(retrycount<MAX_RETRY_COUNT)
		{
			retrycount++;
			return true;
		}
		return false;
	}

}
