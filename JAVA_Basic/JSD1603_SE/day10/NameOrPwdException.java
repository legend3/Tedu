package day10;

public class NameOrPwdException extends Exception {

	public NameOrPwdException() {
	}

	public NameOrPwdException(String message) {
		super(message);
	}

	public NameOrPwdException(Throwable cause) {
		super(cause);
	}

	public NameOrPwdException(String message, Throwable cause) {
		super(message, cause);
	}

	public NameOrPwdException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
