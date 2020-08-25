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
    public String showUserProfile(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", usersDao.getOne(user.getId()));
        if (user.getProfilePhoto() == null) {
            System.out.println("profile photo is null");
            user.setProfilePhoto("/templates/photos/placeholder.jpg");
        }
        return "profile";
    }

}
