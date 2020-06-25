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
	public static void addTrade(TradeItem pTradeItem, LinkedList<TradeItem> pTradeStore) throws InvalidTradeException {

		isTradeMaturityDateValid(pTradeItem);

		int locationToInsert = findTradeLocation(pTradeItem, pTradeStore);

		pTradeStore.add(locationToInsert, pTradeItem);
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
			throw new InvalidTradeException(TRADE_MATURED, "Trade item already matured");
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
			if (currTradeItem.getTradeId().compareTo(pTradeItemToInsert.getTradeId()) > 1) {
				location = index;
			} else if (currTradeItem.getTradeId().compareTo(pTradeItemToInsert.getTradeId()) < 1) {

			} else {
				// trade ids are equal
				if (currTradeItem.getVersion() > pTradeItemToInsert.getVersion()) {
					location = index;
				} else if (currTradeItem.getVersion() < pTradeItemToInsert.getVersion()) {

				} else {
					// equals
					throw new InvalidTradeException(INVALID_TRADE, "Trade item is invalid");
				}
			}
			index++;
		}

		return location;
	}

}
