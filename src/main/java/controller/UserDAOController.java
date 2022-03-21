package controller;

import domain.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import repos.UserDAORepos;

@Controller
public class UserDAOController {
    @Autowired
    UserDAORepos userDAORepos;

    @GetMapping("/main")
    public String mm(){
        return "main";
    }

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("userSize",userDAORepos.count());
        model.addAttribute("usrs", userDAORepos.findAll());
        return "users";
    }

    @GetMapping("/{user}")
    public String offers(@PathVariable UserDAO user, Model model){
        model.addAttribute("user", user);
        return "user";
    }

    @PostMapping("delete")
    public String deleteUser(@RequestParam String passport,
                             Model model){
        UserDAO userDAO = userDAORepos.findByPassport(passport);
        userDAORepos.delete(userDAO);
//        model.addAttribute("userSize", userDAORepos.count());
//        model.addAttribute("usrs", userDAORepos.findAll());
//
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
        if (fname == "" || sname == "" || lname == "") {
            model.addAttribute("messageError", "Please, enter full name");
            return "users";
        }

        if (passport==""){
            model.addAttribute("messageError", "Please, enter your passport");
            return "users";
        }

        if (userDAO!=null){
            model.addAttribute("messageError", "User with this passport already exists. Try again");
            return "users";
        }

        userDAORepos.save(new UserDAO(fname,sname,lname,telephone,email,passport));
        return "redirect:/users";
    }
}
