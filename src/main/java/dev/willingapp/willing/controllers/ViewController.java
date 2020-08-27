package dev.willingapp.willing.controllers;


import dev.willingapp.willing.models.Album;
import dev.willingapp.willing.models.User;
import dev.willingapp.willing.models.Item;
import dev.willingapp.willing.repositories.AlbumRepository;
import dev.willingapp.willing.repositories.ItemRepository;
import dev.willingapp.willing.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ViewController {

    private final AlbumRepository albumsDao;
    private final UserRepository usersDao;
    private final ItemRepository itemsDao;

    public ViewController(AlbumRepository albumsDao, UserRepository usersDao, ItemRepository itemsDao){
        this.albumsDao = albumsDao;
        this.usersDao = usersDao;
        this.itemsDao = itemsDao;
    }

    @GetMapping("/view")
    public String showView(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Album> albumsList = albumsDao.findAllByOwner(user);
        List<Item> itemsList = itemsDao.findAll();
        model.addAttribute("albums", albumsList);
        System.out.println(albumsList);
        model.addAttribute("users", usersDao.findAll());
        model.addAttribute("user", usersDao.getOne(user.getId()));
//        for later, get all users of that album, of same album ID
        return "view";
    }



}
