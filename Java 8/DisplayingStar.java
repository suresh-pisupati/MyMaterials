package org.suresh.java8;

public class DisplayingStar {

   public static void main( String[] args ) {

      for( int i = 0; i < 5; i++ ) {
         for( int j = 1; j <= i + 1; j++ ) {
            System.out.print( "*" );
         }
         System.out.println( "" );
      }
      for( int i = 0; i < 5; i++ ) {
         for( int j = i + 1; j <= 5; j++ ) {
            System.out.print( "*" );
         }
         System.out.println( "" );
      }

   }

}
