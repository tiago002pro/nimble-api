package br.com.nimble.nimbleapi.api.FInance;

import br.com.nimble.nimbleapi.model.Finance.Title;
import br.com.nimble.nimbleapi.service.Finance.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Title> getTitlesByType(@RequestParam(value = "type") String type) {
        return this.service.getTitlesByType(type);
    }
}
