package ua.com.kisit.courseonlinecourse3712025.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.com.kisit.courseonlinecourse3712025.entity.Orders;
import ua.com.kisit.courseonlinecourse3712025.entity.CourseHasOrder;
import ua.com.kisit.courseonlinecourse3712025.service.OrderService;
import ua.com.kisit.courseonlinecourse3712025.service.CourseHasOrderService;

import java.util.List;

@Controller
public class OrderAdminController {

    private final OrderService orderService;
    private final CourseHasOrderService courseHasOrderService;


    public OrderAdminController(OrderService orderService, CourseHasOrderService courseHasOrderService) {
        this.orderService = orderService;
        this.courseHasOrderService = courseHasOrderService;

    }

    @GetMapping("/admin/orders")
    public String getOrderPages(Model model) {

        model.addAttribute("orders", orderService.getOrdersPages());

        return "orders_admin";
    }

    @GetMapping("/admin/order/{id}")
    public String getViewOrderPage(@PathVariable("id") Orders order,
                                   Model model) {

        List<CourseHasOrder> courseHasOrderList =  courseHasOrderService.getCourseHasOrderByOrder(order);
        model.addAttribute("order",order);

        double values = 0;
        for (CourseHasOrder courseHasOrder : courseHasOrderList) {
            values +=  courseHasOrder.getCourse().getPrice().doubleValue();
        }

        model.addAttribute("value", values);

        model.addAttribute("courseHasOrderList", courseHasOrderList);

        return "order_admin";
    }
}
