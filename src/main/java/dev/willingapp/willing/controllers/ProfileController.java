package dev.willingapp.willing.controllers;

import dev.willingapp.willing.models.User;
import dev.willingapp.willing.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfileController {

    private final UserRepository usersDao;

    public ProfileController(UserRepository usersDao){
        this.usersDao = usersDao;
    }

    // VIEW USER PROFILE
    @GetMapping("/profile")
    public String showUserProfile(Model model) {
        User myUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        model.addAttribute("user", usersDao.getOne(myUser.getId()));
        model.addAttribute("user", myUser);
        return "users/profile";
    }

    // EDIT USER PROFILE (FORM)
    @GetMapping("/profile/{id}/edit")
    public String editUserProfile(@PathVariable long id, Model model) {
        User myUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", usersDao.getOne(myUser.getId()));

//        boolean isDifferent = false;

        return "users/edit";
    }

        // snippet from AlbumController & add-guest.html
//        if (usersDao.findByEmail(email) != null) {
//            user = usersDao.findByEmail(email);
//            isNotUnique = false;
//            model.addAttribute("user", user);
//            model.addAttribute("isRegistered", isRegistered);
//        } else if (usersDao.findByFirstName(firstName) != null && usersDao.findByLastName(lastName) != null) {
//            user = usersDao.findByFirstName(firstName);
//            isRegistered = true;
//            model.addAttribute("user", user);
//            model.addAttribute("isRegistered", isRegistered);
//        } else {
//            isRegistered = false;
//            model.addAttribute("userNotFound", userNotFound);
//            model.addAttribute("isRegistered", isRegistered);
//        }


    // snippet from user controller
//    String hash = passwordEncoder.encode(user.getPassword());
//        user.setPassword(hash);
//        usersDao.save(user);


    // EDIT/SAVE USER PROFILE
    @PostMapping("/profile/{id}/edit")
    public String saveUserProfile(@RequestParam(name="username") String username,
                                 @RequestParam(name="password") String password,
                                 @RequestParam(name="email") String email,
                                 @RequestParam(name="phone") String phone, Model model) {
        User myUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", usersDao.getOne(myUser.getId()));
        // check and set all the attributes sent with the form
        return "users/edit";

    }

    @GetMapping("/profile/delete")
    public String deleteProfileById(Model model) {
        User myUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", usersDao.getOne(myUser.getId()));
        System.out.println("value of myUser id: " + myUser.getId()); // DEBUG
        return "users/delete";
    }

    @PostMapping("/profile/delete")
    public String deleteProfile(@RequestParam(name="delete-user") long id) {
        usersDao.deleteById(id);
        return "redirect:/";
    }

}
