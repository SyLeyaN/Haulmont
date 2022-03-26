package com.controller;

import com.logic.PaymentMechanism;
import com.domain.*;
import com.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/banks/{bank}/{credit}")
public class PaymentController {
    @Autowired
    BankRepos bankRepos;

    @Autowired
    CreditRepos creditRepos;

    @Autowired
    UserDAORepos userDAORepos;

    @Autowired
    OfferRepos offerRepos;

    @Autowired
    PaymentRepos paymentRepos;

    @GetMapping
    public String main(@PathVariable Bank bank, @PathVariable Credit credit, Model model){

        Offer offer = offerRepos.findByName(credit.getName()+bank.getName());
        if (offer!=null){
            offerRepos.delete(offer);
        }

        model.addAttribute("usrs", userDAORepos.findAll());
        model.addAttribute("credit",credit);
        model.addAttribute("bank",bank);
        model.addAttribute("count",0);
        return "offerInfo";
    }

    @PostMapping
    public String calculation(@PathVariable Bank bank, @PathVariable Credit credit,
                              @RequestParam float sum, Model model){
        double balance = sum;
        double paymentMonth = PaymentMechanism.allSum(credit.getRate()/100,credit.getLimit(),sum);// Полная выплата за месяц
        double paymentAll = PaymentMechanism.all(paymentMonth,credit.getLimit());
        Map<Double,Double> payPerBody = new HashMap<>();
        List<Double> paymentPercent = new ArrayList<>();
        List<Double> paymentBody = new ArrayList<>();
        List<Double> paymentBalance = new ArrayList<>();

        Offer offer = new Offer(credit.getName()+bank.getName()," "," ",paymentAll,bank.getName());

        for (int i = 0;i<credit.getLimit();i++){
            double pP = PaymentMechanism.percent(sum,balance,credit.getRate()/100);
            double pB = PaymentMechanism.body(paymentMonth,pP);

            paymentPercent.add(pP);
            paymentBody.add(pB);
            Payment payment = new Payment(credit.getName()+i,i,
                    paymentMonth,pB,pP,balance);

            balance = PaymentMechanism.balance(balance,pB);
            paymentBalance.add(balance);
            paymentRepos.save(payment);

            offer.getPayments().add(payment);
        }
        offer.setPaymentMonth(paymentMonth);
        offerRepos.save(offer);

        model.addAttribute("balance", paymentBalance);
        model.addAttribute("paymentMonth", paymentMonth);
        model.addAttribute("paymentAll", paymentAll);

        model.addAttribute("paymentPercent", paymentPercent);
        model.addAttribute("paymentBody", paymentBody);
        model.addAttribute("count", 1);
        model.addAttribute("usrs", userDAORepos.findAll());

        return "offerInfo";
    }
    @PostMapping("/saveOffer")
    public String saveOffer(@PathVariable Bank bank, @RequestParam String creditName,@PathVariable Credit credit,
                            @RequestParam String passport,
                            Model model){
        Iterable<Offer> offers  = offerRepos.findAll();
        Offer offer = offerRepos.findByName(creditName+bank.getName());

        offer.setName(passport+" "+creditName);
        offer.setCreditName(creditName);
        offer.setUserPassport(passport);
        for (int i = 0; i< offer.getPayments().size();i++ ){
            offer.getPayments().get(i).setName(offer.getName()+i);
        }

        offerRepos.save(offer);

        UserDAO userDAO = userDAORepos.findByPassport(passport);
        userDAO.getOffers().add(offer);
        userDAO.getBanks().add(bank);
        userDAORepos.save(userDAO);

        Bank bank1 = bank;
        bank1.getUsers().add(userDAO);
        bankRepos.save(bank1);

       return "redirect:/banks/{bank}";
    }

    @PostMapping("/updateCredit")
    public String updateCredit(@RequestParam String creditName, @RequestParam Double creditRate,
                               @RequestParam Double creditLimit, @PathVariable Credit credit,
                               @PathVariable Bank bank, Model model){
        Credit credit1 = creditRepos.findByName(credit.getName());
        Credit credit2 = creditRepos.findByName(creditName);

        model.addAttribute("usrs", userDAORepos.findAll());
        model.addAttribute("credit",credit);
        model.addAttribute("bank",bank);
        model.addAttribute("count",0);

        if (creditName=="" || creditRate==0 || creditLimit==0){
            model.addAttribute("messageError","Fields must be filled");
            return "offerInfo";
        }

        if (creditLimit>500|| creditLimit<0 || creditRate<0||creditRate>100){
            model.addAttribute("messageError","Incorrect values");
            return "offerInfo";
        }

        if (credit2!=null&&credit2.getName()!=credit1.getName()){
            model.addAttribute("messageError", "Credit with this name already exists. Try again");
            return "offerInfo";
        }


        credit1.setName(creditName);
        credit1.setLimit(creditLimit);
        credit1.setRate(creditRate);

        creditRepos.save(credit1);
        return "redirect:/banks/{bank}/{credit}";
    }


}
