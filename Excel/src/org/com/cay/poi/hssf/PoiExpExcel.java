package org.com.cay.poi.hssf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * 1997-2003版Excel
 * @author Cam
 *
 */
public class PoiExpExcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] header = {"id","name","sex"};
		//创建工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();
		//创建工作表
		HSSFSheet sheet = workbook.createSheet();
		
		//创建第一行
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = null;
		for(int i = 0;i < header.length;++i){
			cell = row.createCell(i);
			cell.setCellValue(header[i]);
		}
		
		//追加数据
		for(int i = 1;i <= 10;++i){
			HSSFRow nextrow = sheet.createRow(i);
			HSSFCell cell2 = nextrow.createCell(0);
			cell2.setCellValue("a" + i);
			
			cell2 = nextrow.createCell(1);
			cell2.setCellValue("user" + i);
			
			cell2 = nextrow.createCell(2);
			cell2.setCellValue("male");
		}
		
		File file = new File("poi_test.xls");
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
