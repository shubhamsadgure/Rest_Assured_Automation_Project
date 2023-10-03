package api.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="AllData")
	public String [][] AllDataProvider(){

		String FName= System.getProperty("user.dir")+"//TestData//TestData.xlsx";

		int ttlRowCnt= ReadExcelFile.getRowCount(FName, "Sheet1");
		int ttlColCnt= ReadExcelFile.getColCount(FName, "Sheet1");

		String userData[][]=new String[ttlRowCnt-1][ttlColCnt];

		for(int rowNo=1; rowNo<ttlRowCnt; rowNo++) {

			for(int cloNo=0; cloNo<ttlColCnt; cloNo++) {

				userData[rowNo-1][cloNo]=ReadExcelFile.getCellValue(FName, "Sheet1", rowNo, cloNo);
			}
		}

		return userData;


	}
	
	
	
	@DataProvider(name="UserNameData")
	public String [] UserNameDataProvider(){

		String FName= System.getProperty("user.dir")+"//TestData//TestData.xlsx";

		int ttlRowCnt= ReadExcelFile.getRowCount(FName, "Sheet1");
		//int ttlColCnt= ReadExcelFile.getColCount(FName, "Sheet1");

		String userNamesData[]=new String[ttlRowCnt-1];

		for(int rowNo=1; rowNo<ttlRowCnt; rowNo++) {

			userNamesData[rowNo-1]=ReadExcelFile.getCellValue(FName, "Sheet1", rowNo, 1);
		}

		return userNamesData;


	}


}
