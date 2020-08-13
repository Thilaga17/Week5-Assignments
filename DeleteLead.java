package week5.day1.TestNG;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteLead extends BaseClass
{
	@BeforeTest
	public void setFile()
	{
		excelName = "DeleteLead";
	}
	
	@Test(dataProvider = "fetchdata")
	public void runDeleteLead(String cCode, String pNumber) throws InterruptedException
	{
			
		driver.findElementByXPath("//a[text() = 'Leads']").click();
				
		driver.findElementByXPath("//a[text() = 'Find Leads' ]").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//ul[@class = 'x-tab-strip x-tab-strip-top']/li[2]").click();
		
		driver.findElementByXPath("//input[@name = 'phoneCountryCode']").clear();
		driver.findElementByXPath("//input[@name = 'phoneCountryCode']").sendKeys(cCode);
		driver.findElementByXPath("//input[@name = 'phoneNumber']").sendKeys(pNumber);
		driver.findElementByXPath("//button[text() = 'Find Leads']").click();
		Thread.sleep(3000);
		
		String LeadsId = driver.findElementByXPath("//div[@class = 'x-grid3-body']//a").getText();
		System.out.println("The Lead Id is - " + LeadsId);
		driver.findElementByXPath("//div[@class = 'x-grid3-body']//a").click();
		Thread.sleep(3000);
		
		driver.findElementByXPath("//a[text() = 'Delete']").click();
		
		//Verify the id was deleted
		driver.findElementByXPath("//a[text() = 'Find Leads' ]").click();
		driver.findElementByXPath("//input[@name ='id']").sendKeys(LeadsId);
		driver.findElementByXPath("//button[text() = 'Find Leads']").click();
		Thread.sleep(3000);
		String text = driver.findElementByXPath("//div[@class = 'x-paging-info']").getText();
		System.out.println(text);
		String ActualText = "No records to display";
		if(text.equals(ActualText))
		{
			System.out.println(LeadsId + " was deleted Successfully ");	
		}
		
		}

}
