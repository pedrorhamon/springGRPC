package com.starking.grpc.controller;


//@GrpcService
//public class HelloController extends HelloServiceGrpc.HelloServiceImplBase {
//
//	@Override
//	public void create(ProductRequest request, StreamObserver<ProductResponse> responseObserver) {
//		var response = ProductResponse.newBuilder().setField(null, responseObserver).build();
//
//		responseObserver.onNext(response);
//		responseObserver.onCompleted();
//	}
//	
//	@Override
//	public void findAll(EmptyRequest request, StreamObserver<ProductResponseList> responseObserver) {
//		super.findAll(request, responseObserver);
//	}
//	
//	@Override
//	public void delete(RequestById request, StreamObserver<ProductResponse> responseObserver) {
//		super.delete(request, responseObserver);
//	}
//	
//	@Override
//	public void findById(RequestById request, StreamObserver<ProductResponse> responseObserver) {
//		super.findById(request, responseObserver);
//	}
//}
