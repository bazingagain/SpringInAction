package com.leon.learnspringsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 31/03/2018.
 *
 * @author Xiaolei-Peng
 */

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/")
    public String home() {
        return "index";
    }


}
