package cn.ganzhiqiang.javademo.designpatterns.observer;

import org.springframework.stereotype.Component;

/**
 * @author zqgan
 * @since 2019/1/19
 **/

@Component
public class AddIntegralConcreteObserver implements OrderPaymentHandlerObserver {
    @Override
    public boolean filterEvent(OrderPaymentDetailDTO orderDetail) {
        return true;
    }

    @Override
    public void eventHandler(OrderPaymentDetailDTO orderDetail) {
        System.out.println("AddIntegralConcreteObserver handle success");
    }
}
