package com.uesiglo21.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.uesiglo21.demo.entities.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto,Integer>{

}
