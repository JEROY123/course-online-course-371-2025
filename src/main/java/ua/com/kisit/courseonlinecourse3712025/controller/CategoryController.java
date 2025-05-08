package ua.com.kisit.courseonlinecourse3712025.controller;

import ua.com.kisit.courseonlinecourse3712025.entity.Categories;
import ua.com.kisit.courseonlinecourse3712025.service.CategoryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping({"/", "/categories"})
    public String getHomePage(Model model, HttpServletRequest request)
    {
        List<Categories> categoriesList = categoryService.getAllCategories();

        HttpSession session = request.getSession();

        Object listPresentation = session.getAttribute("listPresentation");

        model.addAttribute("listPresentation", (listPresentation == null) ? "false" : "true");
        model.addAttribute("categories", categoriesList);
        return "index";
    }
}
