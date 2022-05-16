package br.com.nimble.nimbleapi.api.FInance;

import br.com.nimble.nimbleapi.model.Finance.Category;
import br.com.nimble.nimbleapi.service.Finance.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryAPI {
    @Autowired
    CategoryService service;

    @CrossOrigin
    @Transactional
    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public ResponseEntity getAllCategoriesByType(@RequestParam(value = "type") String type) {
        return ResponseEntity.ok(this.service.getAllCategoriesByType(type));
    }

    @CrossOrigin
    @Transactional
    @RequestMapping(method = RequestMethod.POST, value = "/category-form")
    public ResponseEntity newCategory(@RequestBody Category category) {
        return ResponseEntity.ok(this.service.newCategory(category));
    }
}