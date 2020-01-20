package com.ssa.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class SsaModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long ssaNo;
	private String firstName;
	private String lastName;
	private Date dob;
	private String gender;
	private String state;
}
