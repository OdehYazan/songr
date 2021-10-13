package com.example.songr.controller;


import com.example.songr.model.Album;
import com.example.songr.model.Dto;
import com.example.songr.model.Song;
import com.example.songr.repository.AlbumRepository;
import com.example.songr.repository.SongRepository;
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
    @Autowired
    private SongRepository songRepository;


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
    Album album = new Album("MyLife","yazan","https://pica.zhimg.com/f0dc56584_l.jpg?source=172ae18b",11,1000);
    Album album2 = new Album("HisLife","malik","https://pica.zhimg.com/f0dc56584_l.jpg?source=172ae18b",12,2000);
    Album album3 = new Album("ThereLife's","mohammd","https://avatarfiles.alphacoders.com/737/73738.png",13,3000);
    List<Album> albums=new ArrayList<>();
    albums.add(album);
    albums.add(album2);
    albums.add(album3);
    model.addAttribute("Album", albumRepository.findAll());
    model2.addAttribute("album",albums);
    return "albums";
}




    @PostMapping("/albums")
    public RedirectView createAlbum(@ModelAttribute Album album) { // model attribute when working with form data
        albumRepository.save(album);
        return new RedirectView("albums");
    }



    @GetMapping("/select")
    public String getSelect() {
        return "select";
    }

    @PostMapping("/song")
    public RedirectView createNewBlogPost(@ModelAttribute Dto dto) { // modelattribute when working with form data
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"+dto.getAlbum());
        Album album = albumRepository.findAlbumByTitle(dto.getAlbum()).orElseThrow();
        Song newSong = new Song(dto.getTitle(), (int) dto.getLength(), dto.getTrackNumber(),album);
        songRepository.save(newSong);

        return new RedirectView("song");
    }
    @GetMapping("/song")
    public String getSongs(Model model) {
        model.addAttribute("songs", songRepository.findAll());
        return "song";
    }
    @GetMapping("/albums/{album}")
    public String findOneAlbum(@PathVariable String album, Model model) {
        Album oneAlbum = albumRepository.findAlbumByTitle(album).orElseThrow();
        model.addAttribute("album", oneAlbum);

        return "oneAlbum";
    }

}


