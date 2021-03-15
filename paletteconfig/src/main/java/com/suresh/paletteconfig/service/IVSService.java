package com.suresh.paletteconfig.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suresh.paletteconfig.ivs.repository.IVSRepository;

@Service
public class IVSService {

   @Autowired
   private IVSRepository ivsRepository;

   public List findVersionByRuleGuid( String businessRuleGuid ) {

      return ivsRepository.findVerionDetailsByRuleGuid( businessRuleGuid );
   }
}
