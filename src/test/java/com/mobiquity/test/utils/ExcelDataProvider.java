package com.mobiquity.test.utils;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

import static com.mobiquity.test.utils.Constants.excelFilePath;

public class ExcelDataProvider {
    public XSSFWorkbook wb;
    public FileInputStream fis;

    public ExcelDataProvider() {
        File src = new File(System.getProperty("user.dir")+excelFilePath);
        try {
            fis = new FileInputStream(src);
            wb = new XSSFWorkbook(fis);
        } catch (Exception e) {
            System.out.println("Unable to read the Excel File" + e.getMessage());
        }
    }

    public String getStringData(int sheetIndex, int row, int column) {
        return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
    }

    public String getStringData(String sheetName, int row, int column) {
        return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
    }

    public double getNumericData(String sheetName, int row, int column) {
        return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
    }
}
