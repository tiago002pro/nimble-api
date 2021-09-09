package br.com.nimble.nimbleapi.service.Person;

import br.com.nimble.nimbleapi.model.Person.Juridica;
import br.com.nimble.nimbleapi.repository.Person.JuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class JuridicaService {

    @Autowired(required=true)
    JuridicaRepository repository;

    public String createPersonJuridica(Map<String, Object> json) {
        Juridica juridica = new Juridica();

        juridica.setName((String) json.get("Nome"));
        juridica.setShort_name((String) json.get("Razão Social"));
        juridica.setCnpj((String) json.get("Cnpj"));
        juridica.setIe((String) json.get("Ie"));
        this.repository.save(juridica);

        return "Pessoa Juridica cadastrada com sucesso";
    }

    public List<Juridica> getLisPersonJuridica() {
        return this.repository.findAll();
    }
}
