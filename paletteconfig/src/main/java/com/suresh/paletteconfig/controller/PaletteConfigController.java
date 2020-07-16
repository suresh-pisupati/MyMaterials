package com.suresh.paletteconfig.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suresh.paletteconfig.exception.PropertyFileNotFoundException;
import com.suresh.paletteconfig.models.BusinessRules;
import com.suresh.paletteconfig.properties.PaletteConfigSystemProperties;
import com.suresh.paletteconfig.service.BusinessRulesService;

@RestController
@ControllerAdvice
public class PaletteConfigController {

   @Value("${spring.application.name}")
   private String               applicationName;

   @Autowired
   private BusinessRulesService businessRulesService;

   @RequestMapping("/PaletteConfig")
   public String isFirstRun() {

      Properties properties = loadPasswordProperties();

      return properties == null ? "No configuration available." : applicationName;
   }

   protected Properties loadPasswordProperties() {

      Properties properties = new Properties();
      String paletteDirectory = PaletteConfigSystemProperties.getStringValue( PaletteConfigSystemProperties.DOWNLOAD_DIR_KEY );
      File paletteDir = new File( paletteDirectory );
      if( !paletteDir.exists() ) {
         paletteDir.mkdir();
      }
      File passwordPropertiesFile = new File( paletteDirectory + "/passwd.properties" );
      if( !passwordPropertiesFile.exists() ) {
         try (OutputStream passwordFileOutStream = new FileOutputStream( passwordPropertiesFile )) {
            passwordPropertiesFile.createNewFile();
            properties = new Properties();
            properties.store( passwordFileOutStream, "comment" );
            passwordFileOutStream.flush();
            return properties;
         }
         catch( IOException ex ) {
            throw new PropertyFileNotFoundException( "IO Exception occurred." );
         }
      }

      try (InputStream stream = new FileInputStream( passwordPropertiesFile )) {
         properties.load( stream );
      }
      catch( IOException ex ) {
         throw new PropertyFileNotFoundException( "IO expcetion in input stream reader............." );
      }
      return properties;
   }

   @RequestMapping("/businessRules")
   public List <BusinessRules> fetchAllBusinessRules() {

      return businessRulesService.fetchAllBusinessRulesList();
   }
}
