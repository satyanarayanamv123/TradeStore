package com.store;

import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * This class maintains the trade items validation and sequence
 * 
 * @author Satya
 *
 */
public class TradeStoreManager {

	public static final String INVALID_TRADE = "INVALID_TRADE";

	public static final String TRADE_MATURED = "TRADE_MATURED";

	/**
	 * Insert trade item into the store
	 * 
	 * @param pTradeItem
	 * @param pTradeStore
	 */
	public static void addTrade(TradeItem pTradeItem, LinkedList<TradeItem> pTradeStore) {

		try {
			isTradeMaturityDateValid(pTradeItem);

			int locationToInsert = findTradeLocation(pTradeItem, pTradeStore);

			pTradeStore.add(locationToInsert, pTradeItem);

		} catch (InvalidTradeException e) {
			System.out.println(e.getErrorMessage());
			e.printStackTrace();
		}
	}

	/**
	 * This method verifies trade item maturity date
	 * 
	 * @param pTradeItem
	 * @return
	 */
	static void isTradeMaturityDateValid(TradeItem pTradeItem) throws InvalidTradeException {
		boolean matured = false;
		Calendar calendar = Calendar.getInstance();
		if (calendar.getTime().after(pTradeItem.getMaturityDate())) {
			throw new InvalidTradeException(TRADE_MATURED, "Trade item already matured " + pTradeItem.toString());
		}
	}

	/**
	 * Find out the location/index to insert
	 * 
	 * @param pTradeItemToInsert
	 * @param pTradeStore
	 * @return
	 */
	static int findTradeLocation(TradeItem pTradeItemToInsert, LinkedList<TradeItem> pTradeStore)
			throws InvalidTradeException {
		TradeItem currTradeItem = null;
		Iterator<TradeItem> tradeItemItr = pTradeStore.iterator();
		int location = 0;
		int index = 0;
		boolean locationFound = false;

		while (tradeItemItr.hasNext() && !locationFound) {
			currTradeItem = tradeItemItr.next();
			if (currTradeItem.getTradeId().compareTo(pTradeItemToInsert.getTradeId()) > 0) {
				locationFound = true;
				location = index;
			} else if (currTradeItem.getTradeId().compareTo(pTradeItemToInsert.getTradeId()) < 0) {
				
			} else {
				// trade ids are equal
				if (currTradeItem.getVersion() > pTradeItemToInsert.getVersion()) {
					locationFound = true;
					location = index;
				} else if (currTradeItem.getVersion() < pTradeItemToInsert.getVersion()) {

				} else {
					// equals
					throw new InvalidTradeException(INVALID_TRADE,
							"Trade item is invalid " + pTradeItemToInsert.toString());
				}
			}
			index++;
		}
		
		if(!locationFound) {
			location = pTradeStore.size();
		}

		return location;
	}

}
