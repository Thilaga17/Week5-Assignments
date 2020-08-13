package week5.day1.TestNG;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class EditLead extends BaseClass
{
	@BeforeTest
	public void setFile()
	{
		excelName = "EditLead";
	}
	
	@Test(dataProvider = "fetchdata")
	public void runEditLead(String fName, String Company) throws InterruptedException
	{
		
		driver.findElementByXPath("//a[text() = 'Leads']").click();
		driver.findElementByXPath("//a[text() = 'Find Leads' ]").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']//input[@type='text' and @name ='firstName']").sendKeys(fName);
		driver.findElementByXPath("//button[@class ='x-btn-text' and text() = 'Find Leads' ]").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a").click();	
		Thread.sleep(3000);
		String title = driver.getTitle();
		String Expected = "View Lead | opentaps CRM";
		
		if(title.equals(Expected))
		{
			System.out.println("Title of the Page is : " + title );
		}
		else
		{
			System.out.println("Title is wrong");
		}
		
		driver.findElementByXPath("//a[text() ='Edit']").click();
		
		driver.findElementByXPath("//input[@id = 'updateLeadForm_companyName']").clear();
		driver.findElementByXPath("//input[@id = 'updateLeadForm_companyName']").sendKeys(Company);
		
		driver.findElementByXPath("//input[@name ='submitButton' and @value = 'Update']").click();
		
		//Confirm the changed name appears
		String NewCompanyName = driver.findElementByXPath("//span[@id = 'viewLead_companyName_sp']").getText();
		System.out.println("Company Name was changed to - " + NewCompanyName);
					
	}

}
