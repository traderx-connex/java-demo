package io.kybit.api.client.future;

import io.kybit.api.dto.FutureCommonResponse;
import io.kybit.api.dto.future.FuturePostOrderRequest;


import java.util.List;
import java.util.Map;


/**
 * @author zhouzhuang
 * @create 2023/9/20 11:48
 */
public interface KybitFutureApiClient {


    FutureCommonResponse postOrder(FuturePostOrderRequest request);

    FutureCommonResponse batchOrder(List<FuturePostOrderRequest> futurePostOrderRequestList);


    FutureCommonResponse orderListHistory(Map<String, String> params);

    FutureCommonResponse orderTradeList(Map<String, String> params);

    FutureCommonResponse orderDetail(Long orderId);

    FutureCommonResponse orderList(Map<String, String> params);

    FutureCommonResponse orderCancel(Long orderId);

    FutureCommonResponse allCancel(String symbol);

    FutureCommonResponse entrustCreatePlan(Map<String, String> params);

    FutureCommonResponse entrustCancelPlan(Long entrustId);

    FutureCommonResponse entrustCancelAllPlan(String symbol);



    FutureCommonResponse accountInfo();

    FutureCommonResponse balanceDetail(String coin);

    FutureCommonResponse listenKey();

    FutureCommonResponse adjustLeverage(String symbol,String positionSide,Integer leverage);

}
