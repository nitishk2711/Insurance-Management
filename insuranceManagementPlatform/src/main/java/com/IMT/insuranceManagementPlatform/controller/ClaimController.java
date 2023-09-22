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
import com.IMT.insuranceManagementPlatform.dto.Claim;
import com.IMT.insuranceManagementPlatform.service.ClaimServices;

@RestController
public class ClaimController {
	@Autowired
	private ClaimServices services;

	@PostMapping("/api/claims")
	public ResponseEntity<ResponseStructure<Claim>> saveClaim(@RequestBody Claim claim) {
		return services.saveClaim(claim);
	}

	@PutMapping("/api/claims/{id}")
	public ResponseEntity<ResponseStructure<Claim>> updateClaim(@PathVariable long id, @RequestBody Claim claim) {
		return services.updateClaim(claim);
	}

	@GetMapping("/api/claims")
	public ResponseEntity<ResponseStructure<List<Claim>>> getAll() {
		return services.getAllClaim();
	}

	@GetMapping("/api/claims/{id}")
	public ResponseEntity<ResponseStructure<Claim>> getClaim(@PathVariable long id) {
		return services.getClaim(id);
	}

	@DeleteMapping("/api/claims/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteClaim(@PathVariable long id) {
		return services.deleteClaim(id);
	}

}
