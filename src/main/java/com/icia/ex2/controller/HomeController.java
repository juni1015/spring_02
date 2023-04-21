package com.icia.ex2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.datatransfer.DataFlavor;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index() {return "index";}

    @GetMapping("/hello1")
    public String hello1() {return "hello1";}

    @GetMapping("/hello2")
    public String hello2() {return "hello2";}

    @GetMapping("/hello-param1")
    public String helloParam1(@RequestParam("name") String name, @RequestParam("age") int age) {
        System.out.println("name = " + name + ", age = " + age);
//        int age1 = Integer.parseInt(request.getParameter("age"));
        return "index";
    }
}
