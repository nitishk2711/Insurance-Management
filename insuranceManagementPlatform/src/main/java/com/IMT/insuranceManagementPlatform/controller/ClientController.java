package com.IMT.insuranceManagementPlatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.IMT.insuranceManagementPlatform.dao.ResponseStructure;
import com.IMT.insuranceManagementPlatform.dto.Client;
import com.IMT.insuranceManagementPlatform.service.ClientServices;

@RestController
public class ClientController {
	@Autowired
	private ClientServices services;

	@PostMapping("/api/clients")
	public ResponseEntity<ResponseStructure<Client>> saveClient(@RequestBody Client client) {
		return services.saveClient(client);

	}

	@PutMapping("/api/clients/{id}")
	public ResponseEntity<ResponseStructure<Client>> updateClient(@PathVariable long id, @RequestBody Client client) {
		return services.updateClient(client);
	}
	
	@GetMapping("/api/clients/{id}")
	public ResponseEntity<ResponseStructure<Client>> findClient(@PathVariable long id){
		return services.getClient(id);
	}
	
	@GetMapping("/api/clients")
	public ResponseEntity<ResponseStructure<List<Client>>> findAllClient(){
		return services.getAllClient();
	}

}
