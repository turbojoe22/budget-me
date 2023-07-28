package com.myPersonalFinance.budgetme.controllers;

import com.myPersonalFinance.budgetme.data.UserRepository;
import com.myPersonalFinance.budgetme.models.User;
import com.myPersonalFinance.budgetme.models.dto.LoginFormDTO;
import com.myPersonalFinance.budgetme.models.dto.RegisterFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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

    @GetMapping("/login")
    public String displayLoginForm(Model model) {
        model.addAttribute(new LoginFormDTO());
        model.addAttribute("title", "Log In");
        return "login";
    }

    @PostMapping("/login")
    public String processLoginForm(@ModelAttribute @Valid LoginFormDTO loginFormDTO,
                                   Errors errors, HttpServletRequest request, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Log In");
            return "login";
        }

//        User theUser = userRepository.findByUsername(loginFormDTO.getUsername());

//        if (theUser == null) {
//            errors.rejectValue("username", "user.invalid", "The username does not exist. Please check spelling or register for an account.");
//            model.addAttribute("title", "Log In");
//            return "login";
//        }

//        String password = loginFormDTO.getPassword();
//
//        if (!theUser.isMatchingPassword(password)) {
//            errors.rejectValue("password", "password.invalid", "Invalid password");
//            model.addAttribute("title", "Log In");
//            return "login";
//        }
//
//        setUserInSession(request.getSession(), theUser);
//
//
        return "redirect:";
    }



//    @GetMapping("/register")
//    public String displayRegistrationForm(Model model) {
//        model.addAttribute(new RegisterFormDTO());
//        model.addAttribute("title", "Register");
//
//        return "register";
//    }
    @PostMapping(path="/register", consumes="application/json")
    public void processRegistrationForm( @RequestBody User newUser

//            @ModelAttribute @Valid RegisterFormDTO registerFormDTO,
//                                          Errors errors, HttpServletRequest request,
//                                          Model model
    ) {


//        User existingUser = userRepository.findByUsername(registerFormDTO.getUsername());
        //retrieve user with given username from database


        //compare two submitted passwords. If they do not match, give custom error and return user to form
//        String password = registerFormDTO.getPassword();
//        String verifyPassword = registerFormDTO.getVerifyPassword();

//        if (!password.equals(verifyPassword)) {
//            errors.rejectValue("password", "passwords.mismatch", "Passwords do not match");
//            model.addAttribute("title", "Register");
//            return "user/register";
            //errors.rejectValue takes 3 parameters:
            //1. the field containing the error
            //2. a label representing the error. This allows error messages to be imported from another file. Even if we don't have such a file, this parameter is required.
            //3. A default message to use if no external error message file is available
//        }
        //If all is valid and a user does not exist, create a new user object, store it in the database, and then create a new session for the user
//        User newUser = new User(registerFormDTO.getUsername(), registerFormDTO.getPassword());
        userRepository.save(newUser);
//        setUserInSession(request.getSession(), newUser);
//        return "redirect:"; //redirect to home page

    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login";
    }
}

