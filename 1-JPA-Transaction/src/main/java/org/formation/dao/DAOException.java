package org.formation.dao;

public class DAOException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2866747239044068286L;

	private Exception nestedException;

	private String code;

	public DAOException(Exception nested, String c) {
		code = c;
		nestedException = nested;
	}

	public String toString() {
		return code + " : " + nestedException;
	}
}
