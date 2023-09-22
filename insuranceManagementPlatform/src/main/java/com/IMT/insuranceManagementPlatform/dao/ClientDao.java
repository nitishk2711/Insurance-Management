package com.IMT.insuranceManagementPlatform.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.IMT.insuranceManagementPlatform.dto.Client;
import com.IMT.insuranceManagementPlatform.repostiory.ClientRepository;

@Repository
public class ClientDao {

	@Autowired
	private ClientRepository repository;

	public Client saveClient(Client client) {
		return repository.save(client);
	}

	public Client updateClient(Client client) {
		return repository.save(client);
	}

	public Optional<Client> getClient(long id) {
		return repository.findById(id);
	}

	public List<Client> getAllClient() {
		return repository.findAll();
	}

	public void deleteClient(long id) {
		repository.deleteById(id);
	}
}
