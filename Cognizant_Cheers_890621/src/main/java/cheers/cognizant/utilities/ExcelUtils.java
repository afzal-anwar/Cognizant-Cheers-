package cheers.cognizant.utilities;

import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static XSSFWorkbook workbook2;
	static XSSFSheet sheet2;
	static FileOutputStream outFile;

	// Writing to excel sheet taking arraylists as parameters
	public static void writeToExcel(ArrayList<String>... list) {
		try {
			// Creating a output File
			outFile = new FileOutputStream(System.getProperty("user.dir") + "\\ExcelOutput\\" + "ExcelReport_"
					+ System.currentTimeMillis() + ".xlsx");
			// Creating instance of XSSFWorkbook
			workbook2 = new XSSFWorkbook();
			// Create first/desired sheet from the workbook
			sheet2 = workbook2.createSheet("Test Report");
			// Traversing the arraylist and Storing the data in the created excel sheet
			for (ArrayList<String> i : list) {
				int lastRowNumber = sheet2.getLastRowNum();
				if (lastRowNumber != 0)
					lastRowNumber += 2;
				for (int j = lastRowNumber; j < i.size() + lastRowNumber; j++) {
					Row r = sheet2.createRow(j);
					r.createCell(0).setCellValue(i.get(j - lastRowNumber));
				}
			}
			workbook2.write(outFile); // Writing the workbook in the created output file
			workbook2.close(); // closing the workbook
			outFile.close(); // Closing the file
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Method to read the data taking Excel File Name and Excel sheetname as
	// parameter
	public ExcelUtils(String excelPath, String sheetName) {
		try {
			String path = System.getProperty("user.dir") + "\\TestData\\" + excelPath + ".xlsx";
			workbook = new XSSFWorkbook(path);
			sheet = workbook.getSheet(sheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Getting the number of rows in the sheet
	public static int getRowCount() {
		int rowCount = 0;
		try {

			rowCount = sheet.getPhysicalNumberOfRows();

		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			;
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return rowCount;

	}

	// Getting the number of columns in the sheet
	public static int getColCount() {
		int colCount = 0;
		try {

			colCount = sheet.getRow(1).getPhysicalNumberOfCells();

		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			;
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return colCount;

	}

	// Method to get the cell data of the sheet taking row number and column number
	// as parameter
	public static String getCellData(int rowNum, int colNum) {
		try {

			Cell cell = sheet.getRow(rowNum).getCell(colNum);
			CellType type = cell.getCellType();
			if (type == CellType.STRING) {
				String values = cell.getStringCellValue();
				// Returning "" as value if the cell data is "null"
				if (values.equalsIgnoreCase("null"))
					return "";
				else
					return values;
			}
			// Typecasting the cell Data of Numeric and Formula Type to string
			else if (type == CellType.NUMERIC || type == CellType.FORMULA) {
				String cellText = String.valueOf((long) cell.getNumericCellValue());
				return cellText;
				// returning "" if cell is blank
			} else if (type == CellType.BLANK)
				return "";
			// Typecasting the cell Data of Boolean Type to string
			else if (type == CellType.BOOLEAN)
				return String.valueOf(cell.getBooleanCellValue());
			else
				return String.valueOf(cell.getStringCellValue());

		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
			return null;
		}

	}

	// Returning cell data number
	public static void getCellDataNumber(int rowNum, int colNum) {
		try {

			double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			System.out.println(cellData);

		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}

}
