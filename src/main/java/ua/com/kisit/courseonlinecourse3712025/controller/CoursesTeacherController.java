package ua.com.kisit.courseonlinecourse3712025.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisit.courseonlinecourse3712025.entity.Categories;
import ua.com.kisit.courseonlinecourse3712025.entity.Courses;
import ua.com.kisit.courseonlinecourse3712025.entity.Customers;
import ua.com.kisit.courseonlinecourse3712025.service.CategoryService;
import ua.com.kisit.courseonlinecourse3712025.service.CoursesService;
import ua.com.kisit.courseonlinecourse3712025.service.CustomerService;

import java.math.BigDecimal;

@Controller
public class CoursesTeacherController {

    private final CoursesService coursesService;
    private final CategoryService categoryService;
    private final CustomerService customerService;

    public CoursesTeacherController(CoursesService coursesService, CategoryService categoryService, CustomerService customerService) {
        this.coursesService = coursesService;
        this.categoryService = categoryService;
        this.customerService = customerService;
    }

    @GetMapping("/teacher/update-courses")
    public String getCoursesManagerPages(Model model) {

        model.addAttribute("courses", coursesService.getAllCourses());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("customers", customerService.findAll());

        return "courses_teacher";
    }

    @PostMapping("/saveNewCourse")
    public String saveNewCourse(@RequestParam(name = "name") String name,
                                 @RequestParam(name = "short_description") String short_description,
                                 @RequestParam(name = "full_description") String full_description,
                                 @RequestParam(name = "image") String image,
                                 @RequestParam(name = "price") double price,
                                 @RequestParam(name = "categories") Categories category,
                                 @RequestParam(name = "customers") Customers teacher
                                 ) {

        Courses course = new Courses(name, short_description, full_description, image, new BigDecimal(price), teacher, category);

        coursesService.saveCourse(course);

        return "redirect:/teacher/update-courses";
    }

    @PostMapping("/updateCourses")
    public String updateCourses( @RequestParam(name = "id") Courses course,
                                 @RequestParam(name = "name") String name,
                                 @RequestParam(name = "short_description") String short_description,
                                 @RequestParam(name = "full_description") String full_description,
                                 @RequestParam(name = "image") String image,
                                 @RequestParam(name = "price") double price,
                                 @RequestParam(name = "categories") Long category_id,
                                 @RequestParam(name = "customers") Long teacher_id
    ) {

        course.setName(name);
        course.setFull_description(full_description);
        course.setShort_description(short_description);
        course.setPrice(new BigDecimal(price));
        Categories categories = categoryService.findCategoryById(category_id);
        course.setCategory(categories);
        Customers teacher = customerService.getCustomerById(teacher_id);
        course.setTeacher(teacher);
        course.setLinkImage(image);

        coursesService.updateCourse(course);

        return "redirect:/teacher/update-courses";
    }

    @PostMapping("/deleteCourse")
    public String deleteCourse(@RequestParam(name = "id") Courses courses) {
        coursesService.deleteCourse(courses);


        return "redirect:/teacher/update-courses";
    }

    @PostMapping("/deleteAllCourses")
    public String deleteAllCourses() {
        coursesService.deleteAllCourses();

        return "redirect:/teacher/update-courses";
    }
}