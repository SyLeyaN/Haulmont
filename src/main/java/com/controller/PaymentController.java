package com.controller;

import com.console.PaymentMechanism;
import com.domain.Bank;
import com.domain.Credit;
import com.repos.BankRepos;
import com.repos.CreditRepos;
import com.repos.UserDAORepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/banks/{bank}/{credit}")
public class PaymentController {
    @Autowired
    BankRepos bankRepos;

    @Autowired
    CreditRepos creditRepos;

    @Autowired
    UserDAORepos userDAORepos;

    @GetMapping
    public String main(@PathVariable Bank bank, @PathVariable Credit credit, Model model){
        model.addAttribute("usrs", userDAORepos.findAll());
        model.addAttribute("credit",credit);
        model.addAttribute("bank",bank);
        return "offerInfo";
    }

    @PostMapping
    public String calculation(@PathVariable Bank bank, @PathVariable Credit credit,
                              @RequestParam float sum, Model model){
        double balance = sum;
        double paymentMonth = PaymentMechanism.allSum(credit.getRate(),credit.getLimit(),sum);// Полная выплата за месяц
        double paymentAll = PaymentMechanism.all(paymentMonth,credit.getLimit());
        List<Double> paymentPercent = new ArrayList<>();
        List<Double> paymentBody = new ArrayList<>();

        for (int i = 0;i<credit.getLimit();i++){
            double pP = PaymentMechanism.percent(sum,balance,credit.getRate());
            double pB = PaymentMechanism.body(paymentMonth,pP);
            paymentPercent.add(pP);
            paymentBody.add(pB);
            balance = PaymentMechanism.balance(balance,pB);
        }

        model.addAttribute("balance", balance);
        model.addAttribute("paymentMonth", paymentMonth);
        model.addAttribute("paymentAll", paymentAll);
        model.addAttribute("paymentPercent", paymentPercent);
        model.addAttribute("paymentBody", paymentBody);

        return "offerInfo";
    }


}
