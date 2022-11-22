package com.starking.grpc.controller;


//@GrpcService
//public class ProductResource extends ProductServiceGrpc.ProductServiceImplBase {
//
//    private final IProductService productService;
//
//    public ProductResource(IProductService productService) {
//        this.productService = productService;
//    }
//
//    @Override
//    public void create(ProductRequest request, StreamObserver<ProductResponse> responseObserver) {
//        ProductInputDTO inputDTO = new ProductInputDTO(
//                request.getName(),
//                request.getPrice(),
//                request.getQuantityInStock()
//        );
//
//        ProductOutputDTO outputDTO = this.productService.create(inputDTO);
//
//        ProductResponse response = ProductResponse.newBuilder()
//                .setId(outputDTO.getId())
//                .setName(outputDTO.getName())
//                .setPrice(outputDTO.getPrice())
//                .setQuantityInStock(outputDTO.getQuantityInStock())
//                .build();
//
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }
//
//    @Override
//    public void findById(RequestById request, StreamObserver<ProductResponse> responseObserver) {
//        ProductOutputDTO outputDTO = productService.findById(request.getId());
//        ProductResponse response = ProductResponse.newBuilder()
//                .setId(outputDTO.getId())
//                .setName(outputDTO.getName())
//                .setPrice(outputDTO.getPrice())
//                .setQuantityInStock(outputDTO.getQuantityInStock())
//                .build();
//
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }
//
//    @Override
//    public void delete(RequestById request, StreamObserver<EmptyResponse> responseObserver) {
//        productService.delete(request.getId());
//        responseObserver.onNext(EmptyResponse.newBuilder().build());
//        responseObserver.onCompleted();
//    }
//
//    @Override
//    public void findAll(EmptyRequest request, StreamObserver<ProductResponseList> responseObserver) {
//        List<ProductOutputDTO> outputDTOList = productService.findAll();
//        List<ProductResponse> productResponseList = outputDTOList.stream()
//                .map(outputDTO ->
//                        ProductResponse.newBuilder()
//                                .setId(outputDTO.getId())
//                                .setName(outputDTO.getName())
//                                .setPrice(outputDTO.getPrice())
//                                .setQuantityInStock(outputDTO.getQuantityInStock())
//                                .build())
//                .collect(Collectors.toList());
//
//        ProductResponseList response = ProductResponseList.newBuilder()
//                .addAllProducts(productResponseList)
//                .build();
//
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }
//}