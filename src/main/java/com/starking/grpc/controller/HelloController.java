package com.starking.grpc.controller;

import com.starking.grpc.*;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloController extends HelloServiceGrpc.HelloServiceImplBase {

	@Override
	public void create(ProductRequest request, StreamObserver<ProductResponse> responseObserver) {
		var response = ProductResponse.newBuilder().setField(null, responseObserver).build();

		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
	
	@Override
	public void findAll(EmptyRequest request, StreamObserver<ProductResponseList> responseObserver) {
		// TODO Auto-generated method stub
		super.findAll(request, responseObserver);
	}

}
