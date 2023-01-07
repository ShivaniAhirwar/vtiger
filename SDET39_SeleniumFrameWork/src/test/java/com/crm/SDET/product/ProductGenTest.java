package com.crm.SDET.product;

import org.testng.Assert;
import org.testng.annotations.Test;

import comcast.vtiger.genericUtility.BaseClass;
import comcast.vtiger.genericUtility.Excel_utility;
import comcast.vtiger.genericUtility.Java_Utility;
import comcast.vtiger.objectRepository.CreateProduct;
import comcast.vtiger.objectRepository.HomePage;
import comcast.vtiger.objectRepository.ProductPage;
import comcast.vtiger.objectRepository.ProductValidation;

public class ProductGenTest extends BaseClass
{

	@Test(groups= {"Smoke Testing","Regression Testing"})
	public void createProduct()throws Throwable
	   {
		extentTest.info("homepage opened");
		HomePage homePage = new HomePage(driver);
		  homePage.productModule();

		  ProductPage productPage = new ProductPage(driver);
		  productPage.newProduct();
		   Java_Utility javaLib=new Java_Utility();
		   int random = javaLib.getRandomNum();

		   Excel_utility excelLib=new Excel_utility();
		    String excelData = excelLib.getExcelValue("Sheet1",1,1)+random;
		    HomePage home=new HomePage(driver);
		    home.productModule();

		   ProductPage addpro=new ProductPage(driver);
		   addpro.newProduct();
		   CreateProduct createProPage=new CreateProduct(driver);
		   createProPage.createProduct(excelData);

		  ProductValidation proTitle=new ProductValidation(driver);
		    String actualTitle = proTitle.actualProductData();

		    Assert.assertEquals(actualTitle.contains(excelData),true);
		    extentTest.pass("test got passed");
		   home.imgForSignOut();
		   home.signOutLink();
		   driver.close();
	   }

}
