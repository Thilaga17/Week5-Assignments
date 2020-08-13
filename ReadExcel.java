package week5.day2.TestNG;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel
{

	public static String[][] excelData(String fileName) throws IOException 
	{
		XSSFWorkbook wb = new XSSFWorkbook("./data/"+fileName+".xlsx");
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int noOfRows = sheet.getLastRowNum();
		System.out.println(noOfRows); //5
		short noOfCells = sheet.getRow(0).getLastCellNum();
		System.out.println(noOfCells); //3
		
		String[][] data = new String[noOfRows][noOfCells];
		
		for(int i =1;i<=noOfRows;i++)
		{
			for(int j=0;j<noOfCells;j++)
			{
				XSSFCell cell = sheet.getRow(i).getCell(j);
				String stringCellValue = cell.getStringCellValue();
				data[i-1][j] = stringCellValue;
				System.out.println(stringCellValue);
			}
		}
		wb.close();
		return data;
	}

	
	


}
