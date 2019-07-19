package alesaurio.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String body) {
        super(body);
    }
}
