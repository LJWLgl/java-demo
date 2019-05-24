package cn.ganzhiqiang.dubbo.demo.invoker;

import cn.ganzhiqiang.dubbo.demo.DubboDemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zqgan
 * @since 2019/5/24
 **/

public class Consumer {
    public static void main(String[] args) {
        //测试常规服务
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        System.out.println("consumer start");
        DubboDemoService demoService = context.getBean(DubboDemoService.class);
        System.out.println("consumer");
        System.out.println(demoService.add(3, 5));
    }
}
