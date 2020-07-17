package com.suresh.paletteconfig.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.suresh.paletteconfig.models.BusinessRules;

@Component
public class BusinessRulesRepositoryImpl {

   @PersistenceContext
   private EntityManager entityManager;

   public List <BusinessRules> findAllByRuleName( String ruleName ) {

      String hql = "SELECT businessRules FROM BusinessRules businessRules WHERE businessRules.ruleName = :ruleName";
      TypedQuery <BusinessRules> query = entityManager.createQuery( hql, BusinessRules.class );
      query.setParameter( "ruleName", ruleName );
      return query.getResultList();
   }

}
