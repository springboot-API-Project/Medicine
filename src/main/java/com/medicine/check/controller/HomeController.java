package com.medicine.check.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String Home() {
        return "index";
    }
    @GetMapping("main")
    public String main() {
        return "main";
    }
    @GetMapping("about")
    public String about() {
        return "about";
    }
    @GetMapping("contact")
    public String contact() {
        return "contact";
    }
}
