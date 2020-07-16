package com.suresh.paletteconfig.properties;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class PaletteConfigSystemProperties {

   private static Properties  systemProperties       = new Properties();
   public static final String DOWNLOAD_DIR_KEY       = "download.dir";
   public static final String PROPERTY_XFrameOptions = "application.X-Frame-Options";

   static {
      ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
      URL url = classLoader.getResource( "PaletteWebApplication.properties" );
      try (InputStream stream = url.openStream();) {
         systemProperties.load( stream );
      }
      catch( IOException ex ) {
         throw new RuntimeException( "SystemProperties::::Authentication system failed." );
      }
   }

   public static String getStringValue( String key ) {

      return systemProperties.getProperty( key );
   }
}
