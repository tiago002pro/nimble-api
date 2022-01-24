package br.com.nimble.nimbleapi.api.Kanban;

import br.com.nimble.nimbleapi.service.Kanban.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/activity")
public class ActivityAPI {
    @Autowired
    private ActivityService service;
}