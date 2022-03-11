package br.com.nimble.nimbleapi.api.FInance;

import br.com.nimble.nimbleapi.model.Finance.Title;
import br.com.nimble.nimbleapi.service.Finance.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/title")
public class TitleAPI {
    @Autowired
    TitleService service;

    @CrossOrigin
    @Transactional
    @RequestMapping(method = RequestMethod.POST, value = "/form")
    public List<Title> createTitle(@RequestBody List<Title> resource)  {
        return this.service.createTitle(resource);
    }

    @CrossOrigin
    @Transactional
    @RequestMapping(method = RequestMethod.GET, value = "/history")
    public ResponseEntity getTitlesByType(@RequestParam(value = "type") String type,
                                          @RequestParam(defaultValue = "1", required = false) int page,
                                          @RequestParam(defaultValue = "10", required = false) int size) {
        return ResponseEntity.ok(this.service.getTitlesByType(type, PageRequest.of(page > 0 ? --page : 0, size)));


    }
}
