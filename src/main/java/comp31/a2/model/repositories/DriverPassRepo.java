package comp31.a2.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import comp31.a2.model.entities.DriverPass;

public interface DriverPassRepo extends CrudRepository<DriverPass, Integer>{

List<DriverPass> findAll();
}

