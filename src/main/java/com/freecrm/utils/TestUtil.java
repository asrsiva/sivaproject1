package com.freecrm.utils;

public class TestUtil {

	public static Object [][] getData(DataUtil d,String sheetName,String tcName){
	
		int tcStartRow=0;
		while(!d.getCellData(sheetName, 0, tcStartRow).equals(tcName)){
			tcStartRow++;
		}
		System.out.println("TC start Row is: "+tcStartRow);
		
		int cols=0;
		int colStartRow=tcStartRow+1;
		while(!d.getCellData(sheetName, cols, colStartRow).equals("N")){
			cols++;
		}
		System.out.println(cols);
		
		int rows=0;
		int tcDatarow=tcStartRow+2;
		
		while(!d.getCellData(sheetName, 0, tcDatarow+rows).equals("N")){
			
			rows++;
		}
		System.out.println(rows);
		Object data[][]=new Object[rows][cols];
		int index=0;
		for(int rNum=tcDatarow;rNum<tcDatarow+rows;rNum++){
			for(int cNum=0;cNum<cols;cNum++){
				//System.out.println(d.getCellData(sheetName, cNum, rNum));
				data[index][cNum]=d.getCellData(sheetName, cNum, rNum);
			}
			index++;
		}
		return data;
		
	}
	
	
	public static void main(String[] args) {
		DataUtil d=new DataUtil();
		getData(d,"Sheet1","QuickJobSearch");
	}
}
