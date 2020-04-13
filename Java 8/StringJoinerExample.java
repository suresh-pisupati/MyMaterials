package org.suresh.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class StringJoinerExample {

   public static void main( String[] args ) {

      List <String> list = new ArrayList <>();

      list.add( "11" );

      list.add( "21" );

      list.add( "31" );

      list.add( "41" );

      list.add( "51" );

      StringJoiner joiner = new StringJoiner( ",", "(", ")" ); // Delimiter, Prefix, Suffix

      list.forEach( str -> joiner.add( "" + str + "" ) );

      System.out.println( joiner.toString() ); // Result: (11,21,31,41,51)

   }

}
