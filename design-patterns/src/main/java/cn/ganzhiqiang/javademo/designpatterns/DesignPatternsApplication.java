package cn.ganzhiqiang.javademo.designpatterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author zqgan
 * @since 2019/1/19
 **/

@EnableAspectJAutoProxy(exposeProxy = true)
@SpringBootApplication
public class DesignPatternsApplication {
    public static void main(String[] args) {
        SpringApplication.run(DesignPatternsApplication.class, args);
    }
}
