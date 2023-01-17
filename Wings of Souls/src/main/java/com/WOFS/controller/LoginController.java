package com.WOFS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Juan Carlos
 */
@Controller
public class LoginController {
    
    @GetMapping
    public String main() {
        return "index";
    }
    
    @GetMapping("login")
    public String login() {
        return "/login";
    }
    
    @GetMapping("logout")
    public String logout() {
        return "redirect:login";
    }
}
