package alesaurio.http;

import org.apache.http.client.methods.HttpRequestBase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:token.properties")
public class GithubConnector extends Connector {
    @Value("${authorization.token.value}")
    private String authorizationHeader;

    @Override
    protected HttpRequestBase addHeaders(HttpRequestBase request) {
        request.addHeader("Authorization", String.format("token %s", authorizationHeader));
        return request;
    }
}