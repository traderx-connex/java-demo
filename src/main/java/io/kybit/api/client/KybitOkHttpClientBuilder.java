package io.kybit.api.client;

import okhttp3.*;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouzhuang
 * @create 2023/9/20 15:47
 */
public class KybitOkHttpClientBuilder {


    public static OkHttpClient build(HttpProxyProperties proxyProperties,Interceptor interceptor) {
        ConnectionPool pool = new ConnectionPool(200, 50, TimeUnit.MINUTES);
        int connTimeout = 30;
        int readTimeout = 30;
        int writeTimeOut = 30;
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(connTimeout, TimeUnit.SECONDS)
                .readTimeout(readTimeout, TimeUnit.SECONDS)
                .writeTimeout(writeTimeOut, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
//                .addNetworkInterceptor(httpLoggingInterceptor)
                .retryOnConnectionFailure(true)
                .connectionPool(pool);

        if (proxyProperties != null && proxyProperties.isEnabled()) {
            builder.proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyProperties.getHost(), proxyProperties.getPort())));
        }
        return builder.build();
    }
}
