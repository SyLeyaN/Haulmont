/*package controller;

import domain.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import repos.BankRepos;

@Controller
public class BankController {
    @Autowired
    BankRepos bankRepos;

    @GetMapping("/bank")
    public String main(Model model){
        model.addAttribute("banks", bankRepos.findAll());
        return "bank";
    }

    @GetMapping("/bank/{bank}")
    public String bInfo(@PathVariable Bank bank, Model model){
        model.addAttribute("bank",bank);
        return "offers";
    }


}
*/