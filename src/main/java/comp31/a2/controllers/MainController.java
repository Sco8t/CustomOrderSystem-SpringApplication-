package comp31.a2.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import comp31.a2.model.entities.DropBox;
import comp31.a2.model.entities.Staff;

import comp31.a2.services.TotService;

@Controller
public class MainController {

    TotService totService;

    public MainController(TotService totService) {
        super();
        this.totService = totService;
    }

    Logger logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/uc1")
    public String getUseCase1() {
        return "usecase1";
    }

    @GetMapping("/login")
    public String getBad() {
        return "login-form";
    }

    @GetMapping("/order")
    public String getOrder(Model model, DropBox emp) {
        model.addAttribute("order", totService.findOrder());
        model.addAttribute("emp", emp);
        return "order";
    }

    @GetMapping("/driver")
    public String getDriver(Model model) {
        List<Staff> staffL = totService.findDriver().get(0).getStaff();
        List<Staff> driveL = totService.findUser();
        totService.findByDriverClass();
        model.addAttribute("driver", totService.findDriver());
        model.addAttribute("staff", totService.findByDriverClass());
        // model.addAttribute("staff", totService.findUser());
        return "driver";
    }

    @GetMapping("/assign")
    public String getAssign(Model model) {
        model.addAttribute("driver", totService.findDriver());
        model.addAttribute("staff", totService.findByDriverClass());
        model.addAttribute("order", totService.findOrder());
        return "assignOrder";
    }

    @GetMapping("/orderAssign")
    public String getOrderAssign(
            Model model) {

        model.addAttribute("driver", totService.findDriver());
        model.addAttribute("staff", totService.findByDriverClass());
        model.addAttribute("order", totService.findOrder());

        return "assignOrder";
    }

    @PostMapping("/orderAssign")
    public String postOrderAssign(
            @RequestParam(required = false) String orderAssign,
            Model model) {

        totService.assignOrder(orderAssign);
        model.addAttribute("driver", totService.findDriver());
        model.addAttribute("staff", totService.findByDriverClass());
        model.addAttribute("order", totService.findOrder());

        return "assignOrder";
    }

    @GetMapping("/deleteOrder")
    public String deleteOrder(Model model) {

        model.addAttribute("driver", totService.findDriver());

        return "delete";
    }

    @PostMapping("/deleteOrder")
    public String postDeleteOrder(
            @RequestParam(required = false) String deleteOrder,
            Model model) {

        logger.info(deleteOrder);

        Integer value = Integer.parseInt(deleteOrder);

        totService.driverDelete(value);

        model.addAttribute("driver", totService.findDriver());

        return "delete";
    }

    @GetMapping("/deleteAll")
    public String deleteAll() {

        return "delete";
    }

    @PostMapping("/deleteAll")
    public String postDeleteAll(
            Model model) {

        totService.driverAllDelete();

        return "delete";
    }

    @GetMapping("/addOrder")
    public String addOrder(Model model) {

        model.addAttribute("order", totService.findOrder());

        return "order";
    }

    @PostMapping("/addOrder")
    public String postAddOrder(@RequestParam(required = false) String orderDesc,
            @RequestParam(required = false) String orderName,
            @RequestParam(required = false) String orderDelivery,
            Model model) {

        // model.addAttribute("order", totService.findOrder());
        if (orderName != "") {
            totService.addOrder(orderDesc, orderName, orderDelivery);
        }

        model.addAttribute("order", totService.findOrder());

        return "order";
    }

    @PostMapping("/filterLocation")
    public String filterLocation(
            @RequestParam(required = false) String location,
            Model model) {

        // model.addAttribute("order", totService.findOrder());

        model.addAttribute("order", totService.findByLocation(location));

        return "order";
    }

    @GetMapping("/unlinkOrder")
    public String getUnlink(Model model) {

        model.addAttribute("value");

        return "DriverPage";
    }

    @PostMapping("/unlinkOrder")
    public String postUnlink(Model model, @RequestParam(required = false) String custId) {

        totService.unlinkOrder(custId);
        model.addAttribute("value", custId);

        return "DriverNull";
    }

    @GetMapping("/password")
    public String getPassword(Model model) {

        model.addAttribute("DriverPass", totService.findAllDriverPass());

        return "password";
    }

    @PostMapping("/password")
    public String postPassword(Model model, @RequestParam(required = false) String passwordReset) {

        totService.resetPassword(passwordReset);
        model.addAttribute("DriverPass", totService.findAllDriverPass());

        return "password";
    }

    @GetMapping("/box")
    public String getBox(Model model, DropBox emp) {
        // model.addAttribute("boxvalue", value);

        model.addAttribute("emp", emp);

        return "order";
    }

    @PostMapping("/box")
    public String postBox(Model model, DropBox emp) {
        // model.addAttribute("boxvalue", value);

        String hello = emp.getUser().toString();

        if (hello.equals("orders")) {
            return "usecase1";
        }
        return "driver";
    }

    @GetMapping("/mainPage")
    public String getBooks(
            @RequestParam(required = false) String userId,
            @RequestParam(required = false) String password,
            Model model) {

        String returnPage = totService.findDriverInfo(userId, password);
        if (returnPage.equals("DriverPage")) {
            List<Staff> orderList = totService.findOrderByDriverName(userId);
            if (orderList.isEmpty()) {

                model.addAttribute("value", userId);
                returnPage = "DriverNull";
            } else {
                model.addAttribute("value", totService.findOrderByDriverName(userId));
                returnPage = "DriverPage";
            }

        } else if (returnPage.equals("login-form")) {
            returnPage = totService.checkLoginStaff(userId, password);
            model.addAttribute("order", totService.findOrder());
            return returnPage;
        } else {
            return returnPage;
        }
        return returnPage;
    }

    @PostMapping("/mainPage")
    public String postBook(
            @RequestParam(required = false) String userId,
            @RequestParam(required = false) String password,
            Model model) {
        /*
         * boolean authorNameInvalid = userId == null || userId.isEmpty() ||
         * password == null || password.isEmpty();
         */

        String returnPage = totService.findDriverInfo(userId, password);
        if (returnPage.equals("DriverPage")) {
            List<Staff> orderList = totService.findOrderByDriverName(userId);
            if (orderList.isEmpty()) {

                model.addAttribute("value", userId);
                returnPage = "DriverNull";
            } else {
                model.addAttribute("value", totService.findOrderByDriverName(userId));
                returnPage = "DriverPage";
            }

        } else if (returnPage.equals("login-form")) {
            returnPage = totService.checkLoginStaff(userId, password);
            model.addAttribute("order", totService.findOrder());
            return returnPage;
        } else {
            return returnPage;
        }
        return returnPage;

    }

}
