package com.myPersonalFinance.budgetme.controllers;

import com.myPersonalFinance.budgetme.data.UserRepository;
import com.myPersonalFinance.budgetme.models.User;
import com.myPersonalFinance.budgetme.models.dto.LoginFormDTO;
import com.myPersonalFinance.budgetme.models.dto.RegisterFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    @Autowired
    private UserRepository userRepository;

    private static final String userSessionKey = "user";

    public User getUserFromSession(HttpSession session) {

        Integer userId = (Integer) session.getAttribute(userSessionKey);

        if (userId == null) {
            return null;
        }

        Optional<User> user = userRepository.findById(userId);

        return user.orElse(null);
    }

    private static void setUserInSession(HttpSession session, User user) {

        session.setAttribute(userSessionKey, user.getId());
    }

    @GetMapping(path="/login", consumes="application/json")
    public String displayLoginForm(@RequestBody User user) {

        return "login";
    }

    @PostMapping(path="/login", consumes="application/json")
    public String processLoginForm(@RequestBody User user,
                                   HttpServletRequest request) {


        userRepository.findByUsername(user.getUsername());


        setUserInSession(request.getSession(), user);

        return "redirect:";
    }



//    @GetMapping(path="/register", consumes="application/json")
//    public String displayRegistrationForm(Model model) {
//        model.addAttribute(new RegisterFormDTO());
//        model.addAttribute("title", "Register");
//
//        return "register";
//    }
    @PostMapping(path="/register", consumes="application/json")
    public void processRegistrationForm(@RequestBody User user) {



        //retrieve user with given username from database

//
        userRepository.findByUsername(user.getUsername());




        //If all is valid and a user does not exist, create a new user object, store it in the database, and then create a new session for the user
//        new User(registerFormDTO.getUsername(), registerFormDTO.getPassword());
        userRepository.save(user);
//        setUserInSession(request.getSession(), newUser);
//        return "redirect:";
        //redirect to home page

    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login";
    }
}

