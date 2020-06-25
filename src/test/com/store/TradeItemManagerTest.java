package test.com.store;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import com.store.InvalidTradeException;
import com.store.TradeItem;
import com.store.TradeStoreManager;

class TradeItemManagerTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	void addTradeTest() throws InvalidTradeException, ParseException {
		LinkedList tradeStore = new LinkedList<TradeItem>();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
		Date today = Calendar.getInstance().getTime();
		TradeItem tradeItem = new TradeItem("T1", 1, "CP-1", "B1", dateFormat.parse("20/05/2021"), today, false);
		TradeStoreManager.addTrade(tradeItem, tradeStore);
		assertTrue(tradeStore.size() > 0);
	}

	@Test
	void addInvalidTradeTest() throws  ParseException {
		LinkedList tradeStore = new LinkedList<TradeItem>();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
		Date today = Calendar.getInstance().getTime();
		TradeItem tradeItem = new TradeItem("T1", 1, "CP-1", "B1", dateFormat.parse("20/05/2019"), today, false);
		try {
			TradeStoreManager.addTrade(tradeItem, tradeStore);
		} catch (InvalidTradeException e) {
			assertTrue(tradeStore.size() == 0);
		}
	}

}
