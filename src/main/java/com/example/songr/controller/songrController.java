package com.example.songr.controller;


import com.example.songr.model.Album;
import com.example.songr.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class songrController {

    @Autowired
    private AlbumRepository albumRepository;


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


//    @GetMapping("/albums")
//    public String getClassInformation(Model model) {
//        Album album = new Album("My life ","yazan","https://pica.zhimg.com/f0dc56584_l.jpg?source=172ae18b",11,1000);
//        Album album2 = new Album("His life ","malik","https://pica.zhimg.com/f0dc56584_l.jpg?source=172ae18b",12,2000);
//        Album album3 = new Album("There life's","mohammd","https://pica.zhimg.com/f0dc56584_l.jpg?source=172ae18b",13,3000);
//        List<Album> albums=new ArrayList<>();
//        albums.add(album);
//        albums.add(album2);
//        albums.add(album3);
//         model.addAttribute("Album",albums);
//
//        return "albums";
//    }
@GetMapping("/albums")
public String getAlbums(Model model, Model model2) {
    Album album = new Album("My life ","yazan","https://pica.zhimg.com/f0dc56584_l.jpg?source=172ae18b",11,1000);
    Album album2 = new Album("His life ","malik","https://pica.zhimg.com/f0dc56584_l.jpg?source=172ae18b",12,2000);
    Album album3 = new Album("There life's","mohammd","https://avatarfiles.alphacoders.com/737/73738.png",13,3000);
    List<Album> albums=new ArrayList<>();
    albums.add(album);
    albums.add(album2);
    albums.add(album3);
    model.addAttribute("Album", albumRepository.findAll());
    model2.addAttribute("album",albums);
    return "albums";
}

    @PostMapping("/albums")
    public RedirectView createAlbum(@ModelAttribute Album album) { // modelattribute when working with fomr data
        albumRepository.save(album);
        return new RedirectView("albums");
    }

//    @ResponseBody
//    @PostMapping("/x")
//    public Album createNewPost(@RequestBody Album post) { // when working with json data
//        Album newPost = albumRepository.save(post);
//        return newPost;
//    }
}


