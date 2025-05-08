package ua.com.kisit.courseonlinecourse3712025.controller;

import ua.com.kisit.courseonlinecourse3712025.bl.Cart;
import ua.com.kisit.courseonlinecourse3712025.entity.Courses;
import ua.com.kisit.courseonlinecourse3712025.entity.Orders;
import ua.com.kisit.courseonlinecourse3712025.entity.Payments;
import ua.com.kisit.courseonlinecourse3712025.service.CourseHasOrderService;
import ua.com.kisit.courseonlinecourse3712025.service.CustomerService;
import ua.com.kisit.courseonlinecourse3712025.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class OrderController {
    private final OrderService orderService;
    private final CustomerService customerService;
    private final CourseHasOrderService courseHasOrderService;

    public OrderController(OrderService orderService,
                           CustomerService customerService,
                           CourseHasOrderService courseHasOrderService)
    {
        this.orderService = orderService;
        this.customerService = customerService;
        this.courseHasOrderService = courseHasOrderService;
    }

    @GetMapping("/order")
    public String getPageOrder(Model model,
                               HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        Object user_id = session.getAttribute("user_id");

        if(user_id == null) {
            return "redirect:/login";
        }

        Cart cart = (Cart) session.getAttribute("cart");
        if(cart == null) {
            return "redirect:/";
        }

        model.addAttribute("customer", customerService.getCustomerById((Long) user_id));
        model.addAttribute("cart", cart.getCart());
        model.addAttribute("totalValue", cart.getTotalValue());
        model.addAttribute("totalEl", cart.getCart().size());

        return "order";
    }

    @PostMapping("/order")
    public String processOrder(
            @RequestParam(name = "payment")Payments payment,
            HttpServletRequest request,
            RedirectAttributes redirectAttributes)
    {
        HttpSession session = request.getSession();
        Object user_id = session.getAttribute("user_id");
        if(user_id == null) {
            return "redirect:/login";
        }

        Cart cart = (Cart) session.getAttribute("cart");
        if(cart == null) {
            return "redirect:/";
        }

        if (cart.getCart().isEmpty()) {
            return "redirect:/order";
        }

        Orders order = new Orders();
        order.setPayment(payment);
        order.setDateCreated(new Date());
        order.setCustomer(customerService.getCustomerById((Long) user_id));
        order.setStatusOrder("Необроблене замовлення");

        Orders savedOrder = orderService.save(order);

        for(Courses course: cart.getCart()) {
            courseHasOrderService.saveNewCourseHasOrder(course, savedOrder);
        }

        cart.deleteAllItemsFromCart();
        session.setAttribute("cart", cart);

        redirectAttributes.addAttribute("savedOrder", savedOrder);

        return "redirect:/thanks";
    }

    @GetMapping("/thanks")
    public String getThankPage(@RequestParam(name = "savedOrder", defaultValue = " ") Long orderId,
                               Model model){

        model.addAttribute("orderId", orderId);

        return "thanks";
    }
}
