package dev.willingapp.willing.controllers;

import dev.willingapp.willing.models.Album;
import dev.willingapp.willing.models.User;
import dev.willingapp.willing.repositories.AlbumRepository;
import dev.willingapp.willing.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProfileController {

    private final UserRepository usersDao;
    private final AlbumRepository albumsDao;

    public ProfileController(UserRepository usersDao, AlbumRepository albumsDao){
        this.usersDao = usersDao;
        this.albumsDao = albumsDao;
    }

//    @GetMapping("/profile")
//    public String getProfile(Model model){
//        return "profile";
//    }

    // view logged in user profile
    @GetMapping("/profile")
    public String showUserProfile(Model model) throws NullPointerException {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Album> albumsList = albumsDao.findAllByOwner(user);
        model.addAttribute("albums", albumsList);
        System.out.println(albumsList);
        model.addAttribute("users", usersDao.findAll());
//        for later, get all users of that album, of same album ID
        model.addAttribute("user", usersDao.getOne(user.getId()));
        System.out.println("User profile_photo: " + user.getProfilePhoto()); // DEBUG
        return "users/profile";
    }

//    @GetMapping("/profile/{id}/items")description
//    public


//    @GetMapping("/profile/edit")
//    public String editUserProfile(Model model) throws NullPointerException {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        model.addAttribute("user", usersDao.getOne(user.getId()));
//        System.out.println("User profile_photo: " + user.getProfilePhoto()); // DEBUG
//        return "/users/profile";
//    }

}
