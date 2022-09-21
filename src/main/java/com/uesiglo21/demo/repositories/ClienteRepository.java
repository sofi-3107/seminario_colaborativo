package com.uesiglo21.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uesiglo21.demo.entities.Cliente;
import com.uesiglo21.demo.exceptions.ClientNotfoundException;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente,Integer>{
	
	public Cliente findByDocumento(String documento)throws ClientNotfoundException;

}
