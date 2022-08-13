package Practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAsset
{
	 @Test
	   public void createName()
	   {
		   System.out.println("Step1");
		   System.out.println("Step2");
		   SoftAssert s=new SoftAssert();
		   s.assertEquals("A","S");
		   System.out.println("Step3");
		   System.out.println("Step4");
		   s.assertAll();
	   }
	   @Test(priority=1)
	   public void createDetails()
	   {
		   System.out.println("==============================");
		   System.out.println("Step1");
		   System.out.println("Step2");
		  SoftAssert a=new SoftAssert();
		  a.assertEquals("X","Y");
		   System.out.println("Step3");
		   System.out.println("Step4");
		   a.assertAll();
	   }
}
