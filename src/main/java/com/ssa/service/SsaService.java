package com.ssa.service;

import java.util.List;

import com.ssa.model.SsaModel;

public interface SsaService {

	public List<String> selectStateNameList();
	public SsaModel insertSsa(SsaModel model);
	public String generateSsn(int count);
	public String getStateCode(String stateName);
	public String fetchStateCodeBySsn(Long ssn);
	
}
