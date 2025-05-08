package ua.com.kisit.courseonlinecourse3712025.bl;

import ua.com.kisit.courseonlinecourse3712025.entity.Courses;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class Cart {
    List<Courses> cart;
    public double totalValue;

    public Cart() {
        cart = new ArrayList<>();
        totalValue = 0;
    }

    public synchronized void addItemToCart(Courses course) {
        for(Courses itemCart : cart) {
            if(Objects.equals(course.getId(), itemCart.getId())) {
                return;
            }
        }
        cart.add(course);
    }

    public synchronized void removeItemFromCart(Courses course) {
        for(Courses itemCart : cart) {
            if(Objects.equals(course.getId(), itemCart.getId())) {
                cart.remove(itemCart);
                break;
            }
        }
    }

    public synchronized void deleteAllItemsFromCart() {
        cart.clear();
    }

    public synchronized double getTotalValue() {
        totalValue = 0;
        for (Courses course : cart) {
            totalValue += course.getPrice().doubleValue();
        }
        return totalValue;
    }


}
