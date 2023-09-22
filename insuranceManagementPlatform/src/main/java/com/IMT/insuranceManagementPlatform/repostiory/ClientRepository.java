package com.IMT.insuranceManagementPlatform.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IMT.insuranceManagementPlatform.dto.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
