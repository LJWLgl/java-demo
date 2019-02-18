package cn.ganzhiqiang.javademo.designpatterns.proxy.handlerthis;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author zqgan
 * @since 2019/2/18
 **/


@Component
@Aspect
public class TestAspect {

    @Pointcut("execution(public * cn.ganzhiqiang.javademo.designpatterns.proxy.handlerthis.TestProxyImpl.*(..))")
    public void log() {
    }

    @Before("log()")
    public void writeLog() {
        System.out.println("[AOP] Before ...");
    }

}
