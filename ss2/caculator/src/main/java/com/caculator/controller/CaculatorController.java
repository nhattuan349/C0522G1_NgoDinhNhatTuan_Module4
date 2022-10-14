package com.caculator.controller;

import com.caculator.service.ICaculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class CaculatorController {
    @Autowired
        ICaculatorService caculatorService;
    @GetMapping
    public String showList(){
        return "/list";
    }

    @GetMapping("/result")
    public String result(
            @RequestParam (value = "firstOperand") double firstOperand,
            @RequestParam (value = "secondOperand") double secondOperand,
            @RequestParam (value = "operator") String operator,
            ModelMap modelMap) {
        modelMap.addAttribute("firstOperand", firstOperand);
        modelMap.addAttribute("secondOperand", secondOperand);
        modelMap.addAttribute("operator", operator);
        double result = caculatorService.calculator(firstOperand, secondOperand, operator);
        modelMap.addAttribute("result", result);
        return "/list";
    }

}
