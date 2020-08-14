package threadproblems;

public class CustomException extends Exception {

	private static final long serialVersionUID = 1L;

	private String message;

	public CustomException() {

	}

	public CustomException(String message) {

		this.message = message;
	}

	@Override
	public String toString() {

		return message;
	}
}
