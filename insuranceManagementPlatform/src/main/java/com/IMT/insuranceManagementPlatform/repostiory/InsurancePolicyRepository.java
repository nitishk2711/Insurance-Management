package com.IMT.insuranceManagementPlatform.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IMT.insuranceManagementPlatform.dto.InsurancePolicy;

public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Long>{

}
