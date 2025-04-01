package io.kybit.api.client.future;

import io.kybit.api.client.HttpProxyProperties;
import io.kybit.api.client.KybitOkHttpClientBuilder;
import io.kybit.api.interceptor.KybitFutureOkHttpInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


/**
 * B-BASE Future
 * @author kybit
 * @create 2023/9/20 12:18
 */
public class KybitBFutureApiClientImpl extends AbstractKybitFutureApiClient {

    private final static String API_URL = "https://dapi.kybit.io";

    private final KybitFutureApiService service;

    public KybitBFutureApiClientImpl(HttpProxyProperties proxyProperties){
        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl(API_URL)
                        .client(KybitOkHttpClientBuilder.build(proxyProperties,new KybitFutureOkHttpInterceptor()))
                        .addConverterFactory(JacksonConverterFactory.create())
                        .build();
        service = retrofit.create(KybitFutureApiService.class);
    }

    @Override
    KybitFutureApiService getService() {
        return service;
    }
}
