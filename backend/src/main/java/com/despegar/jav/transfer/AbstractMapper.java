package com.despegar.jav.transfer;

import com.despegar.jav.exception.JsonParsingError;
import com.despegar.jav.exception.JsonWritingError;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AbstractMapper {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractMapper.class);

    @Autowired
    private ObjectMapper mapper;

    public AbstractMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public <T> T fromJson(String json, TypeReference<T> entityClass) {
        try {
            return mapper.readValue(json, entityClass);
        } catch (IOException e) {
            LOGGER.error("Error when parsing json. Class: " + entityClass.getType().getTypeName(), e);
            throw new JsonParsingError(json);
        }
    }

    public String toJson(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            LOGGER.error("Error when creating json for object: {}", object);
            throw new JsonWritingError(object);
        }

    }
}