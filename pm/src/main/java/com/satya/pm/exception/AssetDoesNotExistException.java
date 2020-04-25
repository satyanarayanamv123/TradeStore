package com.satya.pm.exception;

public class AssetDoesNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AssetDoesNotExistException(String errorMessage) {
		super(errorMessage);
	}

}
