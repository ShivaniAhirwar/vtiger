package com.crm.campaign;

import org.testng.Assert;
import org.testng.annotations.Test;

import comcast.vtiger.genericUtility.BaseClass;
import comcast.vtiger.genericUtility.Excel_utility;
import comcast.vtiger.genericUtility.Java_Utility;
import comcast.vtiger.genericUtility.WebDriver_Utility;
import comcast.vtiger.objectRepository.AddCampaign;
import comcast.vtiger.objectRepository.CampaignPage;
import comcast.vtiger.objectRepository.CampaignValidation;
import comcast.vtiger.objectRepository.CreateProduct;
import comcast.vtiger.objectRepository.HomePage;
import comcast.vtiger.objectRepository.ProductPage;
import comcast.vtiger.objectRepository.ProductPopup;

public class CreateCampaignNproduct2Test extends BaseClass
{
	@Test(groups= {"Smoke Testing","Regression Testing"})

	public void createProAndCampaign() throws Throwable
	{
	extentTest.info("open homepage");	
		HomePage home=new HomePage(driver);
		  home.productModule();
		  ProductPage addPro=new ProductPage(driver);
		  addPro.newProduct();
		  WebDriver_Utility webLib=new WebDriver_Utility();
		  webLib.waitForPageLoad(driver);
		Java_Utility javaLib=new Java_Utility();
		int r = javaLib.getRandomNum();

		Excel_utility excelLib=new Excel_utility();
		String excelValue = excelLib.getExcelValue("Sheet1",1,0)+r;
			CreateProduct createPro=new CreateProduct(driver);
			 createPro.createProduct(excelValue);
			home.moreLink(driver);

		      home.campaignModule();

				CampaignPage addCampaign=new CampaignPage(driver);
				addCampaign.newCampaignPage();

			  String campaignPage = excelLib.getExcelValue("Sheet1",1,1)+r;
				AddCampaign createCampaignPage=new AddCampaign(driver);
				createCampaignPage.campaignTextField(campaignPage);

				createCampaignPage.proPlusButton();

				webLib.switchToWindow(driver,"Products&action");
				ProductPopup addProInCampaign=new ProductPopup(driver);
				addProInCampaign.addProduct(excelValue);
				Thread.sleep(2000);
				addProInCampaign.selectProductName();

					webLib.switchToWindow(driver, "Campaigns&action");
				    createCampaignPage.saveButton();

				    CampaignValidation campVali=new CampaignValidation(driver);
				    String actualTitleOrg = campVali.actualOrgData();
				   Assert.assertEquals(actualTitleOrg.contains(campaignPage),true);
				   extentTest.pass("test got passed");
					   home.imgForSignOut();
						home.signOutLink();
					 driver.close();

				}


}
