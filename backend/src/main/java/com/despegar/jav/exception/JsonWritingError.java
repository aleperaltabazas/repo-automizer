package com.despegar.jav.exception;

public class JsonWritingError extends RuntimeException {
    public JsonWritingError(Object object) {
        super(object.toString());
    }
}
