package com.suresh.maven;

public interface Interface2 {

	default void printName(String name) {
		System.out.println( "My Name is....... "  +name + "    in interface2");
	}
}
