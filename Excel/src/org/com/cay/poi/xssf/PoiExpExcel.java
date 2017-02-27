package org.com.cay.poi.xssf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 高版本Excel
 * @author Cam
 *
 */
public class PoiExpExcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] header = {"id","name","sex"};
		//创建工作簿
		XSSFWorkbook workbook = new XSSFWorkbook();
		//创建工作表
		XSSFSheet sheet = workbook.createSheet();
		
		//创建第一行
		XSSFRow row = sheet.createRow(0);
		XSSFCell cell = null;
		for(int i = 0;i < header.length;++i){
			cell = row.createCell(i);
			cell.setCellValue(header[i]);
		}
		
		//追加数据
		for(int i = 1;i <= 10;++i){
			XSSFRow nextrow = sheet.createRow(i);
			XSSFCell cell2 = nextrow.createCell(0);
			cell2.setCellValue("a" + i);
			
			cell2 = nextrow.createCell(1);
			cell2.setCellValue("user" + i);
			
			cell2 = nextrow.createCell(2);
			cell2.setCellValue("male");
		}
		
		File file = new File("poi_test.xlsx");
		try {
			file.createNewFile();
			
			FileOutputStream fos = FileUtils.openOutputStream(file);
			workbook.write(fos);
			workbook.close();
			fos.close();
					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
