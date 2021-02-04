package com.misprojects.robertssupermarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StoreController {

    @GetMapping
    public String getHome(Model model){
        return "index";
    }
}
