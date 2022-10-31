package com.complete_the_shopping_cart.controller;

import com.complete_the_shopping_cart.dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/cart")
public class CartController {
    @GetMapping
    public String showCart(@SessionAttribute(value = "cart", required = false) CartDto cart, Model model) {
        model.addAttribute("cart", cart);
        return "/cart/list";
    }
}