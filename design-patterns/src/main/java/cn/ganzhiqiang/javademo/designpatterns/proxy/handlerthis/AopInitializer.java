package cn.ganzhiqiang.javademo.designpatterns.proxy.handlerthis;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author zqgan
 * @since 2018/12/4
 **/

@Component
public class AopInitializer implements ApplicationListener<ContextRefreshedEvent> {

    @Resource
    ITestProxy testProxy;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        testProxy.testA();
    }

}
