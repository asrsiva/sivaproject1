package com.freecrm.utils;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataUtil {

	public FileInputStream f=null;
	private XSSFWorkbook w=null;
	private XSSFSheet s=null;
	private XSSFRow r=null;
	private XSSFCell c=null;
	
	public String getCellData(String sheetName,int colNum,int rowNum){
		try{
			f=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/freecrm/testdata/CRMTest.xlsx");
			w=new XSSFWorkbook(f);
			s=w.getSheet(sheetName);
			r=s.getRow(rowNum);
			c=r.getCell(colNum);
			
			return c.getStringCellValue();
		}catch(Exception e){
			return c+"Col Not exsit"+r+"Row not exist";
		}
	}
	
	public static void main(String[] args) {
		DataUtil d=new DataUtil();
		System.out.println(System.getProperty("user.dir"));
		System.out.println(d.getCellData("Sheet1",2,1));
	}
	
	
	
}
