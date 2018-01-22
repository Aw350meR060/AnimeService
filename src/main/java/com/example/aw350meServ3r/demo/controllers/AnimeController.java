package com.example.aw350meServ3r.demo.controllers;

import com.example.aw350meServ3r.demo.entities.Anime;
import com.example.aw350meServ3r.demo.services.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AnimeController {
    @Autowired
    AnimeService anime;

    @GetMapping
    public String index(){
        return "index";
    }
    @GetMapping("/anime-list/{id}")
    public Optional<Anime> getAnime(@PathVariable long id){
        return anime.getAnime(id);
    }

    @GetMapping("/anime-list")
    public Iterable<Anime> getAnimeList(){
        return anime.getAllAnimes();
    }
}
