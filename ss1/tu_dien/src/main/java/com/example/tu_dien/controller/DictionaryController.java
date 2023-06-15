package com.example.tu_dien.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;


@Controller
public class DictionaryController {
    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/dictionary")
    public String dictionary(@RequestParam String text, Model model) {
        String result = null;
        Map<String, String> stringMap = new LinkedHashMap<>();
        stringMap.put("learn", "Học");
        stringMap.put("head phone", "Tai nghe");
        stringMap.put("computer", "Máy tính");
        stringMap.put("mouse", "Chuột");
        stringMap.put("pig", "Heo");
        for (String m : stringMap.keySet()) {
            if (text.toLowerCase(Locale.ROOT).equals(m)) {
                result = stringMap.get(m);
                break;
            } else {
                result = "Từ điển không có từ này";
            }
        }
        if (text.equals("")) {
            result = "Mời bạn nhập từ";
        }
        model.addAttribute("result", result);
        return "index";
    }

}
