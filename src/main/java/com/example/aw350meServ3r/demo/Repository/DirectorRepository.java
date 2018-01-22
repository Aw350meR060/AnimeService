package com.example.aw350meServ3r.demo.Repository;

        import com.example.aw350meServ3r.demo.entities.Director;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends CrudRepository<Director, Long> {
        Iterable<Director> findByNameContaining(String name);
}
