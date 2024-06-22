package com.maltez.apirest.apirest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.maltez.apirest.apirest.Entity.Producto;
import com.maltez.apirest.apirest.Repository.IproductoRepository;

@RestController
@RequestMapping("/producto")

public class ProductoController {
    
    @Autowired
    private IproductoRepository productoRepository;

    @GetMapping
    public List<Producto> getAll() {
        return productoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Producto get(@PathVariable long id) {
        return productoRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro le recurso con el Id: " + id));
    }
    
    
    @PostMapping
    public Producto create(@RequestBody Producto producto) {
        
        return productoRepository.save(producto);
    }
    
    @PutMapping("/{id}")
    public Producto update(@PathVariable long id, @RequestBody Producto productoDTO) {
        
        Producto producto = productoRepository.findById(id).orElseThrow(()-> new RuntimeException("No se encontro le recurso con el Id: " + id));

        producto.setNombre(productoDTO.getNombre());
        producto.setPrecio(productoDTO.getPrecio());

        return productoRepository.save(producto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) { 
        Producto producto = productoRepository.findById(id).orElseThrow(()-> new RuntimeException("No se encontro le recurso con el Id: " + id));

        productoRepository.delete(producto);

        return "Producto eliminado";
    }
}
