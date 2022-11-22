package com.starking.grpc.exception;

public abstract class BaseBusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public BaseBusinessException(String message) {
        super(message);
    }
    public abstract io.grpc.Status getStatusCode();
    public abstract String getErrorMessage();
}