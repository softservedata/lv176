package com.softserve.edu.atqc.data.apps;

//For XLS file: HSSFWorkbook & HSSFSheet
//For XLSX file: XSSFSheet & XSSFSheet

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadDataFromFile {
	private static HSSFSheet TableSheet;
	private static HSSFWorkbook TableBook;
	private static HSSFCell Cell;
	// private static XSSFRow Row;

	// -----open the table--\\
	public static void setTableFile(String Path, String SheetName) throws Exception {
		FileInputStream TableFile = new FileInputStream(Path);
		TableBook = new HSSFWorkbook(TableFile);
		TableSheet = TableBook.getSheet(SheetName);

	}

	// ---read the test data from the cell--\\

	public static String getCellData(int Row, int Column) throws Exception {
		Cell = TableSheet.getRow(Row).getCell(Column);
		
		String CellData =  Cell.getStringCellValue();
		return CellData;
	}

	public static void setUsersTableFile() throws Exception {
		setTableFile(TestDataPath.Path_TestData + TestDataPath.File_TestData, "users");
	}

	public static void setLocalizationDataTableFile() throws Exception {
		setTableFile(TestDataPath.Path_TestData + TestDataPath.File_TestData, "localization");
	}
}
