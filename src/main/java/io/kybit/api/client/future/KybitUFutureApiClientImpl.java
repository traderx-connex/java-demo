package io.kybit.api.client.future;

import io.kybit.api.client.HttpProxyProperties;
import io.kybit.api.client.KybitOkHttpClientBuilder;
import io.kybit.api.interceptor.KybitFutureOkHttpInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


/**
 * U-BASE future
 * @author kybit
 * @create 2023/9/20 12:18
 */
public class KybitUFutureApiClientImpl extends AbstractKybitFutureApiClient {

    private final static String API_URL = "https://fapi.kybit.io";

    private final KybitFutureApiService service;

    public KybitUFutureApiClientImpl(HttpProxyProperties proxyProperties){
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
