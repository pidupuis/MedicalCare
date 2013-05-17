/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.exception;

/**
 *
 * @author Katia
 */
public class EmptySQLResultException extends Exception {

	private static final long serialVersionUID = 1L;

	public EmptySQLResultException() {
	}

	public EmptySQLResultException(String message) {
		super(message);
	}

	public EmptySQLResultException(Throwable cause) {
		super(cause);
	}

	public EmptySQLResultException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmptySQLResultException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
    
}
