package com.inrik.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NotFoundController {
    @RequestMapping("/404.html")
    public String render404(Model model) {
        // Add model attributes
        return "404";
    }
}