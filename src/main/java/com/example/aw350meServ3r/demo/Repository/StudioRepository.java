package com.example.aw350meServ3r.demo.Repository;

import com.example.aw350meServ3r.demo.entities.Studio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudioRepository extends CrudRepository<Studio,Long>{
    Iterable<Studio> findByNameContaining(String name);
}
