package com.demoRestApi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by chansehorton on 2/17/17.
 */

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
