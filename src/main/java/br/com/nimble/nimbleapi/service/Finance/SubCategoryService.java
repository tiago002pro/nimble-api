package br.com.nimble.nimbleapi.service.Finance;

import br.com.nimble.nimbleapi.model.Finance.SubCategory;
import br.com.nimble.nimbleapi.repository.Finance.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SubCategoryService {
    @Autowired
    SubCategoryRepository repository;

    @Transactional
    public List<SubCategory> getAllSubCategories() {
        return this.repository.findAll();
    }

    @Transactional
    public List<SubCategory> getAllSubCategoriesByType(String type) {
        return this.repository.findSubCategoryByType(type);
    }

    @Transactional
    public SubCategory getSubCategoryById(Long id) {
        return this.repository.findById(id).get();
    }
}
