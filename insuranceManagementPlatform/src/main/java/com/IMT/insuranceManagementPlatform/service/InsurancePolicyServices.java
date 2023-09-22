package com.IMT.insuranceManagementPlatform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.IMT.insuranceManagementPlatform.dao.InsurancePolicyDao;
import com.IMT.insuranceManagementPlatform.dao.ResponseStructure;
import com.IMT.insuranceManagementPlatform.dto.InsurancePolicy;
import com.IMT.insuranceManagementPlatform.exception.IdNotFoundException;

@Service
public class InsurancePolicyServices {

	@Autowired
	private InsurancePolicyDao dao;

	public ResponseEntity<ResponseStructure<InsurancePolicy>> saveInsurancePolicy(InsurancePolicy insurancePolicy) {
		ResponseStructure<InsurancePolicy> structure = new ResponseStructure<InsurancePolicy>();
		structure.setMessage("InsurancePolicy Registered succefully");
		structure.setBody(dao.saveInsurancePolicy(insurancePolicy));
		structure.setCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<InsurancePolicy>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<InsurancePolicy>> updateInsurancePolicy(InsurancePolicy insurancePolicy) {
		ResponseStructure<InsurancePolicy> structure = new ResponseStructure<>();
		structure.setMessage("update InsurancePolicy succesfully");
		structure.setBody(dao.updateInsurancePolicy(insurancePolicy));
		structure.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<InsurancePolicy>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<InsurancePolicy>> getInsurancePolicyy(long id) {
		ResponseStructure<InsurancePolicy> structure = new ResponseStructure<>();
		Optional<InsurancePolicy> recInsurancePolicy = dao.findInsurancePolicy(id);
		if (recInsurancePolicy.isPresent()) {
			structure.setMessage("InsurancePolicy Found");
			structure.setBody(recInsurancePolicy.get());
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<InsurancePolicy>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();

	}

	public ResponseEntity<ResponseStructure<List<InsurancePolicy>>> getAllInsurancePolicy() {
		ResponseStructure<List<InsurancePolicy>> structure = new ResponseStructure<>();
		structure.setBody(dao.findAll());
		structure.setMessage("All InsurancePolicy are Display");
		structure.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<InsurancePolicy>>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> deleteInsurancePolicy(long id) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		Optional<InsurancePolicy> recInsurancePolicy = dao.findInsurancePolicy(id);
		if (recInsurancePolicy.isPresent()) {
			dao.deleteInsurancePolicy(id);
			structure.setMessage("InsurancePolicy Found");
			structure.setBody("InsurancePolicy Deleted");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();

	}

}
