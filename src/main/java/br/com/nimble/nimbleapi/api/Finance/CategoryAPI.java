package br.com.nimble.nimbleapi.api.Finance;

import br.com.nimble.nimbleapi.model.Finance.Category;
import br.com.nimble.nimbleapi.service.Finance.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryAPI {
    @Autowired
    CategoryService service;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/new")
    public ResponseEntity newCategory(@RequestBody Category category) {
        return ResponseEntity.ok(this.service.newCategory(category));
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public ResponseEntity getAllCategories() {
        return ResponseEntity.ok(this.service.getAllCategories());
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/all/type/{type}")
    public ResponseEntity getAllCategoriesByType(@PathVariable String type) {
        return ResponseEntity.ok(this.service.getAllCategoriesByType(type));
    }


}