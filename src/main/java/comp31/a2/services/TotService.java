package comp31.a2.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import comp31.a2.model.entities.Admin;
import comp31.a2.model.entities.Driver;
import comp31.a2.model.entities.DriverPass;
import comp31.a2.model.entities.Staff;
import comp31.a2.model.repositories.AdminRepo;
import comp31.a2.model.repositories.DriverPassRepo;
import comp31.a2.model.repositories.DriverRepo;
import comp31.a2.model.repositories.StaffRepo;

@Service
public class TotService {

    Logger logger = LoggerFactory.getLogger(TotService.class);

    StaffRepo staffRepo;
    DriverRepo driverRepo;
    AdminRepo adminRepo;
    DriverPassRepo driverPassRepo;

    public TotService(StaffRepo staffRepo, DriverRepo driverRepo, AdminRepo adminRepo, DriverPassRepo driverPassRepo) {

        this.staffRepo = staffRepo;
        this.driverRepo = driverRepo;
        this.adminRepo = adminRepo;
        this.driverPassRepo = driverPassRepo;
    }

    public List<Staff> findOrder() {
        return staffRepo.findAll();
    }

    public List<Staff> findUser() {
        List<Staff> list1 = staffRepo.findAll();

        logger.info(list1.get(0).getDriver().getDriverName());
        List<Staff> list2 = staffRepo.findByName("John");
        return staffRepo.findAll();

    }

    public List<Staff> findByDriverClass() {

        // logger.info(list1.get(0).getDriver().getDriverName());
        logger.info("hello");
        List<Staff> staffList = staffRepo.findByInDelivery("YES");

        logger.info(staffList.get(0).getName());
        return staffList;
        // return staffRepo.findAll();

    }

    // -----------------------------------------------------------//

    public List<Driver> findDriver() {
        return driverRepo.findAll();
    }


    public void assignOrder(String orderAssign) {

        // List<Staff> orderList = staffRepo.findByName(orderAssign);
        List<Staff> orderList = staffRepo.findByName(orderAssign);

        if (!orderList.isEmpty()) {
            Staff orderTemp = orderList.get(0);

            logger.info(orderTemp.getName());
            String foundLocation = orderTemp.getDeliveryLocation().toString();

            List<Driver> driverList = driverRepo.findByLocation(foundLocation);

            Driver driverTemp = driverList.get(0);

            if (driverTemp.getLocation() == orderTemp.getDeliveryLocation()) {
                orderTemp.setInDelivery("YES");


                orderTemp.setDriver(driverTemp);
                staffRepo.save(orderTemp);


            } else {
                logger.info("bye");
            }
        }

        // else if ()

    }



    public void driverDelete(Integer id) {

        

        Optional<Driver> driverList = driverRepo.findById(id);
        List<Staff> staffList = driverList.get().getStaff();
        if (staffList.isEmpty()) {
            driverRepo.deleteById(id);
        } else {
            Staff vale1 = driverList.get().getStaff().get(0);
            DriverPass passSet = new DriverPass("null");
            Driver driverVal = new Driver("null", "null", passSet);
            driverRepo.save(driverVal);
            vale1.setDriver(driverVal);
            staffRepo.save(vale1);
            driverRepo.deleteById(id);
        }

    }

    public void driverAllDelete() {

        driverRepo.deleteAll();

    }

    public void addOrder(String description, String orderName, String orderDelivery) {

        Staff staffAdd = new Staff();
        staffAdd.setDescription(description);
        staffAdd.setDeliveryLocation(orderDelivery);
        staffAdd.setName(orderName);
        staffAdd.setInDelivery("NO");

        staffRepo.save(staffAdd);

    }

    public String findDriverInfo(String driverName, String password) {

        String webPage;

        List<Driver> driverList = driverRepo.findByDriverName(driverName);

        if (driverList.isEmpty()) {
            webPage = "login-form";
        } else {

            Driver driverInfo = driverList.get(0);

            String username = driverInfo.getDriverName().toString();

            String pass = driverInfo.getDriverPass().getPasswword().toString();

            if (username.equals(driverName) && pass.equals(password)) {
                webPage = "DriverPage";

            } else {
                webPage = "login-form";
            }

        }

        return webPage;

    }

    public List<Staff> findOrderByDriverName(String name) {

        List<Staff> totList = new ArrayList<>();

        List<Driver> driverList = driverRepo.findByDriverName(name);

        String foundLoc = driverList.get(0).getLocation().toString();

        totList = driverList.get(0).getStaff();

        return totList;

    }


    public String checkLoginStaff(String name, String password) {
        String webPage = "login-form";

        List<Admin> adminList = adminRepo.findByUserName(name);

        if (adminList.isEmpty()) {
            return webPage;

        } else {
            String username = adminList.get(0).getUserName().toString();
            String pass = adminList.get(0).getPassword().toString();

            logger.info(pass);

            if (username.equals(name) && pass.equals(password)) {
                return "all";
            }
        }

        return webPage;

    }

    public void unlinkOrder(String name) {

        DriverPass passSet = new DriverPass();
        Driver driverVal = new Driver();
        driverRepo.save(driverVal);

        List<Driver> driverList = driverRepo.findByDriverName(name);
        String orderName = driverList.get(0).getStaff().get(0).getName().toString();

        List<Staff> staffList = staffRepo.findByName(orderName);
        Staff newStaff = staffList.get(0);
        newStaff.setDriver(driverVal);

        staffRepo.save(newStaff);


    }

    public void resetPassword (String name){

        List<Driver> driverList = driverRepo.findByDriverName(name);
        //DriverPass passSet = new DriverPass("12345");
        Driver driver1 = driverList.get(0);
        DriverPass passSet1 = driver1.getDriverPass();
        passSet1.setPasswword("12345");
        driver1.setDriverPass(passSet1);
        driverRepo.save(driver1);

    }

    public List<Staff> findByLocation(String name){
        return staffRepo.findByDeliveryLocation(name);
    }


    public List<DriverPass> findAllDriverPass(){
        return driverPassRepo.findAll();
    }

}
