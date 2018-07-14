/*
 * CommandException.java
 *
 * Created on 18 April 2006, 21:19
 *
 * To change this template, choose Tools | Template Manager
 * editor.
 */

package coaching.mvc.controller;

/**
 * ControllerException Class.
 */
public class ControllerException extends java.lang.Exception {

	/**
	 * Instantiates a new controller exception.
	 */
	public ControllerException() {
	}

	/**
	 * Instantiates a new controller exception.
	 * 
	 * msg
	 *
	 * @param msg the msg
	 */
	public ControllerException(final String msg) {
		super(msg);
	}
}