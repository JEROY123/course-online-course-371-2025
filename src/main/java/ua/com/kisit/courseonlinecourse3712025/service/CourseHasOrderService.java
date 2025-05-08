package ua.com.kisit.courseonlinecourse3712025.service;

import ua.com.kisit.courseonlinecourse3712025.entity.CourseHasOrder;
import ua.com.kisit.courseonlinecourse3712025.entity.Courses;
import ua.com.kisit.courseonlinecourse3712025.entity.Orders;
import ua.com.kisit.courseonlinecourse3712025.repository.CourseHasOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseHasOrderService {
    private CourseHasOrderRepository courseHasOrderRepository;

    public CourseHasOrderService(CourseHasOrderRepository courseHasOrderRepository) {
        this.courseHasOrderRepository = courseHasOrderRepository;
    }

    public void saveNewCourseHasOrder(Courses course, Orders order) {
        courseHasOrderRepository.save(new CourseHasOrder(course, order));
    }

    public List<CourseHasOrder> getCourseHasOrderByOrder(Orders order) {
        return courseHasOrderRepository.findAllCourseHasOrderByOrder(order);
    }
}
