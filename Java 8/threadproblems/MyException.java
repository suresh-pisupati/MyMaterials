package threadproblems;

import java.lang.Thread.UncaughtExceptionHandler;

public class MyException implements UncaughtExceptionHandler {

	private String message;

	public MyException() {

	}

	public MyException(String message) {

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
