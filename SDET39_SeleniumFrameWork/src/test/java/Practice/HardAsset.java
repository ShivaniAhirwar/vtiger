package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAsset
{
   @Test
   public void createName()
   {
	   System.out.println("Step1");
	   System.out.println("Step2");
	   Assert.assertEquals("A","S");
	   System.out.println("Step3");
	   System.out.println("Step4");
   }
   @Test(priority=1)
   public void createDetails()
   {
	   System.out.println("==============================");
	   System.out.println("Step1");
	   System.out.println("Step2");
	   Assert.assertEquals("A","A");
	   System.out.println("Step3");
	   System.out.println("Step4");
   }
}
