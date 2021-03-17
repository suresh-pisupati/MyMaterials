package com.suresh.ivs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.suresh.ivs.database.entities.VersionEntity;

@Repository
public interface IVSRepository extends JpaRepository <VersionEntity, String> {

   @Query("SELECT version FROM VersionEntity version WHERE version.ruleGuid = :ruleGuid")
   public List <VersionEntity> findVerionDetailsByRuleGuid( String ruleGuid );
}