package com.knotty.twitter.security.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {
    @GetMapping("/just-auth")
    public String auth(){
        return "this is protected";
    }
    @GetMapping("/just-role-user")
    public String authUser(){
        return "this is user";
    }
    @GetMapping("/just-role-admin")
    public String authAdmin(){
        return "this is admin";
    }
}
