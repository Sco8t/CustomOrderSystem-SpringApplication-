package comp31.a2.model.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import comp31.a2.model.entities.Driver;
import comp31.a2.model.entities.Staff;

public interface DriverRepo extends CrudRepository<Driver, Integer>{

    public List<Driver> findAll();

    List<Driver> findByLocation(String location);

    List<Driver> findByDriverName(String driverName);

    Optional<Driver> findById(Integer id);



}
