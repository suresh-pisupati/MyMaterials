package org.suresh.java8;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateNumber {

   private static int findDuplicate( int[] nums ) {

      int requ = Integer.MIN_VALUE;
      Set <Integer> set = new HashSet <>();
      for( int i = 0; i < nums.length; i++ ) {
         if( set.add( nums[i] ) == false ) {
            requ = nums[i];
         }
      }
      return requ;
   }

   public static void main( String[] args ) {

      int[] input = { 1, 3, 4, 2, 2 };
      System.out.println( findDuplicate( input ) );
   }
}
