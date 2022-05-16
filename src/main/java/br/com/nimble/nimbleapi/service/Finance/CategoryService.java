package br.com.nimble.nimbleapi.service.Finance;

import br.com.nimble.nimbleapi.model.Finance.Category;
import br.com.nimble.nimbleapi.repository.Finance.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository repository;
    
    public List<Category> getAllCategoriesByType(String type) {
        return this.repository.findCategoryByType(type);
    }

    public Category getCategoryById(Long id) {
        return this.repository.findById(id).get();
    }

    public Category newCategory(Category category) {
        return this.repository.save(category);
    }
}
