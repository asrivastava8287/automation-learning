package FrameworkRestApi.com.utility;

import java.lang.reflect.Method;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;

import FrameworkRestApi.com.setup.Apisetup;

public class DProviderClass extends Apisetup {

	
	
	
	@DataProvider(name="dp")
	public static Object[][] getData(Method m) {

		System.out.println("666666666666666666666666666666666666666666666666666666666");
		System.out.println("SheetName-->"+config.testDataSheetName());
		String sheetName=config.testDataSheetName();
		int rows = excel.getRowCount(sheetName);//100
		
		System.out.println("roewssssss" + rows);
		
		String testName = m.getName();
		int testCaseRowNum = 1;

		for (testCaseRowNum = 1; testCaseRowNum <= rows; testCaseRowNum++) {

			String testCaseName = excel.getCellData(sheetName, 0, testCaseRowNum);
			//System.out.println("TestCase name in excel-->"+testCaseName);
			if (testCaseName.equalsIgnoreCase(testName))
				System.out.println("hhhhhhhhhhh" +testCaseName);
				break;

		}// Checking total rows in test case
		System.out.println("TestCase starts from:- "+testCaseRowNum);

		int dataStartRowNum = testCaseRowNum + 2;//dataStartRowNum=3
		
		System.out.println("11111111111111111111111111111111111");

		int testRows = 0;
		while (!excel.getCellData(sheetName, 0, dataStartRowNum + testRows).equals("endOfTestData")) {

			testRows++;//1
		}
		// Checking total cols in test case

		System.out.println("Total no of rows:"+testRows);
		int colStartColNum = testCaseRowNum + 1;//2
		int testCols = 0;

		while (!excel.getCellData(sheetName, testCols, colStartColNum).equals("")) {

			testCols++;

		}
		System.out.println("Total no of columns:"+testCols);
		
		Object[][] data = new Object[testRows][1];
		//object[][] data= new Object[2][1];
		//data[0][0]=
		//data[1][0]=

		int i = 0;
		for (int rNum = dataStartRowNum; rNum < (dataStartRowNum + testRows); rNum++) {

			Hashtable<String, String> table = new Hashtable<String, String>();

		
			for (int cNum = 0; cNum < testCols; cNum++) {

				String colName = excel.getCellData(sheetName, cNum, colStartColNum);
				String testData = excel.getCellData(sheetName, cNum, rNum);
				

				table.put(colName, testData);

			}

			data[i][0] = table;
			i++;

		}

		System.out.println("5555555555555555555555555");
		return data;
	}
}
