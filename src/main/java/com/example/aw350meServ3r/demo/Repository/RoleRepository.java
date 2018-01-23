package com.example.aw350meServ3r.demo.Repository;

import com.example.aw350meServ3r.demo.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}
