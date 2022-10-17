package com.email_program.controller;

import com.email_program.model.Email;
import com.email_program.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmailController {

    @Autowired
    private IEmailService emailService;

    @GetMapping("/settings")
    public String showList(Model model) {
        model.addAttribute("languageList", emailService.language());
        model.addAttribute("pageSizeList", emailService.pageSize());
        model.addAttribute("spamsFilterList", emailService.spamsFilter());
        model.addAttribute("email", new Email());
        return "list";
    }

    @PostMapping("/emailUpdate")
    public String ShowUpdate(@ModelAttribute("save") Email email, Model model) {
        model.addAttribute("message", "Thêm mới thành công");
        return "create";
    }

//    @GetMapping("/list2")
//    public String showList2(Model model) {
//        model.addAttribute("list2Ok",emailService.findAll());
//        return "list2";
//    }
}
