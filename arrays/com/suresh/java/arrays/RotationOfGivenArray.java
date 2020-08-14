package com.suresh.java.arrays;

public class RotationOfGivenArray {

	public static void main(String[] args) {

		int[] givenArray = { 1, 2, 3, 4, 5 };
		rotateArrayBy(givenArray, 3);
		for (int i : givenArray) {
			System.out.print(i + ", ");
		}
	}

	private static void rotateArrayBy(int[] givenArray, int nTimes) {

		for (int n = 0; n < nTimes; n++) {

			int j = 0, firstElement = givenArray[0];

			for (int i = 0; i < givenArray.length - 1; i++) {
				givenArray[j++] = givenArray[i + 1];
			}
			givenArray[j++] = firstElement;
		}
	}
}
