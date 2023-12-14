package comp31.a2.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import comp31.a2.model.entities.Driver;
import comp31.a2.model.entities.Staff;

/**
 * Entity1Repository
 */
public interface StaffRepo extends CrudRepository<Staff, Integer> {

    List<Staff> findAll();

    List<Staff> findByName(String name);

    List<Staff> findByInDelivery(String inDelivery);

    List<Staff> findByDriver(Driver driver);

    List<Staff> findByDeliveryLocation(String deliveryLocation);

}