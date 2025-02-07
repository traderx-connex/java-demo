package com.cne.api.client.spot;

import com.cne.api.dto.CommonResponse;
import com.cne.api.dto.spot.NetworthUpdateRequest;
import com.cne.api.dto.spot.SpotPostOrderRequest;
import com.cne.api.dto.spot.SpotUpdateOrderRequest;


/**
 * @author zhouzhuang
 * @create 2023/9/20 11:48
 */
public interface CneSpotApiClient {


    CommonResponse postOrder(SpotPostOrderRequest request);

    CommonResponse getOrder(Long id);

    CommonResponse queryOrder(Long orderId);

    CommonResponse delOrder(Long id);

    CommonResponse updateOrder(Long id, SpotUpdateOrderRequest request);

    CommonResponse netWorth(NetworthUpdateRequest request);

    CommonResponse nftHistoryOrder(Integer type, Integer status, String currency,
                                         Long startTime, Long endTime,
                                         Integer pageIndex, Integer pageSize);
}
