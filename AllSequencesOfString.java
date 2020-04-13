package org.suresh.dp;

public class AllSequencesOfString {

   public static void allSequences( String str ) {

      auxillary( str, 0, "" );
   }

   private static void auxillary( String str, int index, String res ) {

      if( index == str.length() ) {
         System.out.println( res );
         return;
      }
      for( int i = 0; i < str.length(); ++i ) {
         auxillary( str, index + 1, res + str.charAt( i ) );
      }

   }

   public static void main( String[] args ) {

      allSequences( "abc" );
   }

}
