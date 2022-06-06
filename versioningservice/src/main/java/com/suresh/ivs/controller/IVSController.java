package com.suresh.ivs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suresh.ivs.service.IVSService;

@RestController
public class IVSController {

	/*
	 * Service call to fetch the version details
	 */
	@Autowired
	private IVSService ivsService;

	@RequestMapping("/version/{businessRuleGuid}")
	public Object fetchAllBusinessRulesAndVersionsByGuid(@PathVariable String businessRuleGuid) {

		return ivsService.findVersionByRuleGuid(businessRuleGuid);
	}

}
