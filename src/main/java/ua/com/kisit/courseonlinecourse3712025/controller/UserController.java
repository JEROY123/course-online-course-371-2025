package ua.com.kisit.courseonlinecourse3712025.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ua.com.kisit.courseonlinecourse3712025.bl.Cart;
import ua.com.kisit.courseonlinecourse3712025.entity.Clients;
import ua.com.kisit.courseonlinecourse3712025.entity.Customers;
import ua.com.kisit.courseonlinecourse3712025.entity.Roles;
import ua.com.kisit.courseonlinecourse3712025.repository.RolesRepository;
import ua.com.kisit.courseonlinecourse3712025.service.ClientService;
import ua.com.kisit.courseonlinecourse3712025.service.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisit.courseonlinecourse3712025.service.RolesService;

import java.security.Principal;
import java.util.Collections;

@Controller
public class UserController {
    private final ClientService clientService;
    private final CustomerService customerService;
    private final RolesService rolesService;

    public UserController(ClientService clientService, CustomerService customerService, RolesRepository rolesRepository, RolesService rolesService) {
        this.clientService = clientService;
        this.customerService = customerService;
        this.rolesService = rolesService;
    }

    @GetMapping("/login")
    public String getPagelogin() {
        return "login";
    }

    @GetMapping("/registration")
    public String getPageRegistration(Model model) {

        model.addAttribute("clients", new Clients());
        model.addAttribute("customers", new Customers());

        return "registration";
    }

    @PostMapping("/registration")
    public String registrationNewUser(@Valid Customers customer,
                                      BindingResult bindingResultCustomer,
                                      @Valid Clients client,
                                      BindingResult bindingResultClient)
    {
        if (bindingResultCustomer.hasErrors()) {
            return "registration";
        }
        if (bindingResultClient.hasErrors()) {
            return "registration";
        }
        if (clientService.getClientByLogin(client.getUsername())) {
            return "redirect:/registration";
        }

        String password = new BCryptPasswordEncoder().encode(client.getPassword());
        client.setPassword(password);

        Clients new_client = clientService.saveNewClient(client);
        new_client.setRolesSet(Collections.singleton(new Roles(3L, "student")));

        customer.setClient(new_client);
        customerService.saveNewCustomer(customer);

        return "redirect:/login";
    }

    @GetMapping("/login_success")
    public String getLoginSuccess(HttpServletRequest request, Principal principal) {
        HttpSession session = request.getSession();
        String username = principal.getName();
        Long user_id = clientService.getClientByUsername(username).getId();
        session.setAttribute("user_id", user_id);
        session.setAttribute("userName", customerService.getCustomerById(user_id).getFirstName() +
                    " " + customerService.getCustomerById(user_id).getLastName());
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            return "redirect:/";
        }
        return "redirect:/order";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/login";
    }
}
