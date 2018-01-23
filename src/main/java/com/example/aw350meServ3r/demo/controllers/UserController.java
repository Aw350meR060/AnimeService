package com.example.aw350meServ3r.demo.controllers;

import com.example.aw350meServ3r.demo.services.UserDetailsServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserDetailsServiceUtil userDetailsServiceUtil;

    @GetMapping
    public ModelAndView getRegistrationForm(){
        return new ModelAndView("Registration");
    }

    @PostMapping("/register")
    public String post(@RequestParam Map<String, String> params){
        System.out.println(params.get("username"));
        System.out.println(params.get("password"));
        return userDetailsServiceUtil.registerAcc(params.get("username"), params.get("password"));
    }
}
