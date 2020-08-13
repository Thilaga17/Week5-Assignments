package week5.day1.TestNG;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import week5.day2.TestNG.ReadExcel;

public class BaseClass
{
	ChromeDriver driver;
	
	// excelName is a Global Variable, It will be used by all CReate,Edit,Delete,Duplicate Test cases
	public String excelName;
	
	@Parameters({"username" , "password"})
	
	
	@BeforeMethod
	public void login(String uName, String pWord) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		WebElement username = driver.findElementByXPath("//input[@id = 'username']");
		username.sendKeys(uName);
		
		WebElement passWord = driver.findElementByXPath("//input[@id = 'password']");
		passWord.sendKeys(pWord);
		
		WebElement login = driver.findElementByXPath("//input[@class = 'decorativeSubmit']");
		login.click();
		
		driver.findElementByXPath("//a[text()[normalize-space() = 'CRM/SFA']]").click();
		Thread.sleep(3000);
		
	}
	
	@AfterMethod
	public void closeBrowser()
	{		
		driver.close();
	}
	
	@DataProvider(name = "fetchdata")
	public String[][] sendData() throws IOException
	{
		// Calling ReadExcel program by passing file(excelName) to read and get the values from excel file.
		String[][] array = ReadExcel.excelData(excelName); 
		return array;
	}
}
