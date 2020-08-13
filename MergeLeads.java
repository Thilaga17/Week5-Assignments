
package week5.day1.TestNG;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MergeLeads extends BaseClass
{
	@BeforeTest
	public void setFile()
	{
		excelName = "MergeLeads";
	}
		
	@Test(dataProvider = "fetchdata")
	public void runMergeLeads(String LeadID1, String LeadID2) throws InterruptedException
	{
		driver.findElementByXPath("//a[text() = 'Leads']").click();
		
		driver.findElementByXPath("//a[text() = 'Merge Leads']").click();
		
		driver.findElementByXPath("(//a/img[@alt = 'Lookup'])[1]").click();
		
		Set<String> allWindowHandles = driver.getWindowHandles();
		List<String> listHandle = new ArrayList<String>(allWindowHandles);
		String secondWindow = listHandle.get(1);
		driver.switchTo().window(secondWindow);
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		
		driver.findElementByXPath("//label[text() = 'Lead ID:']/following::input[@name = 'id']").sendKeys(LeadID1);
		
		driver.findElementByXPath("//button[text() = 'Find Leads']").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		String firstWindow = listHandle.get(0);
		driver.switchTo().window(firstWindow);
		
		driver.findElementByXPath("(//a/img[@alt = 'Lookup'])[2]").click();
		//driver.switchTo().window(secondWindow);
		Set<String> allWindowHandles1 = driver.getWindowHandles();
		List<String> listHandle1 = new ArrayList<String>(allWindowHandles1);
		String childWindow = listHandle1.get(1);
		driver.switchTo().window(childWindow);
		
		driver.findElementByXPath("//label[text() = 'Lead ID:']/following::input[@name = 'id']").sendKeys(LeadID2);
		
		driver.findElementByXPath("//button[text() = 'Find Leads']").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		
		String parentWindow = listHandle1.get(0);
		driver.switchTo().window(parentWindow);
		
		driver.findElementByXPath("//a[text() = 'Merge']").click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		driver.findElementByXPath("//a[text() = 'Find Leads']").click();
		driver.findElementByXPath("//input[@name = 'id']").sendKeys(LeadID1);
		driver.findElementByXPath("//button[text() = 'Find Leads']").click();
		String text = driver.findElementByXPath("//div[@class = 'x-paging-info']").getText();
		System.out.println(text);
		
		if(text.contains("No"))
		{
			System.out.println("MergeLeads Successful");
		}
		else
		{
			System.out.println("MergeLeads not successful");
		}
	}

}
