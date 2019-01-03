package com.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.chainsaw.Main;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class ReadExcel {
	
	public ReadExcel(String file,String sheetname) throws  IOException
	{
		//Reading xlxs excel file through code
		int [][] arrayexceldata=null;
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook x=new XSSFWorkbook(fis);
		XSSFSheet sheet=x.getSheet(sheetname);
		XSSFRow row=sheet.getRow(2);
		XSSFCell cell=row.getCell(2);
		System.out.println(cell.getStringCellValue());
		int rowcount=sheet.getLastRowNum();
		int rows=rowcount+1;
		int columns=sheet.getRow(rowcount).getLastCellNum();
		System.out.println("The Number of rows are :"+rows);
		System.out.println("The Number of Column are :"+columns);
		arrayexceldata=new int[rows][columns];
		for(int i=0; i<rows; i++)
		{
			for(int j=0; j<columns; j++)
			{
				DataFormatter df=new DataFormatter();
				String val=df.formatCellValue(sheet.getRow(i).getCell(j));
				//System.out.println(val);
				ArrayList<String> al=new ArrayList<>();;
				al.add(val);
				for(int k=0;k<al.size();k++)
				{
					String Val1=al.get(k);
					System.out.println(Val1);
				}
			}
		}
		
		
	}
	
	/*public static void main(String args[])
	{
		
	}*/

}
