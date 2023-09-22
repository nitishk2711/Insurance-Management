package com.IMT.insuranceManagementPlatform.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IMT.insuranceManagementPlatform.dto.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Long> {

}
