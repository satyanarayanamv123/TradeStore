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
		
		try {
			tradeStore.add(new TradeItem("T1", 1, "CP-1", "B1", dateFormat.parse("20/05/2020"), today, false));
			tradeStore.add(new TradeItem("T2", 2, "CP-2", "B1", dateFormat.parse("20/05/2021"), today, false));
			tradeStore.add(new TradeItem("T2", 1, "CP-1", "B1", dateFormat.parse("20/05/2021"), today, false));
			tradeStore.add(new TradeItem("T3", 3, "CP-3", "B2", dateFormat.parse("20/05/2014"), today, true));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(TradeItem tradeItem: tradeStore) {
			System.out.println(tradeItem.getTradeId());
		}
		

	}

}
