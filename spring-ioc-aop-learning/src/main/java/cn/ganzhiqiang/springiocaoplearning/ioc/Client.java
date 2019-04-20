package cn.ganzhiqiang.springiocaoplearning.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zqgan
 * @since 2019/2/20
 **/

public class Client {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-ioc-1.xml");
        OrderService orderService = context.getBean(OrderService.class);
        System.out.println(orderService.reserve());
    }
}
