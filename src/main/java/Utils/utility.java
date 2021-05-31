package Utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class utility {
	
	public static Object[][] gettestdata() throws IOException
//public static void main (String []args ) throws IOException
	{

	FileInputStream fis = new FileInputStream("C://Users//TeenaSharma//Desktop//DATA.xlsx");
	
	XSSFWorkbook	workbook = new XSSFWorkbook (fis); //get my workbook 
	XSSFSheet sheet = workbook.getSheetAt(1);// get my sheet from workbook
	XSSFRow Row=sheet.getRow(1);   //get my Row which start from 1   
	   
	    	int RowNum = sheet.getPhysicalNumberOfRows();// count my number of Rows
	    	int ColNum= Row.getLastCellNum(); // get last ColNum 
	    	
	    	Object Data[][]= new Object[RowNum-1][ColNum]; // pass my  count data in array
	    	
	     for(int i=0; i<RowNum-1; i++) //Loop work for Rows
	     {  
	    	 XSSFRow row= sheet.getRow(i+1);
	     
	     for (int j=0; j<ColNum; j++) //Loop work for colNum
	     {
	     
	     String cell= row.getCell(j).getStringCellValue();
	     
	     
	    
	     Data[i][j]=cell;
	     System.out.println(Data[i][j]);
	     
	      
	     //This formatter get my all values as string i.e integer, float all type data value
	     }
	    
	     }
		return Data;
	 
	    }



	
		
	}

