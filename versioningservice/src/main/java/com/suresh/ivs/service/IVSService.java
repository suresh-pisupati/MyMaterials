package com.suresh.ivs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.suresh.ivs.repository.IVSRepository;

@Service
public class IVSService {

	@Autowired
	private IVSRepository ivsRepository;

	@Value("${spring.application.name}")
	private String name;

	public List findVersionByRuleGuid(String businessRuleGuid) {

		System.out.println("name is .............   " + name);
		return ivsRepository.findVerionDetailsByRuleGuid(businessRuleGuid);
	}
}
