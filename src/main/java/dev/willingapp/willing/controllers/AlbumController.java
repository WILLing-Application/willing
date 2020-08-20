package dev.willingapp.willing.controllers;

import dev.willingapp.willing.models.Album;
import dev.willingapp.willing.repositories.AlbumRepository;
import dev.willingapp.willing.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AlbumController {

    private final AlbumRepository albumsDao;
    private final UserRepository usersDao;

    public AlbumController(AlbumRepository albumsDao, UserRepository usersDao) {
        this.albumsDao = albumsDao;
        this.usersDao = usersDao;
    }

    @GetMapping("albums")
//    @ResponseBody
    public String returnLandingMessage(){
        //return home.html
        return "albums";
    }

    @GetMapping("/albums/{id}")
    public String show(@PathVariable long id, Model model){
        Album grabbedAlbum = albumsDao.getOne(id);
        model.addAttribute("album", grabbedAlbum);
        return "albums/show";
    }
}
