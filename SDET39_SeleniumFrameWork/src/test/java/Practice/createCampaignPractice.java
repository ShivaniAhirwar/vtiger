package Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import comcast.vtiger.genericUtility.BaseClass;
import comcast.vtiger.genericUtility.Excel_utility;
import comcast.vtiger.genericUtility.Java_Utility;
import comcast.vtiger.genericUtility.WebDriver_Utility;
import comcast.vtiger.objectRepository.AddCampaign;
import comcast.vtiger.objectRepository.CampaignPage;
import comcast.vtiger.objectRepository.HomePage;

public class createCampaignPractice extends BaseClass
{
	@Test
   public void campaignPractice() throws Throwable, IOException 
   {   
	  WebDriver_Utility webLib=new WebDriver_Utility();
	  webLib.waitForPageLoad(driver);
	  
	  HomePage home=new HomePage(driver);
	  home.moreLink(driver);
	  home.campaignModule();
	  
	 Excel_utility elib=new Excel_utility();
	 String camValue = elib.getExcelValue("Sheet1", 1, 1);
	 
	 Java_Utility jlib=new Java_Utility();
	 int ran = jlib.getRandomNum();
	 
	 CampaignPage camPage=new CampaignPage(driver);
	 camPage.newCampaignPage();
	 AddCampaign createCam=new AddCampaign(driver);
	 createCam.campaignTextField(camValue);
	 createCam.saveButton();
	 home.imgForSignOut();
	 home.signOutLink();
   }
}
