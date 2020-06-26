package com.store;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TradeStoreManagerTest {
	
	LinkedList tradeStore = null;
	DateFormat dateFormat = null;
	Date today = Calendar.getInstance().getTime();

	@BeforeEach
	void setUp() throws Exception {
		tradeStore = new LinkedList<TradeItem>();
		dateFormat = new SimpleDateFormat("dd/MM/yy");

	}

	
	@Test
	final void testAddTrade() throws ParseException {
		TradeItem tradeItem = new TradeItem("T1", 1, "CP-1", "B1", dateFormat.parse("20/05/2021"), today, false);
		TradeStoreManager.addTrade(tradeItem, tradeStore);
		assertTrue(tradeStore.size() > 0);
	}

	/**
	 * Test method for
	 * {@link com.store.TradeStoreManager#addTrade(com.store.TradeItem, java.util.LinkedList)}.
	 * 
	 * @throws ParseException
	 */
	@Test
	final void testAddInvalidTrade() throws ParseException {
		TradeItem tradeItem = new TradeItem("T1", 1, "CP-1", "B1", dateFormat.parse("20/05/2019"), today, false);
		TradeStoreManager.addTrade(tradeItem, tradeStore);
		assertTrue(tradeStore.size() == 0);

	}

	/**
	 * Test method for
	 * {@link com.store.TradeStoreManager#isTradeMaturityDateValid(com.store.TradeItem)}.
	 * @throws ParseException 
	 */
	@Test
	final void testIsTradeMaturityDateValid() throws ParseException {
		TradeItem tradeItem = new TradeItem("T1", 1, "CP-1", "B1", dateFormat.parse("20/05/2019"), today, false);
		
		 Assertions.assertThrows(InvalidTradeException.class, ()-> {
			 TradeStoreManager.isTradeMaturityDateValid(tradeItem);
		 });
		

	}

	/**
	 * Test method for
	 * {@link com.store.TradeStoreManager#findTradeLocation(com.store.TradeItem, java.util.LinkedList)}.
	 * @throws ParseException 
	 * @throws InvalidTradeException 
	 */
	@Test
	final void testFindTradeLocation() throws ParseException, InvalidTradeException {
		
		TradeItem tradeItem = null;
		tradeItem = new TradeItem("T1", 1, "CP-1", "B1", dateFormat.parse("20/05/2025"), today, false);
		TradeStoreManager.addTrade(tradeItem, tradeStore);
		
		tradeItem = new TradeItem("T2", 1, "CP-1", "B1", dateFormat.parse("20/05/2021"), today, false);
		TradeStoreManager.addTrade(tradeItem, tradeStore);
		
		tradeItem = new TradeItem("T2", 2, "CP-2", "B1", dateFormat.parse("20/05/2021"), today, false);
		int location = TradeStoreManager.findTradeLocation(tradeItem, tradeStore);
		
		assertTrue(location>0);
	}

	/**
	 * Test method for
	 * {@link com.store.TradeStoreManager#findTradeLocation(com.store.TradeItem, java.util.LinkedList)}.
	 * @throws ParseException 
	 * @throws InvalidTradeException 
	 */
	@Test
	final void testFindTradeLocationForInvaidRecord() throws ParseException, InvalidTradeException {
		
		TradeItem tradeItem = null;
		tradeItem = new TradeItem("T1", 1, "CP-1", "B1", dateFormat.parse("20/05/2025"), today, false);
		TradeStoreManager.addTrade(tradeItem, tradeStore);
		
		tradeItem = new TradeItem("T2", 2, "CP-2", "B1", dateFormat.parse("20/05/2021"), today, false);
		TradeStoreManager.addTrade(tradeItem, tradeStore);
		
		tradeItem = new TradeItem("T2", 1, "CP-1", "B1", dateFormat.parse("20/05/2021"), today, false);
		TradeStoreManager.addTrade(tradeItem, tradeStore);
		
		
		
		 Assertions.assertThrows(InvalidTradeException.class, ()-> {
			 TradeItem tradeItem1 = new TradeItem("T2", 2, "CP-2", "B1", dateFormat.parse("20/05/2021"), today, false);
			 TradeStoreManager.findTradeLocation(tradeItem1, tradeStore);
		 });
		
	}

}
