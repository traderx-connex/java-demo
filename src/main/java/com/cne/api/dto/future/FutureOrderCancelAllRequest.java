package com.cne.api.dto.future;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FutureOrderCancelAllRequest {

    private String symbol;
}
