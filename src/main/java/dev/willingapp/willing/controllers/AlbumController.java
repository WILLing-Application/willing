package dev.willingapp.willing.controllers;

import com.sun.xml.bind.v2.TODO;
import dev.willingapp.willing.models.Album;
import dev.willingapp.willing.models.User;
import dev.willingapp.willing.repositories.AlbumRepository;
import dev.willingapp.willing.repositories.UserRepository;
import org.dom4j.rule.Mode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

//@Controller
//public class AlbumController {
//    private final AlbumRepository albumsDao;
//    private final UserRepository usersDao;
//
//    public AlbumController(AlbumRepository albumsDao, UserRepository usersDao) {
//        this.albumsDao = albumsDao;
//        this.usersDao = usersDao;
//    }
//
//    @GetMapping("/albums")
//    public String redirect() {
//        return "redirect:/albums";
//    }
//
//    // JSON - one post
//    @GetMapping("/albums/json/{id}")
//    @ResponseBody
//    public String getAlbum(@PathVariable long id){
//        return albumsDao.getOne(id).toString();
//    }
//
//    // JSON - list of posts
//    @GetMapping("/albums/json")
//    @ResponseBody
//    public List<Album> getAlbums() {
//        return albumsDao.findAllByOrderByIdDesc();
//    }
//
//    // The rest are Thymeleaf pages
//
//    @GetMapping("/albums")
//    public String getAlbums(Model model) {
////        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
////        System.out.println(loggedInUser.getUsername()); // print logged in user
//        model.addAttribute("albums", albumsDao.findAllByOrderByIdDesc());
//        return "albums/albums";
//    }
//
//    @GetMapping("albums/{id}")
//    public String getOneAlbum(@PathVariable long id, Model model){
//        model.addAttribute("oneAlbum", albumsDao.getOne(id));
//        return "albums/albums";
//    }
//
//    @GetMapping("/albums/{id}/edit")
//    public String editAlbumById(@PathVariable long id, Model model) {
//        model.addAttribute("album", albumsDao.getOne(id));
//        return "albums/edit";
//    }
//
//    @PostMapping("/albums/edit")
//    public String editAlbum(@RequestParam(name="id") long id,
//                           @RequestParam(name="title") String title,
//                           @RequestParam(name="description") String description, Model model) {
//        // TODO: validate logged in user can edit the post
//        Album album = albumsDao.getOne(id);
//        album.setTitle(title);
//        album.setDescription(description);
//        albumsDao.save(album);
//        return "redirect:/albums/album";
//    }
//
//    @GetMapping("/albums/{id}/delete")
//    public String deletePostById(@PathVariable long id, Model model) {
//        model.addAttribute("post", albumsDao.getOne(id));
//        return "albums/delete";
//    }
//
//    @PostMapping("/albums/delete")
//    public String deleteAlbum(@RequestParam(name="id") long id) {
//        // TODO: validate logged in user can delete the post
//        albumsDao.deleteById(id);
//        return "redirect:/albums/view";
//    }
//
//    @GetMapping("/albums/create")
//    public String createAlbumForm(Model model){
//        model.addAttribute("album", new Album());
//        return "albums/create";
//    }
//
//    @PostMapping("/albums/create")
//    public String createAlbum(@ModelAttribute Album album) {
//        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User user = usersDao.getOne(loggedInUser.getId());
//        album.setOwner(user);
//        albumsDao.save(album);
//        return "redirect:/albums/album";
//    }
//}
@Controller
public class AlbumController {
    private final AlbumRepository albumsDao;
    private final UserRepository usersDao;

    public AlbumController(AlbumRepository albumsDao, UserRepository usersDao) {
        this.albumsDao = albumsDao;
        this.usersDao = usersDao;
    }

    @GetMapping("/albums")
//    @ResponseBody
    public String index(Model model){
        model.addAttribute("albums", albumsDao.findAll());
        //return albums index;
        return "albums/albums";
    }

    @GetMapping("/albums/{id}")
    public String show(@PathVariable long id, Model model){
        Album grabbedAlbum = albumsDao.getOne(id);
        model.addAttribute("album", grabbedAlbum);
        return "albums";
//        TODO: RETURN IS SUBJECT TO CHANGE
    }

//    RETURNS CREATE FORM
//    TODO: MAKE CREATE ALBUM INDEX
    @GetMapping("/albums/create")
    public String showAlbumForm(Model model) {
        model.addAttribute("album", new Album());
        return "albums/create";
    }

//    POSTING NEWLY CREATED FORM
    @PostMapping("/albums/create")
    public String createAlbum(@ModelAttribute Album album){

        LocalDateTime currentDate = LocalDateTime.now();
//        FORMATTING TIME
        DateTimeFormatter currentDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
//        CONVERTING IT TO A STRING
        String dateString = currentDate.format(currentDateFormat);
        User user = usersDao.getOne(1L);
        album.setOwner(user);
        album.setDeadline(dateString);
        albumsDao.save(album);
        return"redirect:/albums/";
    }

//    TODO: CREATE EDIT INDEX
    @GetMapping("albums/{id}/edit")
    public String editAlbum(@PathVariable long id, Model model){
        model.addAttribute("album", albumsDao.getOne(id));
        return "albums/edit";
    }

    @PostMapping("/albums/{id}/edit")
    public String editAlbums(@PathVariable long id, @ModelAttribute Album album){
        User user = usersDao.getOne(1L);
        album.setOwner(user);
        albumsDao.save(album);
        return "redirect:/albums";
    }
    @PostMapping("/albums/{id}/delete")
    public String deleteAlbum(@PathVariable long id) {
        return "redirect:/albums";
    }
}
