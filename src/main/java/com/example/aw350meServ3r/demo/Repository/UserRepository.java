package com.example.aw350meServ3r.demo.Repository;

import com.example.aw350meServ3r.demo.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    User findByUsername(String Username);
}
