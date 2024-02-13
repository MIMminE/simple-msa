package my.project.msa.orderservice.dto.request;

import lombok.Data;

@Data
public class RequestOrder
{
    private String productId;
    private Integer qty;
    private Integer unitPrice;
}
