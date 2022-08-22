package com.uesiglo21.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uesiglo21.demo.entities.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido,Integer>{
	

}
