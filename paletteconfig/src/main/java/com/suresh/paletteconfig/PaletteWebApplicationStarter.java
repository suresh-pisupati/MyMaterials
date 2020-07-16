package com.suresh.paletteconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Suresh
 */
@SpringBootApplication
@EnableScheduling
public class PaletteWebApplicationStarter {

   public static void main( String[] args ) {

      SpringApplication.run( PaletteWebApplicationStarter.class, args );
   }
}