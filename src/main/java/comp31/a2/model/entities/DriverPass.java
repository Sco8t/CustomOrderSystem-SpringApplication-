package comp31.a2.model.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class DriverPass {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DRIVERPASS_ID")
    private Integer id;

    @Column(name = "Driver_Password")
    private String passwword;

    @OneToOne(mappedBy = "driverPass")
    private Driver driver;



    public DriverPass(String password){
        this.passwword = password;

    }
    
}
