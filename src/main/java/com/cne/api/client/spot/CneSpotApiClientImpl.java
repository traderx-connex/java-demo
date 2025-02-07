package com.cne.api.client.spot;

import com.cne.api.client.HttpProxyProperties;
import com.cne.api.client.CneOkHttpClientBuilder;
import com.cne.api.dto.CommonResponse;

import com.cne.api.dto.spot.NetworthUpdateRequest;
import com.cne.api.dto.spot.SpotPostOrderRequest;
import com.cne.api.dto.spot.SpotUpdateOrderRequest;
import com.cne.api.interceptor.CneSpotOkHttpInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


/**
 * @author zhouzhuang
 * @create 2023/9/20 12:18
 */
public class CneSpotApiClientImpl implements CneSpotApiClient {

    private final static String API_URL = "https://sapi.cne.kg";

    private final CneSpotApiService service;

    public CneSpotApiClientImpl(HttpProxyProperties proxyProperties){
        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl(API_URL)
                        .client(CneOkHttpClientBuilder.build(proxyProperties,new CneSpotOkHttpInterceptor()))
                        .addConverterFactory(JacksonConverterFactory.create())
                        .build();
        service = retrofit.create(CneSpotApiService.class);
    }

    @Override
    public CommonResponse postOrder(SpotPostOrderRequest request) {
        return executeSync(service.postOrder(request));
    }

    @Override
    public CommonResponse getOrder(Long id) {
        return executeSync(service.getOrder(id));
    }

    @Override
    public CommonResponse queryOrder(Long orderId) {
        return executeSync(service.queryOrder(orderId));
    }

    @Override
    public CommonResponse delOrder(Long id) {
        return executeSync(service.delOrder(id));
    }

    @Override
    public CommonResponse updateOrder(Long id, SpotUpdateOrderRequest request) {
        return executeSync(service.updateOrder(id,request));
    }

    @Override
    public CommonResponse netWorth(NetworthUpdateRequest request) {
        return executeSync(service.netWorth(request));
    }

    @Override
    public CommonResponse nftHistoryOrder(Integer type, Integer status, String currency, Long startTime, Long endTime, Integer page, Integer size) {
        return executeSync(service.nftHistoryOrder(type, status, currency, startTime, endTime, page, size));
    }

    public CommonResponse executeSync(Call<CommonResponse> call) {
        try {
            Response<CommonResponse> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            }else {
                System.err.println(String.format("failed to call interface:%s,%s",response.code(),response.toString()));
                return CommonResponse.failure(response.toString());
            }
        }catch (Exception e){
            System.err.println("call interface exception:"+e);
            throw new RuntimeException(e);
        }
    }
}
