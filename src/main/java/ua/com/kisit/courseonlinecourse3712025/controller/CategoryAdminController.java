package ua.com.kisit.courseonlinecourse3712025.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisit.courseonlinecourse3712025.entity.Categories;
import ua.com.kisit.courseonlinecourse3712025.service.CategoryService;

@Controller
public class CategoryAdminController {

    private final CategoryService categoryService;

    public CategoryAdminController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/admin/update-categories")
    public String getCategoriesPages(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "category_admin";
    }

    @PostMapping("/saveNewCategory")
    public String saveNewCategory(@RequestParam(name = "name") String name,
                                  @RequestParam(name = "description") String description,
                                  @RequestParam(name = "image") String images
                                  ) {

        Categories category = new Categories();
        category.setName(name);
        category.setDescription(description);
        category.setLinkImages(images);

        categoryService.saveCategory(category);

        return "redirect:/admin/update-categories";

    }

    @PostMapping("/deleteCategoryFromList")
    public String deleteCategoryFromList(@RequestParam(name = "id1") Categories category) {

        // validation
        categoryService.deleteByCategory(category);

        return "redirect:/admin/update-categories";
    }

    @PostMapping("/updateCategory")
    public String updateCategory(@RequestParam(name = "name") String name,
                                 @RequestParam(name = "description") String description,
                                 @RequestParam(name = "image") String images,
                                 @RequestParam(name = "id1") Categories category
                                 ){

        category.setName(name);
        category.setDescription(description);
        category.setLinkImages(images);

        categoryService.updateCategory(category);

        return "redirect:/admin/update-categories";
    }

    @PostMapping("/deleteAllCategory")
    public String deleteAllCategory() {
        categoryService.deleteAllCategories();
        return "redirect:/admin/update-categories";
    }
}
