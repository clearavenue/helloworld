package com.clearavenue.helloworld.service;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public class HeaderRequestInterceptor implements ClientHttpRequestInterceptor {

	private final String headerName;
    private final String headerValue;

    public HeaderRequestInterceptor(final String name, final String value) {
        this.headerName = name;
        this.headerValue = value;
    }
    
	@Override
	public ClientHttpResponse intercept(final HttpRequest request, final byte[] body, final ClientHttpRequestExecution execution)
			throws IOException {
		request.getHeaders().set(headerName, headerValue);
        return execution.execute(request, body);
	}

}
