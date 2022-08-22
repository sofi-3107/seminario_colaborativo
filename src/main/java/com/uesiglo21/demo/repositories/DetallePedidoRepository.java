package com.uesiglo21.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uesiglo21.demo.entities.DetallePedido;

@Repository
public interface DetallePedidoRepository extends CrudRepository<DetallePedido,Integer>{
}
