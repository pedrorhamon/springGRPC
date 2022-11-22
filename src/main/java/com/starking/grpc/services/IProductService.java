package com.starking.grpc.services;

import java.util.List;

import com.starking.grpc.dto.ProductInputDTO;
import com.starking.grpc.dto.ProductOutputDTO;

public interface IProductService {
    ProductOutputDTO create(ProductInputDTO inputDTO);
    ProductOutputDTO findById(Long id);
    void delete(Long id);
    List<ProductOutputDTO> findAll();
}
