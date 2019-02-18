package cn.ganzhiqiang.javademo.designpatterns.observer;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author zqgan
 * @since 2019/1/19
 **/

@Component
public class OrderPaymentConcreteSubject implements OrderPaymentSubject,ApplicationListener<ContextRefreshedEvent> {

    private List<OrderPaymentHandlerObserver> observers;

    @Override
    public void notifyObservers(OrderPaymentDetailDTO orderDetail) {
        for (OrderPaymentHandlerObserver observer : observers) {
            if (observer.filterEvent(orderDetail)) {
                observer.eventHandler(orderDetail);
            }
        }
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initObserver(event);
    }

    private void initObserver(ContextRefreshedEvent event) {
        Map<String, OrderPaymentHandlerObserver> observerMap = BeanFactoryUtils.beansOfTypeIncludingAncestors(
                event.getApplicationContext(), OrderPaymentHandlerObserver.class, true, false);
        this.observers = Collections.unmodifiableList(new ArrayList<>(observerMap.values()));
    }

}
