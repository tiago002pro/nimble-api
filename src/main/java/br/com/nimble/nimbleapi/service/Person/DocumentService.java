package br.com.nimble.nimbleapi.service.Person;

import br.com.nimble.nimbleapi.model.Person.Document;
import br.com.nimble.nimbleapi.model.Person.Email;
import br.com.nimble.nimbleapi.model.Person.Person;
import br.com.nimble.nimbleapi.repository.Person.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DocumentService {

    @Autowired
    DocumentRepository repository;

    @Autowired
    PersonService personService;

    public void saveDocument(Long idPerson, Map<String, String> json) {
        Person person = personService.getById(idPerson);
        Document document = new Document(
                json.get("docName"),
                json.get("url")
        );

        person.getDocuments().add(document);
        this.repository.save(document);
    }
}
