package com.cne.api.client.future;

import com.cne.api.client.HttpProxyProperties;
import com.cne.api.client.CneOkHttpClientBuilder;
import com.cne.api.interceptor.CneFutureOkHttpInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


/**
 * B-BASE Future
 * @author cne
 * @create 2023/9/20 12:18
 */
public class CneBFutureApiClientImpl extends AbstractCneFutureApiClient {

    private final static String API_URL = "https://dapi.cne.kg";

    private final CneFutureApiService service;

    public CneBFutureApiClientImpl(HttpProxyProperties proxyProperties){
        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl(API_URL)
                        .client(CneOkHttpClientBuilder.build(proxyProperties,new CneFutureOkHttpInterceptor()))
                        .addConverterFactory(JacksonConverterFactory.create())
                        .build();
        service = retrofit.create(CneFutureApiService.class);
    }

    @Override
    CneFutureApiService getService() {
        return service;
    }
}
