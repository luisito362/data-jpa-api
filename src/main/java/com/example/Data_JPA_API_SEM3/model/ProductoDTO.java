package com.example.Data_JPA_API_SEM3.model;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "productos")
@Data // @Gether y @Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductoDTO {
    private Long id;
    private String nombre;
    private double precio;
}
