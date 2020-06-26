package com.store;

import java.util.Date;

/**
 * This class represents a trade item
 * @author Satya
 *
 */
public class TradeItem {
	
	/** Trade id **/
	private String tradeId;
	
	/** Trade version **/
	private int version;
	
	/** Trade counter party id **/
	private String counterPartyId;
	
	/** Trade book id **/
	private String bookId;
	
	/** Trade maturity date **/
	private Date maturityDate;
	
	/** Trade creation date**/
	private Date createdDate;
	
	/** is trade expired **/
	private boolean expired;
	
	/**
	 * Default constructor
	 */
	public TradeItem() {
		super();
	}
	/**
	 * public constructor
	 * @param pTradeId
	 * @param pVersion
	 * @param pCounterPartyId
	 * @param pBookId
	 * @param pMaturityDate
	 * @param pCreateDate
	 * @param pExpired
	 */
	public TradeItem(String pTradeId, int pVersion,
			String pCounterPartyId, String pBookId,
			Date pMaturityDate, Date pCreateDate,
			boolean pExpired) {
		setTradeId(pTradeId);
		setVersion(pVersion);
		setCounterPartyId(pCounterPartyId);
		setBookId(pBookId);
		setMaturityDate(pMaturityDate);
		setCreatedDate(pCreateDate);
		setExpired(pExpired);
	}
	/**
	 * @return the tradeId
	 */
	public String getTradeId() {
		return tradeId;
	}

	/**
	 * @param tradeId the tradeId to set
	 */
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * @return the counterPartyId
	 */
	public String getCounterPartyId() {
		return counterPartyId;
	}

	/**
	 * @param counterPartyId the counterPartyId to set
	 */
	public void setCounterPartyId(String counterPartyId) {
		this.counterPartyId = counterPartyId;
	}

	/**
	 * @return the bookId
	 */
	public String getBookId() {
		return bookId;
	}

	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return the maturityDate
	 */
	public Date getMaturityDate() {
		return maturityDate;
	}

	/**
	 * @param maturityDate the maturityDate to set
	 */
	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the expired
	 */
	public boolean isExpired() {
		return expired;
	}

	/**
	 * @param expired the expired to set
	 */
	public void setExpired(boolean expired) {
		this.expired = expired;
	}
	@Override
	public String toString() {
		return "TradeItem [tradeId=" + tradeId + ", version=" + version + ", counterPartyId=" + counterPartyId
				+ ", bookId=" + bookId + ", maturityDate=" + maturityDate + ", createdDate=" + createdDate
				+ ", expired=" + expired + "]";
	}
	

}
