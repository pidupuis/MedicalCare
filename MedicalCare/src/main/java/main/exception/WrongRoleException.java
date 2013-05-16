package main.exception;

/**
 * Exception thrown during a connection to the database if the role of the user is incorrect
 */
public class WrongRoleException extends Exception {

	private static final long serialVersionUID = 1L;

	public WrongRoleException() {
	}

	public WrongRoleException(String message) {
		super(message);
	}

	public WrongRoleException(Throwable cause) {
		super(cause);
	}

	public WrongRoleException(String message, Throwable cause) {
		super(message, cause);
	}

	public WrongRoleException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
