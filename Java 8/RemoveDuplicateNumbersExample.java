package org.suresh.java8;

import java.util.Arrays;

public class RemoveDuplicateNumbersExample {

   public static void main( String[] args ) {

      int numbers[] = { 1, 1, 2, 2, 3, 4, 5, 6 };
      int[] requiredArray = removeDuplicates( numbers );
      for( int n : requiredArray ) {
         System.out.println( n );
      }
   }

   private static int[] removeDuplicates( int[] numbers ) {

      int count = numbers.length;
      for( int i = 0; i < count; i++ ) {
         for( int j = i + 1; j < count; j++ ) {
            if( numbers[i] == numbers[j] ) {
               numbers[j] = numbers[count - 1];
               count--;
               j--;
            }
         }
      }
      return Arrays.copyOf( numbers, count );
   }

}
