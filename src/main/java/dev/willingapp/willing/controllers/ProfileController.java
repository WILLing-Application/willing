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
        model.addAttribute("user", usersDao.getOne(myUser.getId()));
        return "users/profile";
    }

    // EDIT USER PROFILE (FORM)
    @GetMapping("/profile/{id}/edit")
    public String editUserProfile(@PathVariable long id, Model model) {
//        User myUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", usersDao.getOne(id));
        return "users/edit";
    }

    // EDIT/SAVE USER PROFILE
    @PostMapping("/profile/{id}/edit")
    public String saveUserProfile(@RequestParam(name="edit-user") long id,
                                  @RequestParam(name="firstName") String firstName,
                                  @RequestParam(name="lastName") String lastName,
                                  @RequestParam(name="address1") String address1,
                                  @RequestParam(name="address2") String address2,
                                  @RequestParam(name="city") String city,
                                  @RequestParam(name="state") String state,
                                  @RequestParam(name="zip") String zip,
                                  @RequestParam(name="phone") String phone,
                                  Model model) {
        User myUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = usersDao.getOne(myUser.getId());
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAddress1(address1);
        user.setAddress2(address2);
        user.setCity(city);
        user.setState(state);
        user.setZip(zip);
        user.setPhone(phone);
        usersDao.save(user);
        return "redirect:/profile";
    }

    @GetMapping("/profile/delete")
    public String deleteProfile(Model model) {
        User myUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", usersDao.getOne(myUser.getId()));
        System.out.println("value of myUser id: " + myUser.getId()); // DEBUG
        return "users/delete";
    }

    // no errors, but doesn't remove user from the database
    @PostMapping("/profile/delete")
    public String deleteProfileById(@RequestParam(name="delete-user") long id) {
        usersDao.deleteById(id);
        return "redirect:/";
    }
}
