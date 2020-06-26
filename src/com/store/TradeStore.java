/**
 * 
 */
package com.store;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

/**
 * @author Satya
 *
 */
public class TradeStore {
	
	static LinkedList<TradeItem>  tradeStore =  null;
	static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		tradeStore =  new LinkedList<TradeItem>();
		Date today  = Calendar.getInstance().getTime();
		TradeItem tradeItem = null;
		
		try {

			tradeItem = new TradeItem("T1", 1, "CP-1", "B1", dateFormat.parse("20/05/2025"), today, false);
			TradeStoreManager.addTrade(tradeItem, tradeStore);
			
			tradeItem = new TradeItem("T2", 2, "CP-2", "B1", dateFormat.parse("20/05/2021"), today, false);
			TradeStoreManager.addTrade(tradeItem, tradeStore);
			
			tradeItem = new TradeItem("T2", 1, "CP-1", "B1", dateFormat.parse("20/05/2021"), today, false);
			TradeStoreManager.addTrade(tradeItem, tradeStore);
			
			tradeItem = new TradeItem("T3", 3, "CP-3", "B2", dateFormat.parse("20/05/2024"), today, false);
			TradeStoreManager.addTrade(tradeItem, tradeStore);
			
			
			tradeItem = new TradeItem("T2", 2, "CP-2", "B1", dateFormat.parse("20/05/2021"), today, false);
			TradeStoreManager.addTrade(tradeItem, tradeStore);
			
			
			
		} catch (ParseException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 
		
		for(TradeItem tradeItm: tradeStore) {
			System.out.println(tradeItm);
		}
		

	}

}
