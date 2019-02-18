package cn.ganzhiqiang.javademo.designpatterns.proxy.dynamic;

/**
 * @author zqgan
 * @since 2019/2/12
 **/

public class UserDao implements IUserDao {

    @Override
    public void register() {
        System.out.println("注册成功");
    }
}
