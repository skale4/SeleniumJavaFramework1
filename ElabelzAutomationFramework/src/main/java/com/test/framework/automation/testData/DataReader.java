package com.test.framework.automation.testData;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {
	
	  public static FileInputStream testData=null;	
	  public static XSSFSheet sheet = null;
	  public static XSSFRow row = null;
	  public static XSSFCell cell = null;
	  public static XSSFWorkbook wkBook=null;
	  
	  /*
	   * 
	   * Method to read data from excel
	   */
	
	public static String readExcel(String sheetName,int rowNum,String columnName)
	  {
		String cellValue = null;  
		String dateValue=null;
		try
		  {
			
			  testData=new FileInputStream("src/test/resources/TestData/Datasheet.xlsx");
			  wkBook=new XSSFWorkbook(testData);
			  int colNum=1;
			  sheet=wkBook.getSheet(sheetName);
			  row=sheet.getRow(0);
			  for(int i=0;i<row.getLastCellNum();i++)
			  {
				  if(row.getCell(i).getStringCellValue().trim().equals(columnName.trim()))
					  colNum=i;
			  }
			  row=sheet.getRow(rowNum-1);
			  cell=row.getCell(colNum);
			  
			  if(cell.getCellTypeEnum() == CellType.STRING)
				  cellValue= cell.getStringCellValue();
	          else if(cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA)
	           {
	        	  cellValue  =BigDecimal.valueOf(cell.getNumericCellValue()).toPlainString();
	        	  dateValue	=String.valueOf(cell.getNumericCellValue());
	        	  if(HSSFDateUtil.isCellDateFormatted(cell))
	                {
	                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	                    Date date = cell.getDateCellValue();
	                    dateValue = df.format(date);
	                    cellValue=dateValue;
	                }
	        	  
	           }else if(cell.getCellTypeEnum() == CellType.BLANK)
	        	   cellValue= "";
	            else
	            	cellValue= String.valueOf(cell.getBooleanCellValue());
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		return cellValue;
		  
	  }

}
