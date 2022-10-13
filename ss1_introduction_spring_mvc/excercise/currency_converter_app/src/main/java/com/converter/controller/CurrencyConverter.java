package com.converter.controller;


import com.converter.service.ICurrencyConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class CurrencyConverter {

    @Autowired
    private ICurrencyConverterService currencyConverterService;

    @GetMapping
    public String showList() {
        return "/list";
    }

    @PostMapping("/convertResult")
    public String result(@RequestParam double usd, Model model) {
        double result = currencyConverterService.converter(usd);
        model.addAttribute("result",result);
        return "/list";
    }
}
