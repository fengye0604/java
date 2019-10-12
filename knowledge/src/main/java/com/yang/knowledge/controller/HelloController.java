package com.yang.knowledge.controller;
import com.yang.knowledge.bean.StudentPropertis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController 注解： 该注解是 @Controller 和 @ResponseBody 注解的合体版
@RestController
public class HelloController {
    @Value("${name}")
    private String name;
    @Value("${age}")
    private Integer age;
    @Value("${content}")
    private String content;
    @Autowired
    private StudentPropertis StudentPropertis;
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("name="+name+"age="+age);
        System.out.println("name="+name+"age="+age+"content="+content+"StudentPropertis.name="+StudentPropertis.getName()+"StudentPropertis.age"+StudentPropertis.getAge());
        return "Hello Spring Boot! name="+name+"age="+age+"content="+content+"StudentPropertis.name="+StudentPropertis.getName()+"StudentPropertis.age"+StudentPropertis.getAge();
    }
}
