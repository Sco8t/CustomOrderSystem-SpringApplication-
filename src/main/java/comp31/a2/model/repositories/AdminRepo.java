package comp31.a2.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import comp31.a2.model.entities.Admin;

public interface AdminRepo extends CrudRepository<Admin, Integer> {

    List<Admin> findByUserName(String userName);

}
