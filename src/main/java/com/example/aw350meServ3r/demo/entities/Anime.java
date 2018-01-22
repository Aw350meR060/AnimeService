package com.example.aw350meServ3r.demo.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="animes")

public class Anime {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private Date air_date;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="director_id")
    private Director director;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="studio_id")
    private Studio studio;

    public Anime() {
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

    public Date getAir_date() {
        return air_date;
    }

    public void setAir_date(Date air_date) {
        this.air_date = air_date;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }
}
