package com.softserveinc.edu.ita.utils;

//For XLS file: HSSFWorkbook & HSSFSheet
//For XLSX file: XSSFSheet & XSSFSheet

import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.*;

public class TableUtils {
	private static HSSFSheet TableSheet;
	private static HSSFWorkbook TableBook;
	private static HSSFCell Cell;
	// private static XSSFRow Row;

	// -----open the table--\\
	public static void setTableFile(String Path, String SheetName) throws Exception {
		try {
			FileInputStream TableFile = new FileInputStream(Path);
			TableBook = new HSSFWorkbook(TableFile);
			TableSheet = TableBook.getSheet(SheetName);
		} catch (Exception e) {
			throw (e);
		}
	}

	// ---read the test data from the cell--\\

	public static String getCellData(int Row, int Column) throws Exception {
		try {
			Cell = TableSheet.getRow(Row).getCell(Column);
			String CellData = Cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {
			return "";
		}
	}
	
	public static void setUsersTableFile () throws Exception{
		setTableFile(Constants.Path_TestData + Constants.File_TestData, "users");
	}
	
	public static void setLocalizationDataTableFile () throws Exception{
		setTableFile(Constants.Path_TestData + Constants.File_TestData, "localization");
	}
}