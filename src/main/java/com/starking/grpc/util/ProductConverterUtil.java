package com.starking.grpc.util;

import com.starking.grpc.dto.ProductInputDTO;
import com.starking.grpc.dto.ProductOutputDTO;
import com.starking.grpc.model.Product;

public class ProductConverterUtil {

    public static ProductOutputDTO productToProductOutputDto(Product product) {
        return new ProductOutputDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getQuantityInStock()
        );
    }

    public static Product productInputDtoToProduct(ProductInputDTO product) {
        return new Product(
                null,
                product.getName(),
                product.getPrice(),
                product.getQuantityInStock()
        );
    }
}
