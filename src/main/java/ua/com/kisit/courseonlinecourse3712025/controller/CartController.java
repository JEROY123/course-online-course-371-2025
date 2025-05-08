package ua.com.kisit.courseonlinecourse3712025.controller;

import ua.com.kisit.courseonlinecourse3712025.bl.Cart;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisit.courseonlinecourse3712025.entity.Courses;

@Controller
public class CartController {

    @GetMapping("/cart")
    public String getPageCart(Model model,
                              HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }
        model.addAttribute("cart", cart.getCart());
        model.addAttribute("totalValue", cart.getTotalValue());
        model.addAttribute("sumEl", cart.getCart().size());

        return "cart";
    }


    @PostMapping("/addToCart")
    public String addToCart(@RequestParam(name = "id") Courses course,
                            HttpServletRequest request)
    {
        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) cart = new Cart();

        cart.addItemToCart(course);

        session.setAttribute("cart", cart);
        return "redirect:/cart";
    }

    @PostMapping("/deleteItemFromCart")
    public String deleteItemFromCart(@RequestParam(name = "id") Courses course,
                                     HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
        } else {
            cart.removeItemFromCart(course);
        }

        session.setAttribute("cart", cart);
        return "redirect:/cart";
    }

    @PostMapping("/deleteAllItemsFromCart")
    public String deleteAllItemsFromCart(HttpServletRequest request){
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
        } else {
            cart.getCart().clear();
        }

        session.setAttribute("cart", cart);
        return "redirect:/cart";
    }

}
