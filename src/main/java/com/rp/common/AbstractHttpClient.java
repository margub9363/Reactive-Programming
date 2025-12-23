package com.rp.common;

import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.LoopResources;

public class AbstractHttpClient {
    public static final String BASE_URL = "http://localhost:7070";
    protected final HttpClient httpClient;

    public AbstractHttpClient() {
        var loopResources = LoopResources.create("rahman", 1, true);
        this.httpClient = HttpClient.create().runOn(loopResources).baseUrl(BASE_URL);
    }
}
