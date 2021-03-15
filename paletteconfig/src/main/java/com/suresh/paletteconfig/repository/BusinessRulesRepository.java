package com.suresh.paletteconfig.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.suresh.paletteconfig.entities.BusinessRulesEntity;

/**
 * The Repository classes are responsible for fetching the results from the database. The Queries
 * can be written inside the <b>@Query</b> tag. <br>
 * For writting the native queries, a new attribute called <b>'nativeQuery=true'</b> must be added.
 * <br>
 * For DML scripts another annotation called <b>@Modifying</b> needs to be added.<br>
 * <br>
 * While writing the HQL queries, we should not be using the table names instead should be using the
 * entity class name like <blockquote>
 * 
 * <pre>
 * 
 * String s = "from Entity_class name";
 * query qry = session.createUqery( s );
 * </pre>
 * 
 * </blockquote> <br>
 * <b> QuerySyntaxException</b>: Failing to follow the above syntax will results in
 * QuerySyntaxException
 * 
 * @author pksuresh
 */
@Repository
public interface BusinessRulesRepository extends JpaRepository <BusinessRulesEntity, String> {

   static final String FIND_ALL_BY_RULENAME = "SELECT businessRules FROM BusinessRulesEntity businessRules WHERE businessRules.ruleName = :ruleName";

   @Query(FIND_ALL_BY_RULENAME)
   public List <BusinessRulesEntity> findAllByRuleName( String ruleName );
}
