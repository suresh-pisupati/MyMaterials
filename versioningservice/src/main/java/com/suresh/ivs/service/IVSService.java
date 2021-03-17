package com.suresh.ivs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suresh.ivs.repository.IVSRepository;

@Service
public class IVSService {

   @Autowired
   private IVSRepository ivsRepository;

   public List findVersionByRuleGuid( String businessRuleGuid ) {

      return ivsRepository.findVerionDetailsByRuleGuid( businessRuleGuid );
   }
}
