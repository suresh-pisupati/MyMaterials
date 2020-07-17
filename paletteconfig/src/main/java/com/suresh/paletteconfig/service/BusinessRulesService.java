package com.suresh.paletteconfig.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suresh.paletteconfig.models.BusinessRules;
import com.suresh.paletteconfig.repository.BusinessRulesRepositoryImpl;
import com.suresh.paletteconfig.repository.IBusinessRulesRepository;

@Service
public class BusinessRulesService {

   @Autowired
   private IBusinessRulesRepository    businessRulesRepository;

   @Autowired
   private BusinessRulesRepositoryImpl businessRulesRepositoryImpl;

   public List <BusinessRules> fetchAllBusinessRulesList() {

      List <BusinessRules> businessRulesList = new ArrayList <BusinessRules>();
      businessRulesRepository.findAll().forEach( e -> businessRulesList.add( e ) );

      return businessRulesList;
   }

   public List <BusinessRules> fetchBusinessRulesByName( String ruleName ) {

      List <BusinessRules> businessRulesList = new ArrayList <BusinessRules>();
      businessRulesRepositoryImpl.findAllByRuleName( ruleName ).forEach( e -> businessRulesList.add( e ) );

      return businessRulesList;

   }
}
