package com.suresh.java891011features;

public interface GreetingsInterface {

	/*
	 * default and static methods are introduced as part of Java 8
	 */
	default void friendSMS() {

		String str = "Hi Friend";
		display(str);
	}

	default void familySMS() {

		String str = "Hi Family";
		display(str);
	}

	/*
	 * private methods inside interfaces are introduced as part of java 9. Same
	 * advantage we will be getting as that of a class where we can have common
	 * implementation at single place.
	 */
	private void display(String msg) {

		System.out.println(msg + " good morning.");
	}
}
