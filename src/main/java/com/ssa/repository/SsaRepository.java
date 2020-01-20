package com.ssa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ssa.entity.SsaEntity;

@Repository
public interface SsaRepository extends JpaRepository<SsaEntity, Integer> {

	@Query(value = "SELECT state FROM SsaEntity WHERE ssaNo=:ssn")
	public String findStateCodeBySsn(Long ssn);
}
