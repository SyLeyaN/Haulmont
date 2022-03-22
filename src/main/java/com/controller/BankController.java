package com.controller;

import com.domain.Bank;
import com.domain.Credit;
import com.domain.UserDAO;
import com.repos.BankRepos;
import com.repos.CreditRepos;
import com.repos.UserDAORepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/banks")
public class BankController {
    @Autowired
    BankRepos bankRepos;

    @Autowired
    UserDAORepos userDAORepos;

    @Autowired
    CreditRepos creditRepos;

    @GetMapping
    public String main(Model model){
        long count = bankRepos.count();
        model.addAttribute("bankSize",count);

        Iterable<Bank> banks = bankRepos.findAll();
        model.addAttribute("banks", banks);
        return "banks";
    }

    @PostMapping("delete")
    public String deleteBank(@RequestParam String name,
                             Model model){
        Bank bank = bankRepos.findByName(name);
        bankRepos.delete(bank);
        model.addAttribute("bankSize", bankRepos.count());
        model.addAttribute("bank", bankRepos.findAll());

        return "redirect:/banks";
    }

    @PostMapping
    public String addBank(@RequestParam String name, Model model){
        Bank bank = bankRepos.findByName(name);
        model.addAttribute("bankSize",bankRepos.count());

        if (name == ""){
            model.addAttribute("messageError","Please, enter bank's name");
            return "banks";
        }

        if (bank!=null){
            model.addAttribute("messageError", "Bank with this name already exists. Try again");
            return "banks";
        }

        bankRepos.save(new Bank(name));
        return "redirect:/banks";
    }

    @GetMapping("{bank}")
    public String bankInfo(@PathVariable Bank bank, Model model){
        Iterable<UserDAO> userDAOS = userDAORepos.findAll();
        int creditSize = bank.getCredits().size();
        int clientSize = bank.getUsers().size();
        model.addAttribute("clientSize", clientSize);
        model.addAttribute("creditSize", creditSize);
        model.addAttribute("credits",bank.getCredits());
        model.addAttribute("clients",bank.getUsers());
        model.addAttribute("bank",bank);
        model.addAttribute("usrs", userDAOS);
        return "bankInfo"; //
    }

    @PostMapping("{bank}/deleteCredit")
    public String deleteCredit(@RequestParam String name,
                               @PathVariable Bank bank,
                               Model model){
        Credit credit = creditRepos.findByName(name);
        bank.getCredits().remove(credit);
        creditRepos.delete(credit);
        model.addAttribute("creditSize", creditRepos.count());
        model.addAttribute("credits", creditRepos.findAll());
        return "redirect:/banks/{bank}";
    }

    @PostMapping("{bank}/addCredit")
    public String addCredit(@RequestParam String name, @RequestParam double limit,
                            @RequestParam double rate,@PathVariable Bank bank, Model model){
        Credit credit = creditRepos.findByName(name);
        model.addAttribute("creditSize",creditRepos.count());
        int clientSize = bank.getUsers().size();
        model.addAttribute("clientSize", clientSize);

        if (name == ""){
            model.addAttribute("messageError","Please, enter credit's name");
            return "bankInfo";
        }

        if (rate == 0){
            model.addAttribute("messageError","Please, enter credit's rate");
            return "bankInfo";
        }
        if (limit == 0){
            model.addAttribute("messageError","Please, enter credit's limit");
            return "bankInfo";
        }

        if (credit!=null){
            model.addAttribute("messageError", "Credit with this name already exists. Try again");
            return "bankInfo";
        }

        Credit credit1 = new Credit(limit,rate,name);
        bank.getCredits().add(credit1);
        creditRepos.save(credit1);
        return "redirect:/banks/{bank}";
    }

}
