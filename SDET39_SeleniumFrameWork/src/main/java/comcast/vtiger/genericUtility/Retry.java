package comcast.vtiger.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer
{
    int count=0;
    int retryLimt=3;
	public boolean retry(ITestResult result) 
	{
		if(count<retryLimt)
		{
			count++;
			return true;
		}
		return false;
	}

}
