package threadproblems;

import java.lang.Thread.UncaughtExceptionHandler;

public class UnCaughtCustomException implements UncaughtExceptionHandler {

	private String message;

	public UnCaughtCustomException() {

	}

	public UnCaughtCustomException(String message) {

		this.message = message;
	}

	@Override
	public void uncaughtException(Thread t, Throwable e) {

		System.out.println("Uncaught Exception occurred and catching here... " + e.getLocalizedMessage());
	}

	@Override
	public String toString() {

		return message;
	}

}
