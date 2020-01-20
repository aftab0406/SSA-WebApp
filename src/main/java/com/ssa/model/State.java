package com.ssa.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class State implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer stateId;
	private String stateCode;
	private String stateName;
}
