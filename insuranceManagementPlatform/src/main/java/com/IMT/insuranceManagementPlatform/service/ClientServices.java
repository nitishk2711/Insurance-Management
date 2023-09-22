package com.IMT.insuranceManagementPlatform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.IMT.insuranceManagementPlatform.dao.ClientDao;
import com.IMT.insuranceManagementPlatform.dao.ResponseStructure;
import com.IMT.insuranceManagementPlatform.dto.Client;
import com.IMT.insuranceManagementPlatform.exception.IdNotFoundException;

@Service
public class ClientServices {
	@Autowired
	private ClientDao dao;

	public ResponseEntity<ResponseStructure<Client>> saveClient(Client client) {
		ResponseStructure<Client> structure = new ResponseStructure<Client>();
		structure.setMessage("Client Registered succefully");
		structure.setBody(dao.saveClient(client));
		structure.setCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Client>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Client>> updateClient(Client client) {
		ResponseStructure<Client> structure = new ResponseStructure<>();
		structure.setMessage("update Client succesfully");
		structure.setBody(dao.updateClient(client));
		structure.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Client>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Client>> getClient(long id) {
		ResponseStructure<Client> structure = new ResponseStructure<>();
		Optional<Client> recClient = dao.getClient(id);
		if (recClient.isPresent()) {
			structure.setMessage("Client Found");
			structure.setBody(recClient.get());
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Client>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();

	}

	public ResponseEntity<ResponseStructure<List<Client>>> getAllClient() {
		ResponseStructure<List<Client>> structure = new ResponseStructure<>();
		structure.setBody(dao.getAllClient());
		structure.setMessage("All Client are Display");
		structure.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Client>>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> deleteClient(long id) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		Optional<Client> recClient = dao.getClient(id);
		if (recClient.isPresent()) {
			dao.deleteClient(id);
			structure.setMessage("Client Found");
			structure.setBody("Client Deleted");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();

	}

}
