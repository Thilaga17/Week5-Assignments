package week5.day1.TestNG;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class CreateLead extends BaseClass
{
	@BeforeTest
	public void setFile()
	{
		excelName = "CreateLead";
	}
		
	@Test(dataProvider = "fetchdata")
	public void runCreateLead(String cName, String fName, String lName)
	{
		
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Create Lead").click();
		
		driver.findElementById("createLeadForm_companyName").sendKeys(cName);
		driver.findElementById("createLeadForm_firstName").sendKeys(fName);
		driver.findElementById("createLeadForm_lastName").sendKeys(lName);
		
		//Selecting "Employee" in source dropDown field by using VisibleText
		WebElement source = driver.findElementById("createLeadForm_dataSourceId");		
		Select dropDown = new Select(source);
		dropDown.selectByVisibleText("Employee");
		
		//Selecting "Pay Per Click Advertising" in marketingCampaignId using selectByValue:
		WebElement marketingcampaign = driver.findElementById("createLeadForm_marketingCampaignId");
		Select dropDown1 = new Select(marketingcampaign);
		dropDown1.selectByValue("9001");
		
		//Selecting "Telecommunications" in Industry using SelectByIndex
		WebElement industry = driver.findElementById("createLeadForm_industryEnumId");
		Select dropDown2 = new Select(industry);			// Selecting Industry Field
		List<WebElement> options = dropDown2.getOptions();  // Listing the  child elements from parent element(Industry).
		int size = options.size();							// Counting the child elements.
		dropDown2.selectByIndex(size - 2);
		
		//Selecting Corporation in OwnerShip field Using SelectbyIndex
		WebElement ownerShip = driver.findElementById("createLeadForm_ownershipEnumId");
		Select dropDown3 = new Select(ownerShip);
		List<WebElement> options1 = dropDown3.getOptions();
		int size1 = options1.size();
		dropDown3.selectByIndex(size1 -2);
		
		driver.findElementByXPath("//input[@id = 'createLeadForm_primaryPhoneCountryCode']").clear();
		driver.findElementByXPath("//input[@id = 'createLeadForm_primaryPhoneCountryCode']").sendKeys("+91");
		driver.findElementByXPath("//input[@id = 'createLeadForm_primaryPhoneNumber']").sendKeys("6380466792");
		driver.findElementByXPath("//input[@id = 'createLeadForm_primaryEmail']").sendKeys("thilagasabhaa@gmail.com");
		
		//Selecting India in Country Field Using SelectbyVisibletext
		WebElement country = driver.findElementById("createLeadForm_generalCountryGeoId");
		Select dropDown4 = new Select(country);
		dropDown4.selectByVisibleText("India");
		
		// Click on createLead button
		driver.findElementByClassName("smallSubmit").click();
		
		// Getting the title of the return page
		String title = driver.getTitle();
		System.out.println(title);
				
	}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

