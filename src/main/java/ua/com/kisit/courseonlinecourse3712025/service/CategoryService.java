package ua.com.kisit.courseonlinecourse3712025.service;

import ua.com.kisit.courseonlinecourse3712025.entity.Categories;
import ua.com.kisit.courseonlinecourse3712025.repository.CategoriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoriesRepository categoriesRepository;

    public CategoryService(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    public Categories saveCategory(Categories category) {
        return categoriesRepository.save(category);
    }

    public Categories updateCategory(Categories category) {
        return categoriesRepository.save(category);
    }

    public Categories getCategoryById(Long id) {
        return categoriesRepository.findById(id).orElse(null);
    }

    public List<Categories> getAllCategories() {
        return categoriesRepository.findAll();
    }

    public void deleteCategoryById(Long id) {
        categoriesRepository.deleteById(id);
    }

    public void deleteByCategory(Categories category) {
        categoriesRepository.delete(category);
    }

    public void deleteAllCategories() {
        categoriesRepository.deleteAll();
    }

    public Categories findCategoryById(Long id) {
        return categoriesRepository.findById(id).orElse(null);
    }

    public Object findAll() { return categoriesRepository.findAll(); }
}
