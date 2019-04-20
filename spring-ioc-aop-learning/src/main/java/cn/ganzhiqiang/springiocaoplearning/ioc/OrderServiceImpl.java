package cn.ganzhiqiang.springiocaoplearning.ioc;

/**
 * @author zqgan
 * @since 2019/2/20
 **/

public class OrderServiceImpl implements OrderService {
    @Override
    public String reserve() {
        return "success";
    }
}
