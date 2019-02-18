package cn.ganzhiqiang.javademo.designpatterns.proxy.dynamic;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zqgan
 * @since 2019/2/13
 **/

public class CglibProxyFactory {

    private Object target;
    public CglibProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        Enhancer en = new Enhancer();
        en.setSuperclass(target.getClass());
        en.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("开启事务");
                // 执行目标对象的方法
                Object returnValue = methodProxy.invokeSuper(target, objects);
                System.out.println("关闭事务");
                return returnValue;
            }
        });
        return en.create();
    }

}
