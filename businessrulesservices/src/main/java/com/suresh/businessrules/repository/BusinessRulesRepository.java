package com.suresh.businessrules.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.suresh.businessrules.entities.BusinessRulesEntity;

@Repository
public interface BusinessRulesRepository extends JpaRepository <BusinessRulesEntity, String> {

   static final String FIND_ALL_BY_RULENAME = "SELECT businessRules FROM BusinessRulesEntity businessRules WHERE businessRules.ruleName = :ruleName";

   @Query(FIND_ALL_BY_RULENAME)
   public List <BusinessRulesEntity> findAllByRuleName( String ruleName );
}
