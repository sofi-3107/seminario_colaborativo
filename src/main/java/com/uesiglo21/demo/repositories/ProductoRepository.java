package com.uesiglo21.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uesiglo21.demo.entities.Producto;
import com.uesiglo21.demo.exceptions.ProductNotFoundException;

@Repository
public interface ProductoRepository extends CrudRepository<Producto,Integer>{

	List<Producto>findByCantidadEnStockGreaterThan(int cantidad)throws ProductNotFoundException;
}
