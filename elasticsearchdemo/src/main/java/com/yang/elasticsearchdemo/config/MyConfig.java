package com.yang.elasticsearchdemo.config;


import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.net.InetAddress;



@Configuration
public class MyConfig {
    @Bean
    public TransportClient getTransportClient() throws Exception{
        InetSocketTransportAddress node = new InetSocketTransportAddress(InetAddress.getByName("123.57.91.202"),9300);

        Settings settings = Settings.builder().put("cluster.name", "elasticsearch").build();
        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(node);
        return client;
    }
}
