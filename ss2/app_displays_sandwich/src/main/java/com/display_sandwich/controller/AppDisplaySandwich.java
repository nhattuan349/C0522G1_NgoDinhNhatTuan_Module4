package com.display_sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("")
public class AppDisplaySandwich {

    @GetMapping
    public String showList(){
        return "/list";
    }

    @GetMapping("/result")
    public String showList1(@RequestParam(value = "commit1" ,defaultValue = "bạn click vào ô chọn ") String[] commit, ModelMap modelMap){
        modelMap.addAttribute("commit",commit);
        return "/list";
    }
}
