package cn.ganzhiqiang.javademo.designpatterns.proxy.uml;

/**
 * @author zqgan
 * @since 2019/2/13
 **/

public class Client {

    public static void main(String[] args) {
        Proxy proxy = new Proxy(new RealSubject());
        proxy.handler();
    }
}
