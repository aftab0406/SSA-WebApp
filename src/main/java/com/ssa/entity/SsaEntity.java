package com.ssa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "SSA_TBL")
public class SsaEntity  {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SSA_NO", length = 9)
	private Long ssaNo;
	
	@Column(name = "FIRST_NAME", length = 30)
	private String firstName;
	
	@Column(name = "LAST_NAME", length = 30)
	private String lastName;
	
	@Column(name = "DOB")
	private Date dob;
	
	@Column(name = "GENDER", length = 7)
	private String gender;
	
	@Column(name = "STATE", length = 3)
	private String state;
	
}
