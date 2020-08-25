package dev.willingapp.willing.controllers;

import dev.willingapp.willing.models.User;
import dev.willingapp.willing.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    private final UserRepository usersDao;

    public ProfileController(UserRepository usersDao){
        this.usersDao = usersDao;
    }

//    @GetMapping("/profile")
//    public String getProfile(Model model){
//        return "profile";
//    }

    // view logged in user profile
    @GetMapping("/profile")
    public String showUserProfile(Model model) throws NullPointerException {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", usersDao.getOne(user.getId()));
        System.out.println("User profile_photo: " + user.getProfilePhoto()); // DEBUG
        return "/users/profile";
    }

    @GetMapping("/profile/edit")
    public String editUserProfile(Model model) throws NullPointerException {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", usersDao.getOne(user.getId()));
        System.out.println("User profile_photo: " + user.getProfilePhoto()); // DEBUG
        return "/users/profile";
    }

}
