package io.kybit.api.dto.future;

import lombok.Builder;
import lombok.Data;


/**
 * @author zhouzhuang
 * @create 2023/9/21 18:03
 */
@Data
@Builder
public class FutureBatchOrderRequest {

    private String list;
}
