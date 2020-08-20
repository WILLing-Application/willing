package dev.willingapp.willing.controllers;

import com.sun.xml.bind.v2.TODO;
import dev.willingapp.willing.models.Album;
import dev.willingapp.willing.models.User;
import dev.willingapp.willing.repositories.AlbumRepository;
import dev.willingapp.willing.repositories.UserRepository;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
        return "/albums/create";
    }

//    POSTING NEWLY CREATED FORM
    @PostMapping("/albums/create")
    public String createAlbum(@ModelAttribute Album album){
        User user = usersDao.getOne(1L);
        albumsDao.save(album);
        return"redirect:/albums";
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
