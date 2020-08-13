package week5.day1.TestNG;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DuplicateLead extends BaseClass
{
	@BeforeTest
	public void setFile() 
	{
		excelName = "DuplicateLead";
	}
		
	@Test(dataProvider = "fetchdata")
	public void runDuplicateLead(String emailId) throws InterruptedException 
	{
		driver.findElementByXPath("//a[text() = 'Leads']").click();
				
		driver.findElementByXPath("//a[text() = 'Find Leads' ]").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//span[text() = 'Email']").click();
		driver.findElementByXPath("//input[@name= 'emailAddress']").sendKeys(emailId);
		driver.findElementByXPath("//button[text() = 'Find Leads']").click();
		Thread.sleep(3000);
		
		driver.findElementByXPath("//div[@class= 'x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		
		String Name = driver.findElementByXPath("//span[@id = 'viewLead_firstName_sp']").getText();
		System.out.println("Name of the Lead is " + Name);
		
		driver.findElementByXPath("//a[text() = 'Duplicate Lead']").click();
		
		String Title = driver.findElementByXPath("//div[@id = 'sectionHeaderTitle_leads']").getText();
		System.out.println("The TITLE of the duplicate lead page is " + Title);
		
		driver.findElementByXPath("//input[@value = 'Create Lead' and @name = 'submitButton']").click();
		
		String DuplicateName = driver.findElementByXPath("//span[@id ='viewLead_firstName_sp']").getText();
		System.out.println("The duplicate name of the lead is " + DuplicateName );
		if (Name.equals(DuplicateName))
		{
			System.out.println("Both Actual name and Duplicate Name of the lead is same");
		}
	}


}
