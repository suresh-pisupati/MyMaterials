package com.suresh.maven;

public class DefaultAndStaticMethodsOfInheritence implements Interface1, Interface2{

	
	@Override
	public void display() {
		System.out.print( "In the display method....." );
	}

	@Override
	public void print() {
		System.out.print( "In the print method....." );
	}
	
	@Override
	public void printName(String name) {
		Interface1.super.printName(name);
		Interface2.super.printName(name);
	}

	public static void main(String[] args) {
		DefaultAndStaticMethodsOfInheritence obj = new DefaultAndStaticMethodsOfInheritence();
		obj.display();
		obj.print();
		obj.printName("suresh");
	}
}
