package org.softserveinc.controller;

import org.softserveinc.domain.User;
import org.softserveinc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Controller
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String addUser(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            return "signup";
        }
        model.addAttribute(user);

        userService.saveUserIntoDB(user);
        
        return "userProfile";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String getSingUpPage(Model model) {
        model.addAttribute("user", new User());
        return "signup";

    }
}
