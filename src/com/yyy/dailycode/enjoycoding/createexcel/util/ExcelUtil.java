package com.yyy.dailycode.enjoycoding.createexcel.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 *   @类名： ExcelUtil
 *   @描述： excel工具类,依赖的jar：poi-ooxml-3.10-FINAL-20140208.jar，poi-3.10-FINAL-20140208.jar
 *   @作者： 杨文胜
 *   @生成时间： 2014-5-26 上午09:13:41
 *   @修改人：
 *   @修改时间：  
 **/
public class ExcelUtil {
	/**
	 *   @生成时间： 2014-5-26 上午09:14:10
	 *   @方法说明： 打印设置
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static void print(HSSFSheet sheet) {
		HSSFPrintSetup ps = sheet.getPrintSetup();
		ps.setLandscape(false); // 打印方向，true:横向，false:纵向
		ps.setPaperSize(HSSFPrintSetup.A4_PAPERSIZE); // 纸张
		sheet.setMargin(HSSFSheet.BottomMargin, (double) 0.5); // 页边距（下）
		sheet.setMargin(HSSFSheet.LeftMargin, (double) 0.4); // 页边距（左）
		sheet.setMargin(HSSFSheet.RightMargin, (double) 0.4); // 页边距（右）
		sheet.setMargin(HSSFSheet.TopMargin, (double) 0.8); // 页边距（上）
		sheet.setHorizontallyCenter(true); // 设置打印页面为水平居中
	}
	 /**
	 *   @生成时间： 2014-5-26 上午09:14:28
	 *   @方法说明： 生成默认sheet页
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static HSSFSheet creatSheet(HSSFWorkbook workbook, String sheetname) {
		HSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(0, sheetname);
		return sheet;
	}
	 /**
	 *   @生成时间： 2014-5-26 上午09:14:52
	 *   @方法说明： 根据索引生成sheet页，第一个sheet页为0
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static HSSFSheet creatSheet(HSSFWorkbook workbook, String sheetname,
			Integer index) {
		HSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(index, sheetname);
		return sheet;
	}
	/**
	 *   @生成时间： 2014-5-26 下午06:18:20
	 *   @方法说明： 设置单元格的值，值为字符串
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static HSSFCell setCellValueOfString(HSSFWorkbook workbook,HSSFRow row,HSSFCellStyle setBorder,String value,int index){
		HSSFCell cell=row.createCell(index,HSSFCell.CELL_TYPE_STRING);
    	if(setBorder!=null)
    		cell.setCellStyle(setBorder);
    	cell.setCellValue(value);
    	return cell;
	}
	/**
	 *   @生成时间： 2014-5-26 下午06:17:25
	 *   @方法说明： 合并单元格
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static void region(HSSFSheet sheet,int row,int cell,int end_row,int end_cell){
		CellRangeAddress region=new CellRangeAddress(row,cell,end_row,end_cell);
		sheet.addMergedRegion(region);
	}
}