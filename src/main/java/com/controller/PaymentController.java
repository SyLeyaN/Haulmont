/*package com.controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaymentController {
    @Autowired

    @GetMapping
    public String main(@AuthenticationPrincipal User user, Model model){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hello").append(user.getFullName()).append("\n You're welcome");
        model.addAttribute("message", stringBuilder);
        return
    }
}
*/