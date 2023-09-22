package com.IMT.insuranceManagementPlatform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.IMT.insuranceManagementPlatform.dao.ClaimDao;
import com.IMT.insuranceManagementPlatform.dao.ResponseStructure;
import com.IMT.insuranceManagementPlatform.dto.Claim;
import com.IMT.insuranceManagementPlatform.exception.IdNotFoundException;

@Service
public class ClaimServices {

	@Autowired
	private ClaimDao dao;

	public ResponseEntity<ResponseStructure<Claim>> saveClaim(Claim claim) {
		ResponseStructure<Claim> structure = new ResponseStructure<Claim>();
		structure.setMessage("Claim Registered succefully");
		structure.setBody(dao.saveClaim(claim));
		structure.setCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Claim>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Claim>> updateClaim(Claim claim) {
		ResponseStructure<Claim> structure = new ResponseStructure<>();
		structure.setMessage("update Claim succesfully");
		structure.setBody(dao.updateClaim(claim));
		structure.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Claim>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Claim>> getClaim(long id) {
		ResponseStructure<Claim> structure = new ResponseStructure<>();
		Optional<Claim> recClaim = dao.findClaim(id);
		if (recClaim.isPresent()) {
			structure.setMessage("Claim Found");
			structure.setBody(recClaim.get());
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Claim>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();

	}

	public ResponseEntity<ResponseStructure<List<Claim>>> getAllClaim() {
		ResponseStructure<List<Claim>> structure = new ResponseStructure<>();
		structure.setBody(dao.findAll());
		structure.setMessage("All Claim are Display");
		structure.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Claim>>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> deleteClaim(long id) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		Optional<Claim> recClaim = dao.findClaim(id);
		if (recClaim.isPresent()) {
			dao.deleteClaim(id);
			structure.setMessage("Claim Found");
			structure.setBody("Claim Deleted");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();

	}

}
