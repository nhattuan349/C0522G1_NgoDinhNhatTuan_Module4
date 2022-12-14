package com.dictionary.controller;


import com.dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class Dictionary {

    @Autowired
    private IDictionaryService dictionaryService;


    @GetMapping
    public String showList(){
        return "/list";
    }

    @PostMapping("/resultDictionary")
    public String result(@RequestParam String vocabulary, Model model){
        String result = dictionaryService.search(vocabulary);
        model.addAttribute("result",result);
        return "/list";
    }

}
