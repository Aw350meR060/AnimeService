package com.example.aw350meServ3r.demo.services;

import com.example.aw350meServ3r.demo.Repository.AnimeRepository;
import com.example.aw350meServ3r.demo.Repository.DirectorRepository;
import com.example.aw350meServ3r.demo.Repository.StudioRepository;
import com.example.aw350meServ3r.demo.entities.Anime;
import com.example.aw350meServ3r.demo.entities.Director;
import com.example.aw350meServ3r.demo.entities.Studio;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AnimeService {
    @Autowired
    private AnimeRepository animeRepository;
    @Autowired
    private StudioRepository studioRepository;
    @Autowired
    private DirectorRepository directorRepository;



    Map<String, Set<Pair<Long, String>>> globalSearch(String string){
        Map<String, Set<Pair<Long, String>>> result = new HashMap<>();

        Set<Pair<Long, String>> animes = StreamSupport.stream(animeRepository.findByNameContaining(string).spliterator(), true)
                .map((x) -> new Pair<>(x.getId(), x.getName()))
                .collect(Collectors.toSet());
        Set<Pair<Long, String>> directors = StreamSupport.stream(directorRepository.findByNameContaining(string).spliterator(), true)
                .map((x) -> new Pair<>(x.getId(), x.getName()))
                .collect(Collectors.toSet());
        Set<Pair<Long, String>> studios = StreamSupport.stream(directorRepository.findByNameContaining(string).spliterator(), true)
                .map((x) -> new Pair<>(x.getId(), x.getName()))
                .collect(Collectors.toSet());
        result.put("animes", animes);
        result.put("directors",directors);
        result.put("studios",studios);
        return result;
    }

    public Optional<Director> getDirector(long id){
        return directorRepository.findById(id);
    }
    public Optional<Studio> getStudio(long id){ return studioRepository.findById(id); }
    public Optional<Anime> getAnime(long id){ return animeRepository.findById(id);}
    public Iterable<Anime> getAnimeByTitle(String title){
        return animeRepository.findByNameContaining(title);
    }
    public Iterable<Anime> getAllAnimes(){
        return animeRepository.findAll();
    }
}
