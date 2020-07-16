package com.suresh.paletteconfig.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suresh.paletteconfig.models.BusinessRules;
import com.suresh.paletteconfig.repository.BusinessRulesRepository;

@Service
public class BusinessRulesService {

   @Autowired
   private BusinessRulesRepository businessRulesRepository;

   public List <BusinessRules> fetchAllBusinessRulesList() {

      List <BusinessRules> businessRulesList = new ArrayList <BusinessRules>();
      businessRulesRepository.findAll().forEach( e -> businessRulesList.add( e ) );

      return businessRulesList;
   }
}
