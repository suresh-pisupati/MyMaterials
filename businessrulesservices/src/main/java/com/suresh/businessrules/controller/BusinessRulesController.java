package com.suresh.businessrules.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.suresh.businessrules.entities.BusinessRulesEntity;
import com.suresh.businessrules.service.BusinessRulesService;

@RestController
public class BusinessRulesController {

   /*
    * The application name will be fetched from 'application.properties' file and from the
    * corresponding parameter defined in it.
    */
   @Value("${spring.application.name}")
   private String               applicationName;

   @Value("${versioning.service.url}")
   private String               versioningServiceUrl;

   @Autowired
   private RestTemplate         restTemplate;

   @Autowired
   private ObjectMapper         objectMapper;

   /*
    * Service call to fetch from Business rules table
    */
   @Autowired
   private BusinessRulesService businessRulesService;

   @RequestMapping("/businessRules/{name}")
   public Object fetchAllBusinessRulesAndVersionsByName( @PathVariable("name") String name ) {

      List requiredList = new ArrayList();
      List <BusinessRulesEntity> businessRulesList = businessRulesService.fetchBusinessRulesByName( name );
      String requiredVersioningUrl = getVersioningUrl( businessRulesList.get( 0 ).getBusinessRuleGuid() );

      ResponseEntity <Object> responseEntity = restTemplate.getForEntity( requiredVersioningUrl, Object.class );

      requiredList.addAll( businessRulesList );
      requiredList.addAll( objectMapper.convertValue( responseEntity.getBody(), ArrayList.class ) );

      return requiredList;
   }

   private String getVersioningUrl( String businessRuleGuid ) {

      return UriComponentsBuilder.fromUriString( versioningServiceUrl ).path( businessRuleGuid ).build().encode().toUriString();
   }
}
