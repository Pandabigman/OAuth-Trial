package org.example.lab_3_oauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaController {
    @RequestMapping("/")
    public String Home(){
        return "Unsecured Page";
    }

    @RequestMapping("/secured")
    public String Secured(){
        return "Secured Page";
    }

}
