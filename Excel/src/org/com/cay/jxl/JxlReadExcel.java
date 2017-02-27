package org.com.cay.jxl;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class JxlReadExcel {

	/**
	 * 解析jxlExcel
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//创建workbook
			Workbook workbook = Workbook.getWorkbook(new File("jxl_test.xls"));
			
			//获取工作表
			Sheet sheet = workbook.getSheet(0);
			
			for(int i = 0;i < sheet.getRows(); ++i){
				for(int j = 0;j < sheet.getColumns(); ++j){
					Cell cell = sheet.getCell(j, i);
					System.out.print(cell.getContents() + " ");
				}
				System.out.println();
			}
			workbook.close();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
