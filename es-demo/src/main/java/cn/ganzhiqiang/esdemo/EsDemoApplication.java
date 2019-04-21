package cn.ganzhiqiang.esdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@EnableElasticsearchRepositories(basePackages = "cn.ganzhiqiang.esdemo.repo")
@SpringBootApplication
public class EsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsDemoApplication.class, args);
	}

}
