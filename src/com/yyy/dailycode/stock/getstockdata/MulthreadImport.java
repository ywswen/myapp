package com.yyy.dailycode.stock.getstockdata;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.yyy.dailycode.stock.getstockdata.diffchannel.GetStockDataFromDB;
import com.yyy.dailycode.stock.getstockdata.diffchannel.GetStockHisDataFromSohu;
import com.yyy.dailycode.stock.vo.StockItems;

/**
 *   @类名： MulthreadImport
 *   @描述： 多线程导入数据
 *   @作者： 杨文胜
 *   @生成时间： 2017-4-25 下午02:15:00
 *   @修改人：
 *   @修改时间：  
 **/
public class MulthreadImport{
	
	LinkedList<StockItems> listStockItems = new GetStockDataFromDB().getStockItems();

	public void dealListWithMutiThread() {
		List<StockItems> list = listStockItems;
		int index = 0;
		ExecutorService ex = Executors.newFixedThreadPool(500);
		int dealSize = 100;
		List<Future<List<StockItems>>> futures = new ArrayList<Future<List<StockItems>>>(500);
		// 分配
		for (int i = 0; i < 500; i++, index += dealSize) {
			int start = index;
			if (start >= list.size())
				break;
			int end = start + dealSize;
			end = end > list.size() ? list.size() : end;
			futures.add(ex.submit(new Task(list, start, end)));
		}
		try {
			// 处理
			List<StockItems> result = new ArrayList<StockItems>();
			for (Future<List<StockItems>> future : futures) {
				// 合并操作
				result.addAll(future.get());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("123");
		ex.shutdown();
	}

	private class Task implements Callable<List<StockItems>> {

		private List<StockItems> list;
		private int start;
		private int end;

		public Task(List<StockItems> list, int start, int end) {
			this.list = list;
			this.start = start;
			this.end = end;
		}
		public List<StockItems> call() throws Exception {
			StockItems si = null;
            List<StockItems> retList = new ArrayList<StockItems>();
            @SuppressWarnings("unused")
			String stockId, stockCode, initURLStr;
            for(int i=start;i<end;i++){
                si = list.get(i);
//              多线程处理你的处理逻辑，通过百度获取历史数据，不成熟
//              stockId = si.getStock_id();
//    			stockCode = si.getStock_code();
//    			initURLStr = GetStockHisData.initURLStr(stockId, GetStockHisData.CYCLETYPE);
//    			GetStockHisData.loadDataToDb(initURLStr, stockCode);
                
                
//              通过雅虎获取数据，不稳定
//                stockCode = si.getStock_code_url();
//   				stockCode = "000003.sz";
//    			System.out.println(stockCode);
//    			initURLStr = GetStockHisDataYahoo.initURLStr(stockCode,GetStockHisDataYahoo.CYCLETYPE);
//    			GetStockHisDataYahoo.loadDataToDb(initURLStr, stockCode, 0);
                
//              通过搜狐获取数据
                stockCode = si.getStock_code();
                initURLStr = GetStockHisDataFromSohu.initURLStr(stockCode,GetStockHisDataFromSohu.CYCLETYPE);
    			GetStockHisDataFromSohu.loadDataToDb(initURLStr, stockCode, 0);
                System.out.println();
            }
            //返回处理结果
            return retList;
        }

	}


	public static void main(String[] args) {
		MulthreadImport m = new MulthreadImport();
		m.dealListWithMutiThread();
	}
}