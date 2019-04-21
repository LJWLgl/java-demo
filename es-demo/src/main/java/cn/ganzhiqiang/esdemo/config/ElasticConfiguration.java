package cn.ganzhiqiang.esdemo.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.InetAddress;

/**
 * @author zqgan
 * @since 2019/4/20
 **/

@Configuration
public class ElasticConfiguration {

    @Value("${es.host}")
    private String esHost;

    @Value("${es.port}")
    private int esPort;

    @Value("${es.clusterName}")
    private String esClusterName;

    private TransportClient client;

    @PostConstruct
    public void initialize() throws Exception {
        Settings esSettings = Settings.builder()
                .put("cluster.name", "elasticsearch_nanxuan")
                .put("client.transport.sniff", false).build();
        client = new PreBuiltTransportClient(esSettings);

        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(esHost), esPort));
//        String[] esHosts = esHost.trim().split(",");
//        for (String host : esHosts) {
//            client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), esPort));
//        }
        System.out.println(client.listedNodes());
    }

    @Bean
    public Client client() {
        return client;
    }


    @Bean
    public ElasticsearchTemplate elasticsearchTemplate() throws Exception {
        return new ElasticsearchTemplate(client);
    }


    @PreDestroy
    public void destroy() {
        if (client != null) {
            client.close();
        }
    }
}
