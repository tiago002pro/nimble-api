package br.com.nimble.nimbleapi.service.Kanban;

import br.com.nimble.nimbleapi.repository.Kanban.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {
    @Autowired
    ActivityRepository repository;
}