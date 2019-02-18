package cn.ganzhiqiang.javademo.designpatterns.proxy.dynamic;

import org.springframework.cglib.core.DebuggingClassWriter;

/**
 * @author zqgan
 * @since 2019/2/13
 **/

public class Client {
    public static void main(String[] args) {
        // 拿到JDK动态代理类
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        // 拿到Cglib动态代理类
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/nanxuan/temp");
        IUserDao target = new UserDao();
        System.out.println(target.getClass());  //输出目标对象信息
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());  //输出代理对象信息
        proxy.register();  //执行代理方法

        IUserDao cglibProxy = (IUserDao) new CglibProxyFactory(target).getProxyInstance();
        cglibProxy.register();
    }
}
