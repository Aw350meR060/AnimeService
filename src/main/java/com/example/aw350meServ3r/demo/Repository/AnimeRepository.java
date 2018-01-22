package com.example.aw350meServ3r.demo.Repository;

import com.example.aw350meServ3r.demo.entities.Anime;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepository extends CrudRepository<Anime,Long> {
    Iterable<Anime> findByNameContaining(String name);
}

