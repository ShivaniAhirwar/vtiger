package com.crm.campaign;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import comcast.vtiger.genericUtility.BaseClass;
import comcast.vtiger.genericUtility.Excel_utility;
import comcast.vtiger.genericUtility.Java_Utility;
import comcast.vtiger.objectRepository.AddCampaign;
import comcast.vtiger.objectRepository.CampaignPage;
import comcast.vtiger.objectRepository.CampaignValidation;
import comcast.vtiger.objectRepository.HomePage;

@Listeners(comcast.vtiger.genericUtility.ListenerImplimentationClass.class)
public class CreateCampaignFromGenTest extends BaseClass
{

	@Test(testName="CampaignTest", groups={"Smoke Testing","Regression Testing"})
	public void createCampaign() throws Throwable
	{
		extentTest.info("opening the homepage");
		   HomePage home=new HomePage(driver);
		   home.moreLink(driver);

		 home.campaignModule();

			CampaignPage addcampaign=new CampaignPage(driver);
			addcampaign.newCampaignPage();
			Java_Utility javaLib=new Java_Utility();
			int ran = javaLib.getRandomNum();

			  Excel_utility excelLib=new Excel_utility();
			 String campaignName = excelLib.getExcelValue("Sheet1",1,1)+ran;
			 AddCampaign createcampaign=new AddCampaign(driver);
			 createcampaign.campaignTextField(campaignName);
			 createcampaign.saveButton();

				CampaignValidation campVali=new CampaignValidation(driver);
				String actualTitleOrg = campVali.actualOrgData();
				Assert.assertEquals(actualTitleOrg.contains(campaignName),true);
				extentTest.pass("test is pass");
		     home.imgForSignOut();
		     home.signOutLink();
				 driver.close();
		}
}
