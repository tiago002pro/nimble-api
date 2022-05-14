package br.com.nimble.nimbleapi.service.Finance;

import br.com.nimble.nimbleapi.model.Finance.Title;
import br.com.nimble.nimbleapi.repository.Finance.TitleRepository;
import br.com.nimble.nimbleapi.service.Person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitleService {
    @Autowired
    TitleRepository repository;
    @Autowired
    PersonService personService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    AccountService accountService;

    public List<Title> createTitle(List<Title>  resource) {
        resource.forEach((title) -> {
            title.setPerson(this.personService.getById(title.getPerson().getId()));
            title.setCategory(this.categoryService.getCategoryById(title.getCategory().getId()));
        });
        return this.repository.saveAll(resource);
    }

    public Page<Title>  getTitlesByType(String type, Pageable pageable) {
        return this.repository.findTitlesByType(type, pageable);
    }

    public Title getById(Long id) {
        return this.repository.findById(id).get();
    }

    public List<Title> paidTitle(List<Title> titleList) {
        titleList.forEach((title) -> {
            title.setPerson(this.personService.getById(title.getPerson().getId()));
            title.setCategory(this.categoryService.getCategoryById(title.getCategory().getId()));
        });
        return this.repository.saveAll(titleList);
    }

    public Page<Title> getTitlesByAccountId(Long accountId, Pageable pageable) {
        return this.repository.findTitlesByAccountId(accountId, pageable);
    }
}