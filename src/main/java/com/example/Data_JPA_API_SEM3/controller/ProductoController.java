package com.example.Data_JPA_API_SEM3.controller;

import com.example.Data_JPA_API_SEM3.model.Producto;
import com.example.Data_JPA_API_SEM3.model.ProductoDTO;
import com.example.Data_JPA_API_SEM3.repository.ProductoRepository;
import com.example.Data_JPA_API_SEM3.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductoController {
    private final ProductoRepository productoRepository;
    private final ProductoService productoService;


    public ProductoController(ProductoRepository productoRepository, ProductoService productoService) {
        this.productoRepository = productoRepository;
        this.productoService = productoService;
    }
    @PostMapping
    public ResponseEntity<ProductoDTO> save(@RequestBody ProductoDTO productoDTO) {
        return new ResponseEntity(productoService.InsertarProducto(productoDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<List<ProductoDTO>> BuscarPorNombre(@PathVariable String nombre) {
        return new ResponseEntity<>(productoService.BuscarNombre(nombre), HttpStatus.OK);
    }



}
