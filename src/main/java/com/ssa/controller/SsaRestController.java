package com.ssa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssa.service.SsaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api("This rest controller will take ss number and return state code")
public class SsaRestController {

	@Autowired
	private SsaService service;
	
	@GetMapping(
			value = "/FindWithSsn",
			produces = { 
					"application/json", 
					"application/xml" 
			}
	)
	@ApiOperation(value = "This method will return state code")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Success"),
		@ApiResponse(code = 400, message = "Bad Request"),
		@ApiResponse(code = 500, message = "Server Problem")
	})
	public String getStateCodeBySsn(@ApiParam("SSN Number") @RequestParam("ssn")Long ssn)throws IllegalArgumentException {
		return service.fetchStateCodeBySsn(ssn);
	}
}
