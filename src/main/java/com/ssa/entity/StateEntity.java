package com.ssa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "USA_STATE_MASTER")
public class StateEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STATE_ID")
	private Integer stateId;
	
	@Column(name = "STATE_CODE")
	private String stateCode;
	
	@Column(name = "STATE_NAME")
	private String stateName;
}
