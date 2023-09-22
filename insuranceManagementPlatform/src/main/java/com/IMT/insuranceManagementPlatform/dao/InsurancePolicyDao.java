package com.IMT.insuranceManagementPlatform.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.IMT.insuranceManagementPlatform.dto.InsurancePolicy;
import com.IMT.insuranceManagementPlatform.repostiory.InsurancePolicyRepository;

@Repository
public class InsurancePolicyDao {
	@Autowired
	private InsurancePolicyRepository repository;

	public InsurancePolicy saveInsurancePolicy(InsurancePolicy insurancePolicy) {
		return repository.save(insurancePolicy);
	}

	public InsurancePolicy updateInsurancePolicy(InsurancePolicy insurancePolicy) {
		return repository.save(insurancePolicy);
	}

	public Optional<InsurancePolicy> findInsurancePolicy(long id) {
		return repository.findById(id);
	}

	public List<InsurancePolicy> findAll() {
		return repository.findAll();
	}

	public void deleteInsurancePolicy(long id) {
		repository.deleteById(id);
	}

}
