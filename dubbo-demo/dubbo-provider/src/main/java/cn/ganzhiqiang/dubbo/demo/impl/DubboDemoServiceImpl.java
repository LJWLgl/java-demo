package cn.ganzhiqiang.dubbo.demo.impl;

import cn.ganzhiqiang.dubbo.demo.DubboDemoService;

/**
 * @author zqgan
 * @since 2019/5/24
 **/

public class DubboDemoServiceImpl implements DubboDemoService {
    @Override
    public Integer add(Integer x, Integer y) {
        return x + y;
    }
}
