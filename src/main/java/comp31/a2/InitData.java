package comp31.a2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import comp31.a2.model.entities.Admin;
import comp31.a2.model.entities.Driver;
import comp31.a2.model.entities.DriverPass;
import comp31.a2.model.entities.Staff;
import comp31.a2.model.repositories.AdminRepo;
import comp31.a2.model.repositories.DriverPassRepo;
import comp31.a2.model.repositories.DriverRepo;
import comp31.a2.model.repositories.StaffRepo;
import comp31.a2.model.repositories.StaffRepo;

@Component
public class InitData implements CommandLineRunner {

    StaffRepo staffRepo;
    DriverRepo driverRepo;
    DriverPassRepo driverPassRepo;
    AdminRepo adminRepo;


    public InitData(StaffRepo staffRepo, DriverRepo driverRepo, DriverPassRepo driverPassRepo, AdminRepo adminRepo) {
        this.staffRepo = staffRepo;
        this.driverRepo = driverRepo;
        this.driverPassRepo = driverPassRepo;
        this.adminRepo = adminRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        // StaffRepo.save(new Entity1("Entity1"));
        // StaffRepo.save(new Entity1("Entity2"));
        // StaffRepo.save(new Entity1("Entity3"));

        Admin admin1 = new Admin("scott", "scott");
        Admin admin2 = new Admin("bolt", "bolt");

        adminRepo.save(admin1);
        adminRepo.save(admin2);


        

        /*staffRepo.save(staff1);
        staffRepo.save(staff2);
        staffRepo.save(staff3);
        staffRepo.save(staff4);
        staffRepo.save(staff5);
        staffRepo.save(staff6);


        staffRepo.save(empty);*/

        DriverPass driverPass1 = new DriverPass("John");
        DriverPass driverPass2 = new DriverPass("Vemi");
        DriverPass driverPass3 = new DriverPass("Griffin");
        DriverPass driverPass4 = new DriverPass("Robert");
        DriverPass driverPass5 = new DriverPass("Peter");
        DriverPass driverPass6 = new DriverPass("Peter");
        DriverPass driverPass7 = new DriverPass("null");

        Driver driver1 = new Driver("John", "Ontario", driverPass1);
        Driver driver2 = new Driver("Vemi", "Toronto", driverPass2);
        Driver driver3 = new Driver("Griffin", "BC", driverPass3);
        Driver driver4 = new Driver("Robert", "LV", driverPass4);
        Driver driver5 = new Driver("Peter", "OTTAWA", driverPass5);
        Driver driver6 = new Driver("Sam", "OTTAWA", driverPass6);


        driverRepo.save(driver1);
        driverRepo.save(driver2);
        driverRepo.save(driver3);
        driverRepo.save(driver4);
        driverRepo.save(driver5);
        driverRepo.save(driver6);


        Staff staff1 = new Staff("product1", "eraser", "Ontario", "YES", driver1);
        Staff staff2 = new Staff("product2", "boot", "Toronto", "NO", null);
        Staff staff3 = new Staff("product3", "pen", "BC", "YES", driver3);
        Staff staff4 = new Staff("product4", "sharpener", "BC", "NO", null);
        Staff staff5 = new Staff("product5", "whitner", "LV", "NO", null);

        Staff empty = new Staff("null", "null", "null", "null", null);

        Staff staff6 = new Staff("product6", "glue", "Ontario", "NO", null);
        Staff staff7 = new Staff("product6", "glue1", "Ontario", "NO", null);


        staffRepo.save(staff1);
        staffRepo.save(staff2);
        staffRepo.save(staff3);
        staffRepo.save(staff4);
        staffRepo.save(staff5);
        staffRepo.save(staff6);
        staffRepo.save(staff7);
        /*driverRepo.save(new Driver("Vemi", "Toronto", empty, driverPass2));
        driverRepo.save(new Driver("Griffin", "BC", staff3, driverPass3));
        driverRepo.save(new Driver("Robert", "LV", empty, driverPass4));
        driverRepo.save(new Driver("Peter", "OTTAWA", empty, driverPass5));*/


    }

}
