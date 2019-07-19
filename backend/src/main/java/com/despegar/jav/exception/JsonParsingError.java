package com.despegar.jav.exception;

public class JsonParsingError extends RuntimeException {
    public JsonParsingError(String json) {
        super(json);
    }
}
