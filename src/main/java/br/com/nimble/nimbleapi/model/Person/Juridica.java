package br.com.nimble.nimbleapi.model.Person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="person_id")
@Table(name = "juridica")
public class Juridica extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "ie")
    private String ie;

    public Juridica() {
    }

    public Juridica(String name, List<Address> addresses, List<Phone> phones, List<Email> emails, List<Document> documents, List<Rule> ruleList, String shortName, String cnpj, String ie) {
        super(name, addresses, phones, emails, documents, ruleList);
        this.shortName = shortName;
        this.cnpj = cnpj;
        this.ie = ie;
    }
}
