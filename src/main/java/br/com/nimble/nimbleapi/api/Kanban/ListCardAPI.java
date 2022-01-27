package br.com.nimble.nimbleapi.api.Kanban;

import br.com.nimble.nimbleapi.model.Kanban.ListCard;
import br.com.nimble.nimbleapi.service.Kanban.ListCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listCard")
public class ListCardAPI {
    @Autowired
    ListCardService service;

    @CrossOrigin
    @Transactional
    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<ListCard> getAllListCards() {
        return this.service.getListCardOrderByIndexAsc();
    }

    @CrossOrigin
    @Transactional
    @RequestMapping(method = RequestMethod.GET, value = "/id")
    public ListCard getListCardById() {
        return this.service.getById(1L);
    }

    @CrossOrigin
    @Transactional
    @RequestMapping(method = RequestMethod.GET, value = "/{index}")
    public ListCard getListCardByIndex(@PathVariable Long index) {
        return this.service.getListCardByIndex(index);
    }

    @CrossOrigin
    @Transactional
    @RequestMapping(method = RequestMethod.PUT, value = "/change-index-list")
    public ListCard changeIndexListCard(@RequestParam(value = "previous") Integer previousIndex,
                                        @RequestBody Integer currentIndex) {
        return this.service.changeIndexListCard(Long.valueOf(previousIndex), Long.valueOf(currentIndex));
    }

    @CrossOrigin
    @Transactional
    @RequestMapping(method = RequestMethod.POST, value = "/newlist")
    public ListCard newListCard(@RequestBody String name) {
        return this.service.newCard(name);
    }
}