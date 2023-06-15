package com.example.chuyen_doi_tien_te.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping
    public String home() {
        return "index";
    }

    @GetMapping("/calculator")
    public String changeMoney(@RequestParam double usd, @RequestParam double rate, Model model) {
        double result = usd * rate;
        model.addAttribute("result", result);
        return "index";
    }
}
