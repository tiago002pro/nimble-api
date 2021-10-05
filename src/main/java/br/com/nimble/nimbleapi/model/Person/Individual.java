package br.com.nimble.nimbleapi.model.Person;

import com.fasterxml.jackson.annotation.JsonSubTypes;
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
@JsonSubTypes({
        @JsonSubTypes.Type(value = User.class, name = "Company"),})
@Table(name = "individual")
public class Individual extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "rg")
    private String rg;

    @Column(name = "gender")
    private String gender;

    public Individual() {
    }

    public Individual(String name, List<Address> addresses, List<Phone> phones, List<Email> emails, List<Document> documents, List<Rule> ruleList, String cpf, String rg, String gender) {
        super(name, addresses, phones, emails, documents, ruleList);
        this.cpf = cpf;
        this.rg = rg;
        this.gender = gender;
    }
}
