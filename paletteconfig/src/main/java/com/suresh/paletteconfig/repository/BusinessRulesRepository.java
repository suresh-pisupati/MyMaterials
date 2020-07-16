package com.suresh.paletteconfig.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.suresh.paletteconfig.models.BusinessRules;

@Repository
public interface BusinessRulesRepository extends CrudRepository <BusinessRules, String> {

}
