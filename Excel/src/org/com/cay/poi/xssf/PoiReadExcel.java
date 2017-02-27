package org.com.cay.poi.xssf;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PoiReadExcel {

	/**
	 * 读取poiExcel
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("poi_test.xlsx");
		try {
			//创建工作簿
			XSSFWorkbook workbook = new XSSFWorkbook(FileUtils.openInputStream(file));
			//获取工作表
			XSSFSheet sheet = workbook.getSheetAt(0);
			//XSSFSheet sheet = workbook.getSheet("Sheet0");
			int firstRowNum = 0;
			//获取当前工作表中最后一行的行号
			int lastRowNum = sheet.getLastRowNum();
			for(int i = firstRowNum;i <= lastRowNum;++i){
				XSSFRow row = sheet.getRow(i);
				//获取当前行最后单元格的列号
				int lastCellNum = row.getLastCellNum();
				for(int j = 0;j < lastCellNum;++j){
					XSSFCell cell = row.getCell(j);
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
