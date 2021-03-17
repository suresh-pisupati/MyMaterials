package com.suresh.businessrules.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suresh.businessrules.entities.BusinessRulesEntity;
import com.suresh.businessrules.repository.BusinessRulesRepository;

/**
 * Service class is reponsible for making a call to the repository class. The request received from
 * controller will be delegated to this class to perform necessary actions. Service classes will
 * communicate to Repository classes to fetch the data required from database.
 * 
 * @author pksuresh
 */
@Service
public class BusinessRulesService {

   @Autowired
   private BusinessRulesRepository businessRulesRepository;

   /**
    * This method will delegates the request to Repository class to fetch all business rules
    * information of given business rule name.
    * 
    * @param ruleName
    *           a String variable
    * @return List of all business rules matching the given rule name
    */
   public List <BusinessRulesEntity> fetchBusinessRulesByName( String ruleName ) {

      List <BusinessRulesEntity> businessRulesList = new ArrayList <BusinessRulesEntity>();
      businessRulesRepository.findAllByRuleName( ruleName ).forEach( e -> businessRulesList.add( e ) );

      return businessRulesList;

   }

}
