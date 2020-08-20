package dev.willingapp.willing.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlbumController {


    @GetMapping("albums")
//    @ResponseBody
    public String returnLandingMessage(){
        //return home.html
        return "albums";
    }
}
