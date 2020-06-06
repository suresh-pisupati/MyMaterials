package org.suresh.dp;

public class AllPartitions {

   public static void allPartitions1( String in ) {

      auxAllPartitions1( in, "" );
   }

   private static void auxAllPartitions1( String in, String res ) {

      if( 0 == in.length() ) {
         System.out.println( res );
         return;
      }
      for( int i = 0; i < in.length(); ++i )
         auxAllPartitions1( in.substring( i + 1 ), res + "+" + in.substring( 0, i + 1 ) );
   }

   public static void main( String[] args ) {

      allPartitions1( "abc" );
   }

}