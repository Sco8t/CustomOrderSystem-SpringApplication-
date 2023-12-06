package comp31.a2.model.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
//@Table(name="Driver")
@NoArgsConstructor
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DRIVER_ID")
    private Integer id;

    @Column(name = "Driver_Name")
    private String driverName;

    @Column(name = "Route_Location")
    private String location;

    /*@ManyToOne
    @JoinColumn(name = "ORDER_ID", nullable = true)
    Staff staff;*/

    //pp
    @OneToMany(mappedBy = "driver")
    private List<Staff> staff;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driverPass_id")
    DriverPass driverPass;





    

    public Driver(String driverName, String location, DriverPass driverPass){
        this.driverName = driverName;
        this.location = location;
        this.driverPass = driverPass;
    }

    public Driver(String driverName, String location){
        this.driverName = driverName;
        this.location = location;
        Staff staff = new Staff();
        staff.setDescription("ddd");
        staff.setName("fff");
        staff.setDeliveryLocation("nudddll");

    }

    



}
