package com.yang.elasticsearchdemo.controller;

import org.elasticsearch.client.transport.TransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    public static Logger logger = LoggerFactory.getLogger(TestController.class);
    @Autowired
    TransportClient client;
    @RequestMapping("/test")
    public ResponseEntity myTest(){
        logger.debug("测试方法，测试日志、方法是否正常提供服务{},{}",123,client);
        return new ResponseEntity("ok1", HttpStatus.OK);
    }
}
