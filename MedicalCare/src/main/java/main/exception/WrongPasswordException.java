package main.exception;

/**
 * Exception thrown during a connection to the database if the password of the user is incorrect
 */
public class WrongPasswordException extends Exception {

	private static final long serialVersionUID = 1L;

	public WrongPasswordException() {
	}

	public WrongPasswordException(String message) {
		super(message);
	}

	public WrongPasswordException(Throwable cause) {
		super(cause);
	}

	public WrongPasswordException(String message, Throwable cause) {
		super(message, cause);
	}

	public WrongPasswordException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
