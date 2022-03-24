package com.controller;

import com.domain.Bank;
import com.domain.Credit;
import com.domain.Offer;
import com.domain.UserDAO;
import com.repos.BankRepos;
import com.repos.CreditRepos;
import com.repos.OfferRepos;
import com.repos.UserDAORepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class UserDAOController {
    @Autowired
    UserDAORepos userDAORepos;

    @Autowired
    CreditRepos creditRepos;

    @Autowired
    BankRepos bankRepos;

    @Autowired
    OfferRepos offerRepos;

    @GetMapping("/")
    public String main(Model model){
        long count = userDAORepos.count();
        model.addAttribute("userSize",count);

        Iterable<UserDAO> userDAOS = userDAORepos.findAll();
        model.addAttribute("usrs", userDAOS);
        return "users";
    }

    @GetMapping("users/{user}")
    public String userInfo(@PathVariable UserDAO user, Model model){
        model.addAttribute("usr", user);
        model.addAttribute("offers",user.getOffers());
        model.addAttribute("offerSize",user.getOffers().size());

        List<Credit> credits = new ArrayList<>();
        Credit credit ;

        for (Offer offer : user.getOffers()){
            credit = creditRepos.findByName(offer.getCreditName());
            credits.add(credit);
        }

        model.addAttribute("credits",credits);

        return "userInfo";
    }

    @PostMapping("users/{user}/updateUser")
    public String updateUser(@RequestParam String fname, @RequestParam String mname,
                             @RequestParam String lname, @RequestParam String telephone,
                             @RequestParam String email, @PathVariable UserDAO user, Model model){
        model.addAttribute("usr", user);
        model.addAttribute("offers",user.getOffers());
        model.addAttribute("offerSize",user.getOffers().size());

        List<Credit> credits = new ArrayList<>();
        Credit credit ;

        for (Offer offer : user.getOffers()){
            credit = creditRepos.findByName(offer.getCreditName());
            credits.add(credit);
        }

        model.addAttribute("credits",credits);


        if (fname=="" || lname=="" || mname==""){
            model.addAttribute("messageError","Name must be filled");
            return "userInfo";
        }

        if (telephone == ""){
            model.addAttribute("messageError","Please, enter your telephone");
            return "userInfo";
        }

        if (email == ""){
            model.addAttribute("messageError","Please, enter your email");
            return "userInfo";
        }

        UserDAO userDAO = userDAORepos.findByPassport(user.getPassport());
        userDAO.update(fname,mname,lname,telephone,email);
        userDAORepos.save(userDAO);

        return "redirect:/users/{user}";
    }

    @PostMapping("delete")
    public String deleteUser(@RequestParam String passport,
                             Model model){
        UserDAO userDAO = userDAORepos.findByPassport(passport);

        for (Bank bank : bankRepos.findAll()){
            for (UserDAO userDAO1 : bank.getUsers()){
                if (userDAO1.getPassport() == passport){
                    bank.getUsers().remove(userDAO1);
                }
            }
        }

        for (Offer offer : offerRepos.findAll()){
            if (offer.getUserPassport() == passport){
                offerRepos.delete(offer);
            }
        }

        userDAORepos.delete(userDAO);
        model.addAttribute("userSize", userDAORepos.count());
        model.addAttribute("usrs", userDAORepos.findAll());

        return "redirect:/";
    }

    @PostMapping
    public String addUserDAO(@RequestParam String fname,
                             @RequestParam String sname,
                             @RequestParam String lname,
                             @RequestParam String telephone,
                             @RequestParam String email,
                             @RequestParam String passport, Model model){
        UserDAO userDAO = userDAORepos.findByPassport(passport);
        model.addAttribute("userSize",userDAORepos.count());
        if (fname == "" || sname == "" || lname == "") {
            model.addAttribute("messageError", "Please, enter full name");
            return "users";
        }

        if (passport==""){
            model.addAttribute("messageError", "Please, enter your passport");
            return "users";
        }

        if (telephone == ""){
            model.addAttribute("messageError","Please, enter your telephone");
            return "users";
        }

        if (email == ""){
            model.addAttribute("messageError","Please, enter your email");
            return "users";
        }

        if (userDAO!=null){
            model.addAttribute("messageError", "User with this passport already exists. Try again");
            return "users";
        }

        userDAORepos.save(new UserDAO(fname,sname,lname,telephone,email,passport));
        return "redirect:/";
    }
}
