package com.AmazonMaven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven1 {
	static String value;
	public static String singleDataValue(String name, int rowNo, int cellNo) throws IOException {
		File f = new File("C:\\Users\\sony\\Desktop\\Book1.xlsx");
		FileInputStream fs = new FileInputStream(f);
		Workbook workbook= new XSSFWorkbook(fs);
		Sheet sheet = workbook.getSheet(name);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		CellType cellType = cell.getCellType();
		
		if(cellType.equals(CellType.STRING)) {
			value = cell.getStringCellValue();
		}
		else if (cellType.equals(CellType.NUMERIC)) {
			double numericCellValue = cell.getNumericCellValue();
			int value1 = (int) numericCellValue;
			value= String.valueOf(value1);
			
		}
		return value;

}
	public static void all_Data() throws IOException {
		File f = new File("C:\\Users\\sony\\Desktop\\Book1.xlsx");
		FileInputStream fs = new FileInputStream(f);
		Workbook wb= new XSSFWorkbook(fs);
		Sheet sheet = wb.getSheet("Sheet1");
		int numberOfRows = sheet.getPhysicalNumberOfRows();
		for (int i = 0; i < numberOfRows; i++) {
			Row row = sheet.getRow(i);
			int numberOfCells = row.getPhysicalNumberOfCells();
			for (int j = 0; j < numberOfCells; j++) {
				Cell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				
				if(cellType.equals(CellType.STRING)) {
					String stringCellValue = cell.getStringCellValue();
					System.out.print(stringCellValue);
				}
				else if (cellType.equals(CellType.NUMERIC)) {
					double numericCellValue = cell.getNumericCellValue();
					int value = (int) numericCellValue;
					System.out.print(value);
				}
				System.out.print("-");
			}
			System.out.println();
		}
		
	}
	public static void Write_Data() throws IOException {
		File f = new File("C:\\Users\\sony\\Desktop\\Book1.xlsx");
		FileInputStream fs = new FileInputStream(f);
		Workbook wb= new XSSFWorkbook(fs);
		Sheet sheet = wb.createSheet("Project1");
		
		Row crRow = sheet.createRow(0);
		Cell crCell = crRow.createCell(0);
		crCell.setCellValue("DataDriven");
		wb.getSheet("Project1").createRow(1).createCell(2).setCellValue("Framework");
		FileOutputStream fileOutputStream = new FileOutputStream(f);
		wb.write(fileOutputStream);
		wb.close();

	}
	public static void main(String[] args) throws IOException {
		//DataDriven1.singleDataValue();
		DataDriven1.all_Data();
		//DataDriven1.Write_Data();
		
	}
}
