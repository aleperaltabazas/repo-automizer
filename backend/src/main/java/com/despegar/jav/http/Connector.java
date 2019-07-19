package com.despegar.jav.http;

import com.despegar.jav.exception.BadRequestException;
import com.despegar.jav.exception.InternalServerErrorException;
import com.despegar.jav.exception.ResourceNotFoundException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public abstract class Connector {
    private static final Logger LOGGER = LoggerFactory.getLogger(Connector.class);
    private HttpClient client = HttpClientBuilder.create().build();

    public String get(String url) {
        HttpGet request = new HttpGet(url);
        addHeaders(request);
        try {
            HttpResponse response = client.execute(request);

            return this.checkState(response);
        } catch (IOException e) {
            LOGGER.error("Error when executing GET method on route " + url, e);
            throw new IllegalArgumentException(e);
        } finally {
            close(request);
        }
    }

    public String post(String url, String body) {
        HttpPost request = new HttpPost(url);
        addHeaders(request);

        StringEntity params = new StringEntity(body, ContentType.APPLICATION_JSON);
        request.setEntity(params);

        try {

            HttpResponse response = client.execute(request);

            return this.checkState(response, body);
        } catch (IOException e) {
            LOGGER.error("Error when executing PUT method on route " + url, e);
            throw new IllegalArgumentException(e);
        } finally {
            close(request);
        }
    }

    public String delete(String url) {
        HttpDelete request = new HttpDelete(url);
        addHeaders(request);

        try {
            HttpResponse response = client.execute(request);

            return this.checkState(response);
        } catch (IOException e) {
            LOGGER.error("Error when executing DELETE method on route " + url, e);
            throw new IllegalArgumentException(e);
        } finally {
            close(request);
        }
    }

    public String put(String url, String body) {
        HttpPut request = new HttpPut(url);
        addHeaders(request);

        StringEntity params = new StringEntity(body, ContentType.APPLICATION_JSON);
        request.setEntity(params);

        try {
            HttpResponse response = client.execute(request);

            return this.checkState(response, body);
        } catch (IOException e) {
            LOGGER.error("Error when executing PUT method on route " + url, e);
            throw new IllegalArgumentException(e);
        } finally {
            close(request);
        }
    }

    public String patch(String url, String body) {
        HttpPatch request = new HttpPatch(url);
        addHeaders(request);

        StringEntity params = new StringEntity(body, ContentType.APPLICATION_JSON);
        request.setEntity(params);

        try {
            HttpResponse response = client.execute(request);

            return this.checkState(response, body);
        } catch (IOException e) {
            LOGGER.error("Error when executing PUT method on route " + url, e);
            throw new IllegalArgumentException(e);
        } finally {
            close(request);
        }
    }

    private void close(HttpRequestBase request) {
        request.releaseConnection();
        LOGGER.info("Connection closed.");
    }

    private String checkState(HttpResponse response) {
        return this.checkState(response, null);
    }

    protected abstract HttpRequestBase addHeaders(HttpRequestBase request);

    private String checkState(HttpResponse response, String body) {
        Integer httpStatus = response.getStatusLine().getStatusCode();
        LOGGER.debug("Received response Status code: " + httpStatus);
        switch (httpStatus) {
            case 200:
            case 201: {
                try {
                    BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                    return rd.readLine();
                } catch (IOException e) {
                    throw new IllegalArgumentException(e);
                }
            }
            case 204:
                return "it's alright";
            case 400:
                throw new BadRequestException(body);
            case 404: {
                LOGGER.error("Resource not found on other end.");
                throw new ResourceNotFoundException(body);
            }
            default: {
                try {
                    BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                    LOGGER.warn("Response from other end: " + rd.readLine());
                } catch (IOException e) {
                    LOGGER.error("Error reading response", e);
                }

                throw new InternalServerErrorException("Server error, fromJson: " + body);
            }
        }

    }
}