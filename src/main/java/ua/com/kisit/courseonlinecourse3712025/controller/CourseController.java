package ua.com.kisit.courseonlinecourse3712025.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisit.courseonlinecourse3712025.entity.Categories;
import ua.com.kisit.courseonlinecourse3712025.service.CategoryService;
import ua.com.kisit.courseonlinecourse3712025.service.CoursesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CourseController {
    private final CoursesService coursesService;
    private final CategoryService categoryService;

    public CourseController(CoursesService coursesService, CategoryService categoryService) {
        this.coursesService = coursesService;
        this.categoryService = categoryService;
    }

    @GetMapping("/category/{id}")
    public String getCategory(@PathVariable(name = "id") Long id, Model model) {
        Categories category = (Categories) categoryService.getCategoryById(id);
        if (category == null) {
            return "redirect:/index";
        }

        model.addAttribute("category", category);
        model.addAttribute("courses", coursesService.getCoursesByCategory(category));
//        model.addAttribute("categories", categoryService.getAllCategories());

        return "coursesByCategory";
    }

    @GetMapping("/list_card")
    public String getPageCategory(
            @RequestParam(name = "listPresentation", defaultValue = "false") String listPresentation,
            HttpServletRequest request,
            Model model)
    {

        HttpSession session = request.getSession();

        if(listPresentation.equals("true")) {
            session.setAttribute("listPresentation", true);
            model.addAttribute("listPresentation", "true");
        } else {
            session.setAttribute("listPresentation", false);
            model.addAttribute("listPresentation", "false");
        }

        model.addAttribute("categories", categoryService.findAll());

        return "index";
    }

}
