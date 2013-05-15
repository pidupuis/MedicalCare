package main.exception;

/**
 * Exception thrown during a connection to the database if the user name is unknown
 */
public class UnknownUsernameException extends Exception {

	private static final long serialVersionUID = 1L;

	public UnknownUsernameException() {
	}

	public UnknownUsernameException(String message) {
		super(message);
	}

	public UnknownUsernameException(Throwable cause) {
		super(cause);
	}

	public UnknownUsernameException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnknownUsernameException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
