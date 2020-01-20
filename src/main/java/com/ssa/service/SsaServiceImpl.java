package com.ssa.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssa.entity.SsaEntity;
import com.ssa.model.SsaModel;
import com.ssa.repository.SsaRepository;
import com.ssa.repository.StateListRepository;

@Service
public class SsaServiceImpl implements SsaService {

	private static final String ALPHA_NUMERIC_STRING = "0123456789";
	private static final Integer SSN_LENGTH = 9;
	
	@Autowired
	private SsaRepository ssaRepo;
	
	@Autowired
	private StateListRepository stateRepo;
	
	@Override
	public List<String> selectStateNameList(){
		return stateRepo.findAllStateName();
	}
	
	@Override
	public SsaModel insertSsa(SsaModel model) {
		SsaEntity entity = new SsaEntity();
		BeanUtils.copyProperties(model, entity);
		entity.setSsaNo(Long.parseLong(generateSsn(SSN_LENGTH)));
		entity = ssaRepo.save(entity);
		BeanUtils.copyProperties(entity, model);
		return model;
	}
	
	@Override
	public String generateSsn(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
	
	@Override
	public String getStateCode(String stateName) {
		return stateRepo.findByStateName(stateName);
	}

	@Override
	public String fetchStateCodeBySsn(Long ssn) {
		return ssaRepo.findStateCodeBySsn(ssn);
	}
}
