package com.org.suresh;

public class EggDropProblem {

   private static int findFloorsForEggDrop( int nEggs, int nFloors ) {

      // If there are no floors or only one Floor just return the number
      if( nFloors == 0 || nFloors == 1 ) {
         return nFloors;
      }

      // If we are left with only one egg, we need to try with all or remaining floors.
      if( nEggs == 1 ) {
         return nFloors;
      }

      int requiredFloors = Integer.MAX_VALUE;
      int res;
      /*
       * 1) If the egg breaks after dropping from nth floor, then we only need to check for floors
       * lower than x with remaining eggs; so the problem reduces to x-1 floors and n-1 eggs. 2) If
       * the egg doesn’t break after dropping from the nth floor, then we only need to check for
       * floors higher than x; so the problem reduces to nFloors-x floors and n eggs.
       */
      for( int i = 1; i <= nFloors; i++ ) {
         res = Math.max( findFloorsForEggDrop( nEggs - 1, i - 1 ), findFloorsForEggDrop( nEggs, nFloors - i ) );
         if( res < requiredFloors ) {
            requiredFloors = res;
         }
      }
      return requiredFloors + 1;
   }

   public static void main( String[] args ) {

      System.out.println( findFloorsForEggDrop( 2, 10 ) );
   }
}
