package exception;

public class BadCharException extends Exception {

	private static final long serialVersionUID = 1L;

	public BadCharException() {
		super();
	}

	@Override
	public String getMessage() {
		return "Hibás adatbevitel!";
	}

}
