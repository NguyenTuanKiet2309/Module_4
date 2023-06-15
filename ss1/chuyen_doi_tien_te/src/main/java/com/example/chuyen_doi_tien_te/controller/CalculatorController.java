package com.example.chuyen_doi_tien_te.controller;

import com.example.chuyen_doi_tien_te.service.ICalculatorService;
import com.example.chuyen_doi_tien_te.service.impl.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping
    public String home() {
        return "index";
    }

    @PostMapping("/calculator")
    public String changeMoney(@RequestParam double money, Model model) {
        model.addAttribute("result", calculatorService.changeMoney(money));
        return "index";
    }
}
