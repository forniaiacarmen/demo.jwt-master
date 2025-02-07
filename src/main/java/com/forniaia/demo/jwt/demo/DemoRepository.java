package com.forniaia.demo.jwt.demo;


import com.forniaia.demo.jwt.model.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends CrudRepository<Producto,Long> {

}
