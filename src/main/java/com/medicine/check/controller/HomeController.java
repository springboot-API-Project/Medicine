package com.medicine.check.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @GetMapping("blog")
    public String blog() {
        return "blog";
    }
    @GetMapping("blog-details")
    public String blog_details() {
        return "blog-details";
    }
    @GetMapping("contact")
    public String contact() {
        return "contact";
    }
    @GetMapping("listing")
    public String listing() {
        return "listing";
    }
    @GetMapping("listing-details")
    public String listing_details() {
        return "listing-details";
    }
}
