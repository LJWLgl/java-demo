package cn.ganzhiqiang.javademo.designpatterns.observer;

/**
 * @author zqgan
 * @since 2019/1/19
 **/

public interface OrderPaymentSubject {

    /**
     * 通知观察者
     * @param orderDetail 支付明细
     */
    void notifyObservers(OrderPaymentDetailDTO orderDetail);

}
