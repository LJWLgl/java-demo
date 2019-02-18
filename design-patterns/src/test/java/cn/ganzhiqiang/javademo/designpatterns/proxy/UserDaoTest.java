package cn.ganzhiqiang.javademo.designpatterns.proxy;

import cn.ganzhiqiang.javademo.designpatterns.proxy.dynamic.IUserDao;
import cn.ganzhiqiang.javademo.designpatterns.proxy.dynamic.ProxyFactory;
import cn.ganzhiqiang.javademo.designpatterns.proxy.dynamic.UserDao;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void testDynamicProxy() {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        IUserDao target = new UserDao();
        System.out.println(target.getClass());  //输出目标对象信息
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());  //输出代理对象信息
        proxy.register();  //执行代理方法
    }

}