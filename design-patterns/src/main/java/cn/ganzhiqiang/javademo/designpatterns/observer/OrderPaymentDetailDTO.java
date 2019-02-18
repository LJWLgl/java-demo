package cn.ganzhiqiang.javademo.designpatterns.observer;

/**
 * @author zqgan
 * @since 2019/1/19
 **/

public class OrderPaymentDetailDTO {

    private Long orderId;

    private Double payAmount;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Double payAmount) {
        this.payAmount = payAmount;
    }
}
