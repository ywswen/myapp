package com.yyy.dailycode.enjoycoding.createexcel.cellstyle;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;

public class ExcelCellStyle {
	/**
	 *单元格文字加粗样式，格式为水平居中，垂直居中，字体加粗，无背景色
	 * @param workbook
	 * @param temp 1 为粗体
	 * @return
	 */
	public static HSSFCellStyle titleStyle(HSSFWorkbook workbook){
		HSSFCellStyle setBorder = workbook.createCellStyle();
		setBorder.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
		setBorder.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
		setBorder.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
		setBorder.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
		setBorder.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		setBorder.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直方向的对齐方式
		setBorder.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平居
		HSSFFont font=ExcelFont.font_style(workbook,true);
    	font.setFontHeightInPoints((short) 16);//设置字体大小
    	setBorder.setFont(font);
		return setBorder;
	}
	/**
	 *单元格文字加粗样式，格式为水平居中，垂直居中，字体加粗，无背景色
	 * @param workbook
	 * @param temp 1 为粗体
	 * @return
	 */
	public static Map<String, HSSFCellStyle> getCellStyles(HSSFWorkbook workbook){
		//单元格文字加粗样式，格式为水平居中，垂直居中，字体加粗，无背景色
		Map<String, HSSFCellStyle> mapStyle = new HashMap<String, HSSFCellStyle>();
		HSSFCellStyle setBorder = workbook.createCellStyle();
		setBorder.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
		setBorder.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
		setBorder.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
		setBorder.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
		setBorder.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		setBorder.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直方向的对齐方式
		setBorder.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平居
		HSSFFont font=ExcelFont.font_style(workbook,true);
		font.setFontHeightInPoints((short) 16);//设置字体大小
		setBorder.setFont(font);
		mapStyle.put("border", setBorder);
		
		//单元格文字加粗样式，格式为水平居中，垂直居中，字体加粗，华文琥珀字体
		HSSFCellStyle cell1 = workbook.createCellStyle();
		cell1.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
		cell1.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
		cell1.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
		cell1.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
		cell1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cell1.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直方向的对齐方式
		cell1.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平居
		HSSFFont font1 = workbook.createFont();
		font1.setFontName("华文琥珀");//设置字体格式，例如宋体
		font1.setFontHeightInPoints((short) 16);//设置字体大小
		font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
		cell1.setFont(font1);
		mapStyle.put("cell1", cell1);
		
		//单元格文字加粗样式，格式为水平居中，垂直居中，黑体，10号，背景色为灰色
		HSSFCellStyle cell2 = workbook.createCellStyle();
		cell2.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
		cell2.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
		cell2.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
		cell2.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
		cell2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cell2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直方向的对齐方式
		cell2.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平居
		cell2.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		cell2.setFillPattern(CellStyle.SOLID_FOREGROUND);
		HSSFFont font2 = workbook.createFont();
		font2.setFontName("黑体");//设置字体格式，例如宋体
		font2.setFontHeightInPoints((short) 10);//设置字体大小
		cell2.setFont(font2);
		mapStyle.put("cell2", cell2);
		
		return mapStyle;
	}
}
