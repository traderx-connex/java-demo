package io.kybit.demo;

import io.kybit.api.client.spot.KybitSpotApiClientImpl;
import io.kybit.api.dto.CommonResponse;
import io.kybit.api.dto.spot.NetworthUpdateRequest;
import io.kybit.api.dto.spot.SpotPostOrderRequest;
import io.kybit.api.dto.spot.SpotUpdateOrderRequest;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * SPOT Business
 * @author zhouzhuang
 * @create 2023/9/20 16:15
 */
public class SpotApiClientTest {

    KybitSpotApiClientImpl spotApiClient = new KybitSpotApiClientImpl(null);

    @Test
    public void testpostOrder() {
        SpotPostOrderRequest request = SpotPostOrderRequest.builder().symbol("btc_usdt")
                .side("BUY")
                .type("LIMIT")
                .timeInForce("GTC")
                .bizType("SPOT")
                .price("63000")
                .quantity("0.001")
                .media("btok")
                .mediaChannel("btok123")
                .build();
        CommonResponse commonResponse = spotApiClient.postOrder(request);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void getOrder() {
        CommonResponse commonResponse = spotApiClient.getOrder(351569051824340480L);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void queryOrder() {
        CommonResponse commonResponse = spotApiClient.queryOrder(274722413139647104L);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void delOrder() {
        CommonResponse commonResponse = spotApiClient.delOrder(274722413139647104L);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void netWorth() {
        NetworthUpdateRequest request = NetworthUpdateRequest.builder().symbol("btc3l_usdt").netWorth(BigDecimal.valueOf(1.2)).build();
        CommonResponse commonResponse = spotApiClient.netWorth(request);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void updateOrder(){
        CommonResponse commonResponse = spotApiClient.updateOrder(407309222976613568L, SpotUpdateOrderRequest.builder().quantity("0.002").price("63010").build());
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void nftHistoryOrder() {
        CommonResponse commonResponse = spotApiClient.nftHistoryOrder(2, null, null, null, null, 1, 10);
        System.out.println("result:" + commonResponse);
    }
}
