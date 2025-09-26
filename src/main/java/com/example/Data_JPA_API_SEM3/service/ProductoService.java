package com.example.Data_JPA_API_SEM3.service;

import com.example.Data_JPA_API_SEM3.model.Producto;
import com.example.Data_JPA_API_SEM3.model.ProductoDTO;
import com.example.Data_JPA_API_SEM3.repository.ProductoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<ProductoDTO> BuscarNombre(String nombre) {
        List<Producto>  productos = productoRepository.findByNombreContainingIgnoreCase(nombre);
        List<ProductoDTO> productoDTOs = new ArrayList<>();
        ProductoDTO productoDTO; //= new ProductoDTO();

        for(Producto producto: productos){
            productoDTO = new ProductoDTO();
            productoDTO.setId(producto.getId());

            productoDTO.setNombre(producto.getNombre());

            productoDTO.setPrecio(producto.getPrecio());

            productoDTOs.add(productoDTO);

        }
        return productoDTOs;
    }
    public Producto InsertarProducto(ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setPrecio(productoDTO.getPrecio());
        return productoRepository.save(producto);
    }
}
