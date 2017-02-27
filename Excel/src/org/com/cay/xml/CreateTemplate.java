package org.com.cay.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddressList;
import org.apache.poi.ss.util.CellRangeAddress;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;


public class CreateTemplate {

	/**
	 * 创建模版
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//获取解析xml文件路径
		String path = System.getProperty("user.dir") + "\\student.xml";
		//System.out.println(path);
		File file = new File(path);
		
		SAXBuilder builder = new SAXBuilder();
		try {
			//解析xml
			Document document = builder.build(file);
			//创建工作簿
			HSSFWorkbook wb = new HSSFWorkbook();
			//创建工作表
			HSSFSheet sheet = wb.createSheet("Sheet1");
			
			//获取xml文件根节点
			Element root = document.getRootElement();
			
			//获取模版名称
			String templateName = root.getAttributeValue("name");
			int rownum = 0;
			int column = 0;
			//设置列宽
			Element colgroup = root.getChild("colgroup");
			setColumnWidth(sheet, colgroup);
			
			//设置标题
			Element title = root.getChild("title");
			List<Element> trs = title.getChildren();
			for (Element tr : trs) {
				List<Element> tds = tr.getChildren();
				
				HSSFRow row = sheet.createRow(rownum);
				for(column = 0;column < tds.size(); ++column){
					Element td = tds.get(column);
					HSSFCell cell = row.createCell(column);
					HSSFCellStyle cellStyle = wb.createCellStyle();
					cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//设置居中
					
					Attribute rowSpan = td.getAttribute("rowspan");
					Attribute colSpan = td.getAttribute("colspan");
					Attribute valueattr = td.getAttribute("value");
					
					if(valueattr != null){
						String val = valueattr.getValue();
						cell.setCellValue(val);
						int rspan = rowSpan.getIntValue() - 1;
						int cspan = colSpan.getIntValue() - 1;
						
						//设置字体
						HSSFFont font = wb.createFont();
						font.setFontName("微软雅黑");
						font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
						font.setFontHeightInPoints((short)12);
						cellStyle.setFont(font);
						cell.setCellStyle(cellStyle);
						
						//合并单元格
						sheet.addMergedRegion(new CellRangeAddress(rspan, rspan, 0, cspan));
					}
				}
				rownum++;
			}
			
			//设置表头信息
			Element thead = root.getChild("thead");
			trs = thead.getChildren();
			//System.out.println(trs.size());
			for (Element tr : trs) {
				HSSFRow row = sheet.createRow(rownum);
				List<Element> ths = tr.getChildren("th");
				//System.out.println(ths.size());
				for (Element th : ths) {
					Attribute valueAttr = th.getAttribute("value");
					column = ths.indexOf(th);
					HSSFCell cell = row.createCell(column);
					if(valueAttr != null){
						String value = valueAttr.getValue();
						cell.setCellValue(value);
					}
				}
				rownum++;
			}
			
			//设置数据区样式
			Element tbody = root.getChild("tbody");
			Element tr = tbody.getChild("tr");
			int repeat = tr.getAttribute("repeat").getIntValue(); 
			List<Element> tds = tr.getChildren("td");
			//System.out.println(tds.size());
			for(int i = 0;i < repeat;++i){
				HSSFRow row = sheet.createRow(rownum);
				for(column = 0;column < tds.size();++column){
					Element td = tds.get(column);
					//System.out.println(td.getAttributeValue("type"));
					HSSFCell cell = row.createCell(column);
					setType(wb, cell, td);
				}
				rownum++;
			}
			
			//生成Excel模版
			File tmpfile = new File(templateName + ".xls");
			tmpfile.delete();
			tmpfile.createNewFile();
			FileOutputStream fos = FileUtils.openOutputStream(tmpfile);
			wb.write(fos);
			fos.close();
			
			wb.close();
			
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 设置单元格样式
	 * @param wb
	 * @param cell
	 * @param td
	 */
	@SuppressWarnings("deprecation")
	private static void setType(HSSFWorkbook wb, HSSFCell cell, Element td) {
		// TODO Auto-generated method stub
		Attribute typeAttr = td.getAttribute("type");
		String type = typeAttr.getValue();
		HSSFDataFormat format = wb.createDataFormat();
		HSSFCellStyle cellStyle = wb.createCellStyle();
		if("numeric".equals(type)){
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			Attribute formatAttr = td.getAttribute("format");
			String formatValue = formatAttr.getValue();
			formatValue = StringUtils.isNotBlank(formatValue) ? formatValue : "#,##0.00";
			cellStyle.setDataFormat(format.getFormat(formatValue));
			
		}else if("string".equals(type)){
			cell.setCellValue("");
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cellStyle.setDataFormat(format.getFormat("@"));
		}else if("enum".equals(type)){
			CellRangeAddressList regions = 
					new CellRangeAddressList(cell.getRowIndex(), cell.getRowIndex(), 
							cell.getColumnIndex(), cell.getColumnIndex());
			Attribute enumAttr = td.getAttribute("format");
			String enumValue = enumAttr.getValue();
			
			//添加到下拉列表中
			DVConstraint constraint = DVConstraint.createExplicitListConstraint(enumValue.split(","));
			HSSFDataValidation dataValidation = new HSSFDataValidation(regions, constraint);
			wb.getSheetAt(0).addValidationData(dataValidation);
			
		}else if("date".equals(type)){
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cellStyle.setDataFormat(format.getFormat("yyyy-M-d"));
		}
		cell.setCellStyle(cellStyle);
	}

	/**
	 * 设置列宽
	 * @param sheet
	 * @param colgroup
	 */
	private static void setColumnWidth(HSSFSheet sheet, Element colgroup) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Element> cols = colgroup.getChildren("col");
		for (Element element : cols) {
			Attribute attr = element.getAttribute("width");
			String unit = attr.getValue().replaceAll("[0-9,\\.]","");
			String value = attr.getValue().replaceAll(unit, "");
			
			int v = 0;
			if(StringUtils.isBlank(unit) || "px".endsWith(unit)){
				v = Math.round(Float.parseFloat(value) * 37F);
			}else if("em".endsWith(unit)){
				v = Math.round(Float.parseFloat(value) * 267.5F);
			}
			sheet.setColumnWidth(cols.indexOf(element), v);
		}
	}

}