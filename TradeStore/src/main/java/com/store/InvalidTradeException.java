package com.store;

/**
 * This class represents invalid trade exception.
 * Trade version is less than the existing trade
 * @author Satya
 *
 */
public class InvalidTradeException extends Exception {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String errorCode;
	String errorMessage;
	
	public InvalidTradeException() {
	 super();
	}
	
	public InvalidTradeException(String pErrCode, String pErrMessage) {
		setErrorCode(pErrCode);
		setErrorMessage(pErrMessage);
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
 
}
