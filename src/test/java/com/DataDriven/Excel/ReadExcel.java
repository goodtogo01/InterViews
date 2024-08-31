package com.DataDriven.Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
 
	public static void main(String[] args) throws IOException {

		// create an object of file class for open excel
		File file = new File("C:\\Users\\zaman\\eclipse-workspace\\Automation\\employee.xlsx");
		
		// Create an object for FileInputStream class to read excel data
		FileInputStream inputStream = new FileInputStream(file);
		
	
		
		//Create Workbook instance that refers to .xls file
		  XSSFWorkbook wb= new XSSFWorkbook(inputStream);
		
		// Create a sheet object using the sheet name
		XSSFSheet sheet = wb.getSheet("employee1");
		
		
		// Create a row bject to retrieve row at index 1
		XSSFRow row2 = sheet.getRow(1);
		
		// Create a cell object to retrieve cell at 5
		XSSFCell cell = row2.getCell(5);
		
		//Get the address in a variable
		String address = cell.getStringCellValue();
		
		// Print the address
		System.out.println("Address is : "+address.toString());
		
		System.out.println(fac(10));
	}
	
	public static int fac(int n) {
		if(n==1)
			return 1;
		return n * fac(n-1);
	}
}

/*
 * 
		for(Object m:row2) {
			System.out.println(m.toString());
		}
	 */
