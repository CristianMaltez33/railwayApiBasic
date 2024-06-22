package com.maltez.apirest.apirest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maltez.apirest.apirest.Entity.Producto;

public interface IproductoRepository extends JpaRepository<Producto, Long> {

}
