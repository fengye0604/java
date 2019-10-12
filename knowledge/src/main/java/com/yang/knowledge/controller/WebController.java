package com.yang.knowledge.controller;

import com.yang.knowledge.bean.User;
import com.yang.knowledge.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@Controller
public class WebController {
    @Resource
    public UserService userService;
    @RequestMapping("/index")
    public String index(Model model ,User user){
        System.out.println(11);
        userService.addUser(user);
        return "index";
    }
    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("name","杨高利1");
        List<String> list = new ArrayList<String>();
        list.add("xiaozhao");
        list.add("xiaofang");
        list.add("xiaoyang");
        model.addAttribute("list",list);
        return "index";
    }

    @ResponseBody
    @RequestMapping("/cookieTest")
    public String cookieTest(HttpServletRequest request, HttpServletResponse response){

        return "";
    }

}
