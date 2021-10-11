package com.example.songr.controller;


import com.example.songr.model.Album;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class songrController {
    @GetMapping("/hello")
    public String greetings(@RequestParam( defaultValue = "hello world") String greeting,
                            Model model) {
        model.addAttribute("greeting", greeting); // this is passed to the template automatically
        return "hello"; // this represents the greeting of the html template which will be rendered
    }

    public static String capitalize(String words) {
        return words.toUpperCase();
    }
        @GetMapping("/capitalize/{word}")
        public String getCapitalize(@PathVariable String word, Model model) {
            model.addAttribute("word", capitalize(word));
            return "capitalize";
        }

    @ResponseBody
    @GetMapping("/albums")
    public List<Album> getClassInformation() {
        Album album = new Album("yazan","yazan","yazan",12,1000);
        Album album2 = new Album("x","x","yxn",12,1000);
        Album album3 = new Album("yazxxxxxan","yazxxxxan","yazan",12,1000);
        List<Album> albums=new ArrayList<>();
        albums.add(album);
        albums.add(album2);
        albums.add(album3);


        return albums;
    }
}

