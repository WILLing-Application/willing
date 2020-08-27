package dev.willingapp.willing.controllers;


import dev.willingapp.willing.models.Album;
import dev.willingapp.willing.models.Interest;
import dev.willingapp.willing.models.User;
import dev.willingapp.willing.models.Item;
import dev.willingapp.willing.repositories.AlbumRepository;
import dev.willingapp.willing.repositories.InterestRepository;
import dev.willingapp.willing.repositories.ItemRepository;
import dev.willingapp.willing.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ViewController {

    private final AlbumRepository albumsDao;
    private final UserRepository usersDao;
    private final ItemRepository itemsDao;
    private final InterestRepository interestDao;

    public ViewController(AlbumRepository albumsDao, UserRepository usersDao, ItemRepository itemsDao, InterestRepository interestDao){
        this.albumsDao = albumsDao;
        this.usersDao = usersDao;
        this.itemsDao = itemsDao;
        this.interestDao = interestDao;
    }

    @GetMapping("/view")
    public String showView(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Album> albumsList = albumsDao.findAllByOwner(user);
        List<User> usersList = usersDao.findAll();
//        Item item = interestDao.findBy
//        List<Item> itemsList = itemsDao.
//        List<User> interested = usersDao.findAllByItem(item);
//        List<Interest> interestedInItem = interestDao.findInterestByItemId();

        List<Interest> allInterestedItems = interestDao.findAll();
//        List<Interest> interestByItem = interestDao.findInterestByItemId(item);
                    //this is throwing me off
                    //interest table only has userId
                    //would then need to translate userId to username or firstName...

        //...model.addAttribute("itemInterests", interestByItem);???? or something
        model.addAttribute("interests", allInterestedItems);
        model.addAttribute("users", usersDao.findAll());
        model.addAttribute("user", usersDao.getOne(user.getId()));
        model.addAttribute("albums", albumsList);
//        model.addAttribute("interest", interested);
        System.out.println(albumsList);
//        List<Item> itemsList = itemsDao.findById(id);
//        Item item = itemsDao.getOne(itemsList);
//        Item item = itemsDao.getOne(id);
//        model.addAttribute("item", itemsDao.getOne(id));
//        List<Interest> interestList = interestDao.findInterestByItem(id);
//        model.addAttribute("interest", interestList);
//        for later, get all users of that item, of same item ID
        return "view";
    }



}
