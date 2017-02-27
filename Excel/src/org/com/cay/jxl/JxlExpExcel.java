package org.com.cay.jxl;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class JxlExpExcel {

	/**
	 * JxlExcel文件的创建
	 * @param args
	 */
	public static void main(String[] args) {
		String[] header = {"id","name","sex"};
		File file = new File("jxl_test.xls");
		
		try {
			file.createNewFile();
			//创建工作簿
			WritableWorkbook workbook = Workbook.createWorkbook(file);
			//创建sheet
			WritableSheet sheet = workbook.createSheet("sheet1", 0);
			
			Label label = null;
			//第一行设置列名
			for(int i = 0;i < header.length; ++i){
				label = new Label(i, 0, header[i]);
				sheet.addCell(label);
			}
			
			//追加数据
			for(int i = 0;i < 10; ++i){
				label = new Label(0, i, "a" + i);
				sheet.addCell(label);
				
				label = new Label(1, i, "user" + i);
				sheet.addCell(label);
				
				label = new Label(2, i, "male");
				sheet.addCell(label);
			}
			
			workbook.write();
			workbook.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
