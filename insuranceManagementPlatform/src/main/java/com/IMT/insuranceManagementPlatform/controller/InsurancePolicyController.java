package com.IMT.insuranceManagementPlatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.IMT.insuranceManagementPlatform.dao.ResponseStructure;
import com.IMT.insuranceManagementPlatform.dto.InsurancePolicy;
import com.IMT.insuranceManagementPlatform.service.InsurancePolicyServices;

@RestController
public class InsurancePolicyController {
	@Autowired
	private InsurancePolicyServices services;

	@PostMapping("/api/policies")
	public ResponseEntity<ResponseStructure<InsurancePolicy>> saveInsurancePolicy(
			@RequestBody InsurancePolicy insurancePolicy) {
		return services.saveInsurancePolicy(insurancePolicy);
	}

	@PutMapping("/api/policies/{id}")
	public ResponseEntity<ResponseStructure<InsurancePolicy>> updateInsurancePolicy(@PathVariable long id,
			@RequestBody InsurancePolicy insurancePolicy) {
		return services.updateInsurancePolicy(insurancePolicy);
	}

	@GetMapping("/api/policies")
	public ResponseEntity<ResponseStructure<List<InsurancePolicy>>> getAllInsurabncePolicies() {
		return services.getAllInsurancePolicy();
	}

	@GetMapping("/api/policies/{id}")
	public ResponseEntity<ResponseStructure<InsurancePolicy>> getInsurance(@PathVariable long id) {
		return services.getInsurancePolicyy(id);
	}

	@DeleteMapping("/api/policies/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteInsurancePolicy(@PathVariable long id) {
		return services.deleteInsurancePolicy(id);
	}

}
