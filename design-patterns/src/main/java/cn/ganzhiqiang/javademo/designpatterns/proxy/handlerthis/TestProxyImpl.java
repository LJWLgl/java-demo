package cn.ganzhiqiang.javademo.designpatterns.proxy.handlerthis;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author zqgan
 * @since 2019/2/18
 **/

@Component(value = "testProxy")
public class TestProxyImpl implements ITestProxy,ApplicationContextAware {


//    @Override
//    public void testA() {
//        System.out.println("testA() execute ...");
//        //从ThreadLocal中取出代理对象，前提已设置expose-proxy属性为true，暴露了代理对象
//        ITestProxy proxy = (ITestProxy) AopContext.currentProxy();
//        proxy.testB();
//    }

    private ApplicationContext applicationContext;

    @Override
    public void testA() {
        System.out.println("testA() execute ...");
        applicationContext.getBean("testProxy", ITestProxy.class).testB();
    }

    @Override
    public void testB() {
        System.out.println("testB() execute ...");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
