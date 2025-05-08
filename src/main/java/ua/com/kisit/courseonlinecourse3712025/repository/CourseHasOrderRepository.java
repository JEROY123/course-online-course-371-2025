package ua.com.kisit.courseonlinecourse3712025.repository;

import ua.com.kisit.courseonlinecourse3712025.entity.CourseHasOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.courseonlinecourse3712025.entity.Orders;

import java.util.List;

public interface CourseHasOrderRepository extends JpaRepository<CourseHasOrder, Long> {
    List<CourseHasOrder> findAllCourseHasOrderByOrder(Orders order);
}
