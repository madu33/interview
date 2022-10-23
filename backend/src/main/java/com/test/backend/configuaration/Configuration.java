package com.test.backend.configuaration;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public RestTemplate restTemplate() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        SSLConnectionSocketFactory scsf = new SSLConnectionSocketFactory(
                SSLContexts.custom().loadTrustMaterial(null, new TrustSelfSignedStrategy()).build(),
                NoopHostnameVerifier.INSTANCE);
        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(scsf).build();
        HttpComponentsClientHttpRequestFactory requestFactory =
                new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpclient);
        return new RestTemplate(requestFactory);
    }
}
