package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {
    public static FileInputStream fis;
    public static FileOutputStream fos;
    public static XSSFWorkbook wb;
    public static XSSFSheet ws ;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static XSSFCellStyle cellStyle;
    public static int getRowCount(String filePath,String sheetName) throws IOException {
        fis = new FileInputStream(filePath);
        wb = new XSSFWorkbook(fis);
        ws= wb.getSheet(sheetName);
        int rowCount = ws.getLastRowNum();
        wb.close();
        fis.close();
        return rowCount;
    }
    public static int getColumnCount(String filePath,String sheetName,int rownum ) throws IOException {
        fis = new FileInputStream(filePath);
        wb = new XSSFWorkbook(fis);
        ws= wb.getSheet(sheetName);
        row = ws.getRow(rownum);
        int cellCount = row.getLastCellNum();
        wb.close();
        fis.close();
        return cellCount;
    }
    public static String getCellData(String filePath, String sheetName,int rownum,int colnum) throws IOException {
        fis = new FileInputStream(filePath);
        wb = new XSSFWorkbook(fis);
        ws = wb.getSheet(sheetName);
        row = ws.getRow(rownum);
        cell = row.getCell(colnum);
        String data;
        try {
            //data=cell.toString();
            DataFormatter formatter = new DataFormatter();
            data = formatter.formatCellValue(cell);
        } catch (Exception e) {
            data = " ";
        }
        ;
        wb.close();
        fis.close();
        return data;
    }
    public static void setCellData(String filePath, String sheetName,int rownum,int colnum,String data) throws IOException {
        fis = new FileInputStream(filePath);
        wb = new XSSFWorkbook(fis);
        ws = wb.getSheet(sheetName);
        row = ws.getRow(rownum);
        cell = row.createCell(colnum);
        cell.setCellValue(data);
        fos = new FileOutputStream(filePath);
        wb.write(fos);
        wb.close();
        fis.close();
        fos.close();
    }
    public static void fillGreenColor(String filePath,String sheetName,int rownum,int colnum) throws IOException {
        fis = new FileInputStream(filePath);
        wb = new XSSFWorkbook(fis);
        ws= wb.getSheet(sheetName);
        row = ws.getRow(rownum);
        cell = row.getCell(colnum);
        cellStyle = wb.createCellStyle();
        cellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(cellStyle);
        fos = new FileOutputStream(filePath);
        wb.write(fos);
        wb.close();
        fis.close();
        fos.close();


    }
    public static void fillRedColor(String filePath,String sheetName,int rownum,int colnum) throws IOException {
        fis = new FileInputStream(filePath);
        wb = new XSSFWorkbook(fis);
        ws = wb.getSheet(sheetName);
        row = ws.getRow(rownum);
        cell = row.getCell(colnum);
        cellStyle = wb.createCellStyle();
        cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(cellStyle);
        fos = new FileOutputStream(filePath);
        wb.write(fos);
        wb.close();
        fis.close();
        fos.close();
    }

}
