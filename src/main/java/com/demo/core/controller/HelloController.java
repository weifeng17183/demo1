package com.demo.core.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model, HttpServletRequest request) {
        model.addAttribute("spring", "spring mvc");
        return "hello";
    }
}
