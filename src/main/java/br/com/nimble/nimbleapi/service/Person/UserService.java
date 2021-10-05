package br.com.nimble.nimbleapi.service.Person;

import br.com.nimble.nimbleapi.model.Person.Individual;
import br.com.nimble.nimbleapi.model.Person.User;
import br.com.nimble.nimbleapi.repository.Person.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public User createUser(User resource) {
        this.repository.save(resource);
        return resource;
    }

    public Boolean validateLogin(String login, String password) {
        return this.repository.validateLogin(login, password);
    }
}
