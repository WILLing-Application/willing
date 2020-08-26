package dev.willingapp.willing.controllers;

import dev.willingapp.willing.models.User;
import dev.willingapp.willing.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileController {

    private final UserRepository usersDao;

    public ProfileController(UserRepository usersDao){
        this.usersDao = usersDao;
    }

    // view logged in user profile
    @GetMapping("/profile")
    public String showUserProfile(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", usersDao.getOne(user.getId()));
        return "users/profile";
    }

    @GetMapping("/profile/edit")
    public String editUserProfile(Model model) throws NullPointerException {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", usersDao.getOne(user.getId()));
        return "users/edit";
    }

    @PostMapping("/profile/edit")
    public String editUserDetail(@RequestParam(name="username") String username,
                                 @RequestParam(name="password") String password,
                                 @RequestParam(name="email") String email,
                                 @RequestParam(name="phone") String phone, Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", usersDao.getOne(user.getId()));
        // set attributes from form
        return "users/edit";

    }


}
