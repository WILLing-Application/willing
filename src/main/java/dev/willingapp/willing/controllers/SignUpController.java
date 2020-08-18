package dev.willingapp.willing.controllers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class SignUpController {
//    private UserRepository users;
//    private PasswordEncoder passwordEncoder;
//
//    public SignUpController(UserRepository users, PasswordEncoder passwordEncoder) {
//        this.users = users;
//        this.passwordEncoder = passwordEncoder;
//    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
//        model.addAttribute("user", new User());
        return "users/sign-up";
    }

//    @PostMapping("/sign-up")
//    public String saveUser(@ModelAttribute User user){
//        String hash = passwordEncoder.encode(user.getPassword());
//        user.setPassword(hash);
//        users.save(user);
//        return "redirect:/login";
//    }
}
