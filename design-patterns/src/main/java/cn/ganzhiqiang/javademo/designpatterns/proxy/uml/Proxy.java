package cn.ganzhiqiang.javademo.designpatterns.proxy.uml;

/**
 * @author zqgan
 * @since 2019/2/13
 **/

public class Proxy implements Subject {

    private RealSubject realSubject;

    public Proxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void handler() {
        System.out.println("before");
        realSubject.handler();
        System.out.println("after");
    }
}
