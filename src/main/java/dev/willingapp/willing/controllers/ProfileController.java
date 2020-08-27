package dev.willingapp.willing.controllers;

import dev.willingapp.willing.models.Image;
import dev.willingapp.willing.models.User;
import dev.willingapp.willing.repositories.ImageRepository;
import dev.willingapp.willing.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfileController {

    private final UserRepository usersDao;
    private final ImageRepository imagesDao;

    public ProfileController(UserRepository usersDao, ImageRepository imagesDao){
        this.usersDao = usersDao;
        this.imagesDao = imagesDao;
    }

    // VIEW USER PROFILE
    @GetMapping("/profile")
    public String showUserProfile(Model model) {
        User myUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = usersDao.getOne(myUser.getId());
        if (!user.getProfilePhoto().isEmpty()) {
            model.addAttribute("hasPhoto", true);
        } else {
            model.addAttribute("noPhoto", true);
            model.addAttribute("placeholder", "https://cdn.filestackcontent.com/TWDYVD0lTM2pav6BAs6u");
        }
        model.addAttribute("user", user);
        return "users/profile";
    }

    // EDIT USER PROFILE (FORM)
    @GetMapping("/profile/{id}/edit")
    public String editUserProfile(@PathVariable long id, Model model) {
//        User myUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = usersDao.getOne(id);
        if (!user.getProfilePhoto().isEmpty()) {
            model.addAttribute("hasPhoto", true);
        } else {
            model.addAttribute("noPhoto", true);
            model.addAttribute("placeholder", "https://cdn.filestackcontent.com/TWDYVD0lTM2pav6BAs6u");
        }
        model.addAttribute("user", user);
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
                                  @RequestParam(name = "images") String image,
                                  @RequestParam(name = "file-type") String fileType,
                                  Model model) {
        User myUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = usersDao.getOne(myUser.getId());
        Image newImage = new Image();
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAddress1(address1);
        user.setAddress2(address2);
        user.setCity(city);
        user.setState(state);
        user.setZip(zip);
        user.setPhone(phone);
        user.setProfilePhoto(image);
//        newImage.setFilename(image);
//        newImage.setFileType(fileType);
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
