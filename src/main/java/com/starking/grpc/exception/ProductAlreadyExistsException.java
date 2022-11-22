package com.starking.grpc.exception;

import io.grpc.Status;

public class ProductAlreadyExistsException extends BaseBusinessException {

	private static final long serialVersionUID = 1L;
	
	private static final String ERROR_MESSAGE = "Produto %s já cadastrado no sistema.";
    private final String name;

    public ProductAlreadyExistsException(String name) {
        super(String.format(ERROR_MESSAGE, name));
        this.name = name;
    }

    @Override
    public io.grpc.Status getStatusCode() {
        return Status.ALREADY_EXISTS;
    }

    @Override
    public String getErrorMessage() {
        return String.format(ERROR_MESSAGE, this.name);
    }
}