package ua.com.kisit.courseonlinecourse3712025.service;

import ua.com.kisit.courseonlinecourse3712025.entity.Orders;
import ua.com.kisit.courseonlinecourse3712025.repository.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrdersRepository ordersRepository;

    public OrderService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public Orders save(Orders order) {
        return ordersRepository.save(order);
    }

    public List<Orders> getOrdersPages() {
        return ordersRepository.findAll();
    }
}
