package org.suresh.java8;

import java.util.Arrays;

public class RemoveDuplicateNumbersExample {

   public static void main( String[] args ) {

      int numbers[] = { 1, 1, 2, 2, 3, 4, 5, 6 };
      int[] requiredArray = removeDuplicates1( numbers );
      for( int n : requiredArray ) {
         System.out.println( n );
      }
   }

   private static int[] removeDuplicates1( int[] numbers ) {

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
   
   //Time Complexity:   O(n)
   //Space Complexity:  O(1)
   private static int removeDuplicates2(int[] numbers) {
    
      int length = numbers.length();
      if(length == 0 || length == 1) {
         return length;
      }
      int j = 0;
      for(int i = 0; i < length - 1; i++) {
         if(numbers[i] != numbers[i+1]) {
            numbers[j++] = numbers[i];
         }
      }
      numbers[j++] = numbers[length - 1];
      return j;
   }

}
