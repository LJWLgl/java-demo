package cn.ganzhiqiang.javademo.designpatterns.proxy.uml;

/**
 * @author zqgan
 * @since 2019/2/13
 **/

public class RealSubject implements Subject {
    @Override
    public void handler() {
        System.out.println("RealSubject handler ...");
    }
}
