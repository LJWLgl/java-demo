package cn.ganzhiqiang.javademo.designpatterns.observer;

/**
 * @author zqgan
 * @since 2019/1/19
 **/

public interface OrderPaymentHandlerObserver {

    /**
     * 判断是否处理该Event
     * @param orderDetail 订单明细
     * @return 是否支持
     */
    boolean filterEvent(OrderPaymentDetailDTO orderDetail);

    /**
     * Event处理
     * @param orderDetail 订单明细
     */
    void eventHandler(OrderPaymentDetailDTO orderDetail);

}
