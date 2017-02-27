package org.com.cay.poi.hssf;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class PoiReadExcel {

	/**
	 * 读取poiExcel
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("poi_test.xls");
		try {
			//创建工作簿
			HSSFWorkbook workbook = new HSSFWorkbook(FileUtils.openInputStream(file));
			//获取工作表
			HSSFSheet sheet = workbook.getSheetAt(0);
			//HSSFSheet sheet = workbook.getSheet("Sheet0");
			int firstRowNum = 0;
			//获取当前工作表中最后一行的行号
			int lastRowNum = sheet.getLastRowNum();
			for(int i = firstRowNum;i <= lastRowNum;++i){
				HSSFRow row = sheet.getRow(i);
				//获取当前行最后单元格的列号
				int lastCellNum = row.getLastCellNum();
				for(int j = 0;j < lastCellNum;++j){
					HSSFCell cell = row.getCell(j);
					String value = cell.getStringCellValue();
					System.out.print(value + " ");
				}
				System.out.println();
			}
			workbook.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
