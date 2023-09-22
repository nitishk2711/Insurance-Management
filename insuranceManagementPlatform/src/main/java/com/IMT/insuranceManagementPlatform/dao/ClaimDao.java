package com.IMT.insuranceManagementPlatform.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.IMT.insuranceManagementPlatform.dto.Claim;
import com.IMT.insuranceManagementPlatform.repostiory.ClaimRepository;

@Repository
public class ClaimDao {
	@Autowired
	private ClaimRepository repository;

	public Claim saveClaim(Claim claim) {
		return repository.save(claim);
	}

	public Claim updateClaim(Claim claim) {
		return repository.save(claim);
	}

	public Optional<Claim> findClaim(long id) {
		return repository.findById(id);
	}

	public List<Claim> findAll() {
		return repository.findAll();
	}

	public void deleteClaim(long id) {
		repository.deleteById(id);
	}

}
