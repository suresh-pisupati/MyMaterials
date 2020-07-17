package com.suresh.paletteconfig.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.suresh.paletteconfig.models.BusinessRules;

@Repository
public interface IBusinessRulesRepository extends CrudRepository <BusinessRules, String> {

   public List <BusinessRules> findAllByRuleName( String ruleName );
}
