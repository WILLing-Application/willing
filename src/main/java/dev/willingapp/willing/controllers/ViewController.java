package dev.willingapp.willing.controllers;


import dev.willingapp.willing.models.*;
import dev.willingapp.willing.repositories.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ViewController {

    private final AlbumRepository albumsDao;
    private final UserRepository usersDao;
    private final ItemRepository itemsDao;
    private final InterestRepository interestDao;
    private final ImageRepository imagesDao;

    public ViewController(AlbumRepository albumsDao, UserRepository usersDao, ItemRepository itemsDao, InterestRepository interestDao, ImageRepository imagesDao){
        this.albumsDao = albumsDao;
        this.usersDao = usersDao;
        this.itemsDao = itemsDao;
        this.interestDao = interestDao;
        this.imagesDao = imagesDao;
    }

    @GetMapping("/view")
    public String showView(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        List<Album> albumsList = albumsDao.findAllByOwner(user);
        List<User> usersList = usersDao.findAll();
        List<Interest> allInterestedItems = interestDao.findAll();

        //
//        Item item = itemsDao.getOne(id);
//        List<Image> images = item.getImages();
//        List<Image> photos = new ArrayList<>();
        //

        //from getmapping album/id
//        User thisUser = usersDao.getOne(user.getId());
//        Album grabbedAlbum = albumsDao.getOne(id);
//        boolean isOwner = false;
//        List<Image> images = new ArrayList<>();
//        Image image = new Image();
//        image.setFilename("https://cdn.filestackcontent.com/ixlBgvOrR7OiTMVdrX4F");
//        image.setFileType("image/jpeg");
//        images.add(image);
//
//        List<Image> photos = new ArrayList<>();
//        List<Image> videos = new ArrayList<>();
//
//
//        for (Image x : images) {
//            if (x.getFileType().equalsIgnoreCase("video/mp4")) {
//                videos.add(x);
//            } else if (x.getFileType().equalsIgnoreCase("image/jpeg")) {
//                photos.add(x);
//            }
//        }



//        for (Item x : grabbedAlbum.getItems()) {
//            if (x.getImages().isEmpty()) {
//                x.setImages(images);
//            }
//        }
//        if (grabbedAlbum.getOwner().getId() == thisUser.getId()) {
//            isOwner = true;
//            model.addAttribute("isOwner", isOwner);
//        }


        //

        model.addAttribute("interests", allInterestedItems);
        model.addAttribute("users", usersDao.findAll());
        model.addAttribute("user", usersDao.getOne(user.getId()));
        model.addAttribute("albums", albumsList);

        //
//        model.addAttribute("album", grabbedAlbum);
//        model.addAttribute("items", grabbedAlbum.getItems());
        //


        //
//        model.addAttribute("item", item);
//        model.addAttribute("photos", photos);
        //


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
