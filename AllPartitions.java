package org.suresh.dp;

public class AllPartitions {

   public static void allPartitions( String in ) {

      auxAllPartitions1( in, "" );
   }

   private static void auxAllPartitions( String in, String res ) {

      if( 0 == in.length() ) {
         System.out.println( res );
         return;
      }
      for( int i = 0; i < in.length(); ++i )
         auxAllPartitions( in.substring( i + 1 ), res + "+" + in.substring( 0, i + 1 ) );
   }

   public static void main( String[] args ) {

      allPartitions( "abc" );
   }

}

//Output is:
+a+b+c
+a+bc
+ab+c
+abc
