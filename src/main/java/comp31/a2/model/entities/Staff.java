package comp31.a2.model.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
//@Table(name = "STAFF")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    @Column(name = "ORDER_ID")
    private Integer id;

    @Column(name = "DESCR")
    String description;

     @Column(name = "ORDER_NAME")
    String name;

    @Column(name = "DEL_location")
    String deliveryLocation;

    @Column(name = "IN_DELIVERY")
    String inDelivery;

    /*@OneToMany(mappedBy = "staff")
    private List<Driver> driver;*/



    //pp
    @ManyToOne
    @JoinColumn(name = "DRIVER_ID", nullable = true)
    Driver driver;



    /*public Staff(String description) {
        System.out.println("Creating " + description);
        this.description = description;
    }*/

    /*public Staff() {
        id = 0;
        description = "";
        name = "";
        driver = null;
    }*/

    public Staff(String description, String name, String deliveryLocation, String inDelivery, Driver driver){
        this.description = description;
        this.name = name;
        this.deliveryLocation = deliveryLocation;
        this.inDelivery = inDelivery;
        this.driver = driver;
    }

}
