package com.leon.learnspringsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created on 31/03/2018.
 *
 * @author Xiaolei-Peng
 */
@Controller
@RequestMapping("/spitter")
public class SpitterController {
    @RequestMapping("/me")
    public String me() {
        return "me";
    }
}
