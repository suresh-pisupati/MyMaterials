package com.suresh.paletteconfig.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suresh.paletteconfig.entities.BusinessRulesEntity;
import com.suresh.paletteconfig.exception.PropertyFileNotFoundException;
import com.suresh.paletteconfig.properties.PaletteConfigSystemProperties;
import com.suresh.paletteconfig.service.BusinessRulesService;
import com.suresh.paletteconfig.service.IVSService;

/**
 * This is the main controller class which handles the REST api calls. The request from these
 * controller class will be delegated to respective 'Service' classes to solve the purpose.<br>
 * Each Service class will connect to its own database class for meeting the requirement.
 *
 * @author pksuresh
 */
@RestController
public class PaletteConfigController {

   /*
    * The application name will be fetched from 'application.properties' file and from the
    * corresponding parameter defined in it.
    */
   @Value("${spring.application.name}")
   private String               applicationName;

   /*
    * Service call to fetch from Business rules table
    */
   @Autowired
   private BusinessRulesService businessRulesService;

   /*
    * Service call to fetch the version details
    */
   @Autowired
   private IVSService           ivsService;

   /**
    * This method will determine whether the configuration is available or not. If the configuration
    * is available, the application name which is defined the application.properties file will be
    * returned else 'No configuration available' message will be returned.
    * 
    * @return name of the application or constant "No configuration available"
    */
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
   public List <BusinessRulesEntity> fetchAllBusinessRules() {

      return businessRulesService.fetchAllBusinessRulesList();
   }

   @RequestMapping("/businessRules/{name}")
   public Object fetchAllBusinessRulesAndVersionsByName( @PathVariable("name") String name ) {

      List requiredList = new ArrayList();
      List <BusinessRulesEntity> businessRulesList = businessRulesService.fetchBusinessRulesByName( name );
      requiredList.addAll( businessRulesList );
      for( BusinessRulesEntity entity : businessRulesList ) {
         requiredList.addAll( ( ivsService.findVersionByRuleGuid( entity.getBusinessRuleGuid() ) ) );
      }
      return requiredList;
   }
}
