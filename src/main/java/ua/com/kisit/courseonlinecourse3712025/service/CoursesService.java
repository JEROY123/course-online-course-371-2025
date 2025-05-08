package ua.com.kisit.courseonlinecourse3712025.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ua.com.kisit.courseonlinecourse3712025.entity.Categories;
import ua.com.kisit.courseonlinecourse3712025.entity.Courses;
import ua.com.kisit.courseonlinecourse3712025.repository.CoursesRepository;

import java.util.List;

@Service
public class CoursesService {
    private final CoursesRepository coursesRepository;

    public CoursesService(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    public Courses saveCourse(Courses course) {
        return coursesRepository.save(course);
    }

    public Courses updateCourse(Courses course) {
        return coursesRepository.save(course);
    }

    public Courses getCourseById(Long id) {
        return coursesRepository.findById(id).orElse(null);
    }

    public void deleteCourse(Courses course) {
        coursesRepository.delete(course);
    }

    public void deleteAllCourses() {
        coursesRepository.deleteAll();
    }

    public List<Courses> getAllCourses() {
        return coursesRepository.findAll();
    }

    @Cacheable(cacheNames = "coursesById", key = "#category.id")
    public List<Courses> getCoursesByCategory(Categories category) {
        return coursesRepository.findAllByCategory(category);
    }

}
