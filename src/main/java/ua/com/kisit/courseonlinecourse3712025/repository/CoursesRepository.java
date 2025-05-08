package ua.com.kisit.courseonlinecourse3712025.repository;

import ua.com.kisit.courseonlinecourse3712025.entity.Categories;
import ua.com.kisit.courseonlinecourse3712025.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CoursesRepository extends JpaRepository<Courses, Long> {
    Courses findCourseByName(String name);
    List<Courses> findAllByCategory(Categories category);
}
