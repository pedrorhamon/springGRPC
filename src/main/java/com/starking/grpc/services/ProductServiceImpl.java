package com.starking.grpc.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.starking.grpc.dto.ProductInputDTO;
import com.starking.grpc.dto.ProductOutputDTO;
import com.starking.grpc.exception.ProductAlreadyExistsException;
import com.starking.grpc.exception.ProductNotFoundException;
import com.starking.grpc.repositories.ProductRepository;
import com.starking.grpc.util.ProductConverterUtil;

@Service
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductOutputDTO create(ProductInputDTO inputDTO) {
        checkDuplicity(inputDTO.getName());
        var product = ProductConverterUtil.productInputDtoToProduct(inputDTO);
        var productCreated = this.productRepository.save(product);
        return ProductConverterUtil.productToProductOutputDto(productCreated);
    }

    @Override
    public ProductOutputDTO findById(Long id) {
        var product = this.productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        return ProductConverterUtil.productToProductOutputDto(product);
    }

    @Override
    public void delete(Long id) {
        var product = this.productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        this.productRepository.delete(product);
    }

    @Override
    public List<ProductOutputDTO> findAll() {
        var products = this.productRepository.findAll();
        return products.stream()
                .map(ProductConverterUtil::productToProductOutputDto)
                .collect(Collectors.toList());
    }

    private void checkDuplicity(String name) {
        this.productRepository.findByNameIgnoreCase(name)
                .ifPresent(e -> {
                    throw new ProductAlreadyExistsException(name);
                });
    }
}