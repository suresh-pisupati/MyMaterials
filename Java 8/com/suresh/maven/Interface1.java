package com.suresh.maven;

public interface Interface1 {

	public void display();
	
	public void print();
	
	default void printName(String name) {
		System.out.println( "My Name is....... "  +name);
	}
	
	static void displayName(String name) {
		System.out.println( "My Name is....... "  +name);
	}
}
