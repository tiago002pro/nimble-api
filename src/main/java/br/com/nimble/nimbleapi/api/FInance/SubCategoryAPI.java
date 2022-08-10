package br.com.nimble.nimbleapi.api.FInance;

import br.com.nimble.nimbleapi.service.Finance.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sub-category")
public class SubCategoryAPI {
    @Autowired
    SubCategoryService service;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public ResponseEntity getAllSubCategories() {
        return ResponseEntity.ok(this.service.getAllSubCategories());
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/all/{type}")
    public ResponseEntity getAllCategoriesByType(@RequestParam(value = "type") String type) {
        return ResponseEntity.ok(this.service.getAllSubCategoriesByType(type));
    }

}
