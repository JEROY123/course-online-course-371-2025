package ua.com.kisit.courseonlinecourse3712025.service;

import ua.com.kisit.courseonlinecourse3712025.entity.Customers;
import ua.com.kisit.courseonlinecourse3712025.repository.CustomersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomersRepository customersRepository;

    public CustomerService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    public Customers saveNewCustomer(Customers customer){
        return customersRepository.save(customer);
    }

    public List<Customers> findAll() {
        return customersRepository.findAll();
    }

    public Customers getCustomerById(Long id){
        return customersRepository.findById(id).orElse(null);
    }

    public List<Customers> getAllCustomers(){
        return customersRepository.findAll();
    }
}
