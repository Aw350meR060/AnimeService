package com.example.aw350meServ3r.demo.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="directors")

public class Director {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "director")
    private List<Anime> animes;

    public Director() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Anime> getAnimes() {
        return animes;
    }

    public void setAnimes(List<Anime> animes) {
        this.animes = animes;
    }
}
